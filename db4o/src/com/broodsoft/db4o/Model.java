package com.broodsoft.db4o;

import com.broodsoft.brew.Unique;
import com.broodsoft.brew.db.db4o.Db4oId;

public abstract class Model implements Unique<Integer>
{
	@Db4oId
	private int id;

	@Override
	public Integer getId(){ return id; }
}
