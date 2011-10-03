package com.broodsoft.brew.db.db4o;

import com.broodsoft.brew.doc.CodeAuthor;
import com.broodsoft.brew.generator.DataGenerator;

@CodeAuthor(first = "Drazzle", last = "Bay")
public interface IdGeneratorFactory
{
	<T,I> DataGenerator<I> create(Class<T> type, Class<I> idFieldType);
}
