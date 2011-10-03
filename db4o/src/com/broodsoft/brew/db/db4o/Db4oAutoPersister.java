package com.broodsoft.brew.db.db4o;

import com.db4o.ObjectContainer;
import com.db4o.events.Event4;
import com.db4o.events.EventArgs;
import com.db4o.events.EventListener4;

public class Db4oAutoPersister<O, T extends EventArgs> implements EventListener4<T>
{
	protected final ObjectContainer db;
	protected final O entity;
	protected final int depth;

	public Db4oAutoPersister(ObjectContainer db, O entity, int depth)
	{
		this.db = db;
		this.entity = entity;
		this.depth = depth;
	}

	public void onEvent(Event4<T> event, T args)
	{
		db.ext().store(entity, depth);
	}
}
