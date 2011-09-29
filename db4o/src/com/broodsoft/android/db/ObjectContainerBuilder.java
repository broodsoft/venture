package com.broodsoft.android.db;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Set;

import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;

import com.broodsoft.brew.builder.Builder;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;

public class ObjectContainerBuilder implements Builder<ObjectContainer>
{
	protected boolean doAutoReset;

	protected String filepath;
	protected EmbeddedConfiguration configuration;
	protected boolean doAutoManageIds;
	protected Class<? extends Annotation>[] indexIndicators;

	public ObjectContainerBuilder()
	{
		this(true);
	}

	public ObjectContainerBuilder(boolean doAutoReset)
	{
		this.doAutoReset = doAutoReset;
	}

	protected EmbeddedConfiguration getConfiguration()
	{
		if(configuration == null)
			configuration = Db4oEmbedded.newConfiguration();
		return configuration;
	}

	public ObjectContainerBuilder writeTo(String filepath)
	{
		this.filepath = filepath;
		return this;
	}

	public ObjectContainerBuilder configure(EmbeddedConfiguration configuration)
	{
		this.configuration = configuration;
		return this;
	}

	public ObjectContainerBuilder autoManageIds()
	{
		doAutoManageIds = true;
		return this;
	}

	@SuppressWarnings("unchecked")
	public ObjectContainerBuilder index(Class<? extends Annotation> indexIndicator)
	{
		return index((Class<? extends Annotation>[])(new Class<?>[]{indexIndicator}));
	}

	public ObjectContainerBuilder index(Class<? extends Annotation>[] indexIndicators)
	{
		this.indexIndicators = indexIndicators;
		return this;
	}

	@Override
	public ObjectContainer build()
	{
		if(indexIndicators != null)
		{
			Reflections r = new Reflections("", new FieldAnnotationsScanner());
			for(Class<? extends Annotation> indexIndicator : indexIndicators)
			{
				Set<Field> indexedFields = r.getFieldsAnnotatedWith(indexIndicator);
				for(Field indexedField : indexedFields)
					getConfiguration().common().objectClass(indexedField.getDeclaringClass()).objectField(indexedField.getName()).indexed(true);
			}
		}

		ObjectContainer db = Db4oEmbedded.openFile(getConfiguration(), filepath);

		if(doAutoManageIds)
			new Db4oIdGeneratorRegistry(db);

		if(doAutoReset)
			reset();

		configuration = null;
		return db;
	}

	@Override
	public void reset()
	{
		filepath = null;
		indexIndicators = null;
		configuration = null;
		doAutoManageIds = false;
	}
}
