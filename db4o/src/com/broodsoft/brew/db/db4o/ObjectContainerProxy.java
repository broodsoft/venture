package com.broodsoft.brew.db.db4o;

import com.db4o.ObjectContainer;

public abstract class ObjectContainerProxy implements ObjectContainer
{
	protected ObjectContainer delegate;

	protected ObjectContainerProxy(ObjectContainer delegate)
	{
		this.delegate = delegate;
	}
}
