package com.broodsoft.venture.jpa;

import com.broodsoft.brew.doc.CodeAuthor;

@CodeAuthor(first = "Drazzle", last = "Bay")
public enum JPA2DemoPersistence
{
	PU;

	public final JPA2DemoDatabaseConnection connection;

	private JPA2DemoPersistence()
	{
		connection = new JPA2DemoDatabaseConnection();
		connection.open();
	}
}
