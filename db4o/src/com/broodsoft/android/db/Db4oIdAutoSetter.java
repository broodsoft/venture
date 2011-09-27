package com.broodsoft.android.db;

import java.lang.reflect.Field;

import com.broodsoft.brew.generator.DataGenerator;
import com.broodsoft.brew.util.AnnotationUtils;
import com.db4o.events.Event4;
import com.db4o.events.EventListener4;
import com.db4o.events.ObjectEventArgs;

public class Db4oIdAutoSetter<T extends ObjectEventArgs> implements EventListener4<T>
{
	protected IdGeneratorRegistry idGeneratorRegistry;
	protected IdGeneratorFactory idGeneratorFactory;

	public Db4oIdAutoSetter(IdGeneratorRegistry idGeneratorRegistry)
	{
		this(idGeneratorRegistry, new DefaultIdGeneratorFactory());
	}
	
	public Db4oIdAutoSetter(IdGeneratorRegistry idGeneratorRegistry, IdGeneratorFactory idGeneratorFactory)
	{
		this.idGeneratorRegistry = idGeneratorRegistry;
		this.idGeneratorFactory = idGeneratorFactory;
	}

	@Override
	public void onEvent(Event4<T> event, T args)
	{
		Object object = args.object();
		Class<?> type = object.getClass();
		Field idField = AnnotationUtils.searchDepthFirstForAnnotatedField(type, Id.class);
		if(idField != null)
		{
			Object id = generateId(type, idField.getType());
			try
			{
				idField.setAccessible(true);
				idField.set(object, id);
				idField.setAccessible(false);
			}
			catch(IllegalAccessException iae){}
		}
	}

	protected synchronized <C,I> I generateId(Class<C> type, Class<I> idFieldType)
	{
		DataGenerator<I> generator = idGeneratorRegistry.get(type);
		if(generator == null)
		{
			generator = idGeneratorFactory.create(type, idFieldType);
			idGeneratorRegistry.register(type, generator);
		}
		return generator.generate();
	}
}
