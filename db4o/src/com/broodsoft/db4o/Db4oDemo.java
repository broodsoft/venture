package com.broodsoft.db4o;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.broodsoft.brew.db.db4o.AutoConnectingObjectContainer;
import com.broodsoft.brew.db.db4o.Db4oId;
import com.broodsoft.brew.db.db4o.ObjectContainerBuilder;
import com.broodsoft.db4o.Person.Sex;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

public class Db4oDemo
{
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("MM/dd/yy");

	private String dbFilepath;
	private ObjectContainer db;

	public Db4oDemo(String dbFilepath)
	{
		this.dbFilepath = dbFilepath;
	}

	public void reset()
	{
		new File(dbFilepath).delete();
	}

	public void prepare()
	{
		ObjectContainerBuilder builder = new ObjectContainerBuilder(false)
			.writeTo(dbFilepath)
			.index(Db4oId.class)
			.autoManageIds();
		AutoConnectingObjectContainer db = new AutoConnectingObjectContainer(builder.build(), builder);
		db.setDoAutoCommit(true);
		this.db = db;
	}

	public void create() throws Exception
	{
		Census usa = new Census();

		Address marshFamilyAddress = new Address("1a", "Main St", "South Park", "CO", 12345);

		Person randy = usa.register(DATE_FORMAT.parse("01/01/1970"), Sex.MALE, null, null, "Randy", "Marsh", marshFamilyAddress);
		Person sharon = usa.register(DATE_FORMAT.parse("01/01/1970"), Sex.MALE, null, null, "Sharon", "?", marshFamilyAddress);
		usa.registerMarriage(randy, sharon);

		Person stan = usa.register(DATE_FORMAT.parse("01/01/1995"), Sex.MALE, randy, sharon, "Stan", randy.getLast(), marshFamilyAddress);
		Person shelley = usa.registerBirth(Sex.MALE, randy, sharon, "Shelley", randy.getLast(), marshFamilyAddress);

		db.store(usa);
	}

	public void query()
	{
		Query query = db.query();
		query.constrain(Person.class);
		query.descend("address").descend("state").constrain("CO");
		ObjectSet<Person> results = query.execute();
		for(Person result : results)
			System.out.println(String.format("%1$s %2$s", result.getFirst(), result.getLast()));
	}

	public void finish()
	{
		db.close();
	}
}
