package com.broodsoft.brew.db.db4o;

import com.broodsoft.brew.generator.DataGenerator;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.events.CancellableObjectEventArgs;
import com.db4o.events.CommitEventArgs;
import com.db4o.events.EventRegistry;
import com.db4o.events.EventRegistryFactory;

public final class Db4oIdGeneratorRegistry implements IdGeneratorRegistry
{
	private final ObjectContainer db;
	private IdGeneratorRegistry delegate;

	public Db4oIdGeneratorRegistry(ObjectContainer db)
	{
		this(db, true);
	}

	public Db4oIdGeneratorRegistry(ObjectContainer db, boolean doPrepare)
	{
		this.db = db;
		this.delegate = null;

		if(doPrepare)
			prepare();
	}

	public synchronized void prepare()
	{
		ObjectSet<IdGeneratorRegistry> idGenerators = db.query(IdGeneratorRegistry.class);
		switch(idGenerators.size())
		{
			case 0:
				delegate = new DefaultIdGeneratorRegistry();
				break;
			case 1:
				delegate = idGenerators.get(0);
				break;
			default:
				throw new IllegalStateException("Multiple ID generators found");
		}

		EventRegistry eventRegistry = EventRegistryFactory.forObjectContainer(db);
		eventRegistry.creating().addListener(new Db4oIdAutoSetter<CancellableObjectEventArgs>(delegate));
		eventRegistry.committing().addListener(new Db4oAutoPersister<IdGeneratorRegistry,CommitEventArgs>(db, delegate, 3));
	}

	public <T> boolean isRegistered(Class<T> type){ return delegate.isRegistered(type); }
	public <T,I> void register(Class<T> type, DataGenerator<I> generator){ delegate.register(type, generator); }
	public <T,I> DataGenerator<I> get(Class<T> type){ return delegate.get(type); }
	public <T,I> I generateId(Class<T> type){ return delegate.generateId(type); }
}
