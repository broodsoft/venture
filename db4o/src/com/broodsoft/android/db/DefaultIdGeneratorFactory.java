package com.broodsoft.android.db;

import com.broodsoft.brew.doc.CodeAuthor;
import com.broodsoft.brew.generator.DataGenerator;
import com.broodsoft.brew.generator.SequentialIntegerGenerator;
import com.broodsoft.brew.generator.SequentialLongGenerator;

@CodeAuthor(first = "Drazzle", last = "Bay")
public class DefaultIdGeneratorFactory implements IdGeneratorFactory
{
	@Override
	@SuppressWarnings("unchecked")
	public <T,I> DataGenerator<I> create(Class<T> type, Class<I> idFieldType)
	{
		if
		(
			idFieldType.equals(int.class) ||
			idFieldType.equals(Integer.class)
		)
			return (DataGenerator<I>) new SequentialIntegerGenerator();
		if
		(
			idFieldType.equals(long.class) ||
			idFieldType.equals(Long.class)
		)
			return (DataGenerator<I>) new SequentialLongGenerator();

		throw new UnsupportedOperationException("There is no support for generating IDs of type '"+idFieldType.getName()+"'");
	}
}
