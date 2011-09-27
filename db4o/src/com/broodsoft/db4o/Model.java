package com.broodsoft.db4o;

import com.broodsoft.android.db.Id;
import com.broodsoft.brew.Unique;

public abstract class Model implements Unique<Integer>
{
	@Id
	private int id;

	@Override
	public Integer getId(){ return id; }
}
