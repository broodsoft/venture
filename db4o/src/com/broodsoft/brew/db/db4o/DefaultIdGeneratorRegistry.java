package com.broodsoft.brew.db.db4o;

import java.util.HashMap;
import java.util.Map;

import com.broodsoft.brew.doc.CodeAuthor;
import com.broodsoft.brew.generator.DataGenerator;

@CodeAuthor(first = "Drazzle", last = "Bay")
public final class DefaultIdGeneratorRegistry implements IdGeneratorRegistry
{
	private final Map<Class<?>, DataGenerator<?>> generatorsByType;

	public DefaultIdGeneratorRegistry()
	{
		generatorsByType = new HashMap<Class<?>, DataGenerator<?>>();
	}

	public <T> boolean isRegistered(Class<T> type){ return generatorsByType.containsKey(type); }

	public <T,I> void register(Class<T> type, DataGenerator<I> generator)
	{
		if(generator == null)
			throw new NullPointerException("Generator cannot be null");
		if(type == null)
			throw new NullPointerException("Type cannot be null");
		generatorsByType.put(type, generator);
	}

	@SuppressWarnings("unchecked")
	public <T,I> DataGenerator<I> get(Class<T> type)
	{
		return (DataGenerator<I>)generatorsByType.get(type);
	}

	@SuppressWarnings("unchecked")
	public <T,I> I generateId(Class<T> type)
	{
		return (I)get(type).generate();
	}
}
