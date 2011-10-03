package com.broodsoft.brew.db.db4o;

import com.broodsoft.brew.generator.DataGenerator;

public interface IdGeneratorRegistry
{
	<T> boolean isRegistered(Class<T> type);
	<T,I> void register(Class<T> type, DataGenerator<I> generator);
	<T,I> DataGenerator<I> get(Class<T> type);
	<T,I> I generateId(Class<T> type);
}
