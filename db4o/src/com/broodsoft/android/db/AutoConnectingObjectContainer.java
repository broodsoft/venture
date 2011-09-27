package com.broodsoft.android.db;

import java.util.Comparator;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.ext.DatabaseClosedException;
import com.db4o.ext.DatabaseReadOnlyException;
import com.db4o.ext.Db4oIOException;
import com.db4o.ext.ExtObjectContainer;
import com.db4o.query.Predicate;
import com.db4o.query.Query;
import com.db4o.query.QueryComparator;

public class AutoConnectingObjectContainer extends ObjectContainerProxy
{
	protected ObjectContainerBuilder builder;
	protected boolean doAutoCommit;

	public AutoConnectingObjectContainer(ObjectContainer delegate, ObjectContainerBuilder builder)
	{
		super(delegate);

		this.builder = builder;
		this.doAutoCommit = false;
	}

	protected ObjectContainer getDelegate()
	{
		if(delegate == null || delegate.ext().isClosed())
			delegate = builder.build();
		return delegate;
	}

	public void setDoAutoCommit(boolean doAutoCommit){ this.doAutoCommit = doAutoCommit; }

	@Override
	public void activate(Object arg0, int arg1) throws Db4oIOException, DatabaseClosedException
	{
		getDelegate().activate(arg0, arg1);
	}

	@Override
	public boolean close() throws Db4oIOException
	{
		return getDelegate().close();
	}

	@Override
	public void commit() throws Db4oIOException, DatabaseClosedException, DatabaseReadOnlyException
	{
		getDelegate().commit();
	}

	@Override
	public void deactivate(Object arg0, int arg1) throws DatabaseClosedException
	{
		getDelegate().deactivate(arg0, arg1);
	}

	@Override
	public void delete(Object arg0) throws Db4oIOException, DatabaseClosedException, DatabaseReadOnlyException
	{
		getDelegate().delete(arg0);
	}

	@Override
	public ExtObjectContainer ext()
	{
		return getDelegate().ext();
	}

	@Override
	public Query query() throws DatabaseClosedException
	{
		return getDelegate().query();
	}

	@Override
	public <TargetType> ObjectSet<TargetType> query(Class<TargetType> arg0) throws Db4oIOException, DatabaseClosedException
	{
		return getDelegate().query(arg0);
	}

	@Override
	public <TargetType> ObjectSet<TargetType> query(Predicate<TargetType> arg0, Comparator<TargetType> arg1) throws Db4oIOException, DatabaseClosedException
	{
		return getDelegate().query(arg0, arg1);
	}

	@Override
	public <TargetType> ObjectSet<TargetType> query(Predicate<TargetType> arg0, QueryComparator<TargetType> arg1) throws Db4oIOException, DatabaseClosedException
	{
		return getDelegate().query(arg0, arg1);
	}

	@Override
	public <TargetType> ObjectSet<TargetType> query(Predicate<TargetType> arg0) throws Db4oIOException, DatabaseClosedException
	{
		return getDelegate().query(arg0);
	}

	@Override
	public <T> ObjectSet<T> queryByExample(Object arg0) throws Db4oIOException, DatabaseClosedException
	{
		return getDelegate().queryByExample(arg0);
	}

	@Override
	public void rollback() throws Db4oIOException, DatabaseClosedException, DatabaseReadOnlyException
	{
		getDelegate().rollback();
	}

	@Override
	public void store(Object arg0) throws DatabaseClosedException, DatabaseReadOnlyException
	{
		getDelegate().store(arg0);
		if(doAutoCommit)
			getDelegate().commit();
	}
}
