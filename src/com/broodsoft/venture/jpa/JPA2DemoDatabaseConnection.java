package com.broodsoft.venture.jpa;

import com.broodsoft.brew.doc.CodeAuthor;
import com.broodsoft.brew.db.jpa.JPADatabaseConnection;
import com.broodsoft.venture.jpa.manager.PersonManager;

@CodeAuthor(first = "Drazzle", last = "Bay")
public class JPA2DemoDatabaseConnection extends JPADatabaseConnection
{
	private static final String PU_NAME = "JPA2DemoPU";

	private PersonManager personManager;

	public JPA2DemoDatabaseConnection()
	{
		super(PU_NAME);
	}

	public PersonManager getPersonManager()
	{
		if(personManager == null)
		{
			personManager = new PersonManager(manager);
			queryAdapters.put(PersonManager.class, personManager);
		}

		return personManager;
	}
}
