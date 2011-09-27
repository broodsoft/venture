package com.broodsoft.db4o;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.broodsoft.db4o.Person.Sex;

public class Census
{
	private final Set<Person> people;
	private final Set<Person> deceased;

	public Census()
	{
		people = new HashSet<Person>();
		deceased = new HashSet<Person>();
	}

	public Person registerBirth
	(
		Sex sex,
		Person father,
		Person mother,
		String first,
		String last,
		Address address
	)
	{
		Person person = register(Calendar.getInstance().getTime(), sex, father, mother, first, last, address);
		father.getChildren().add(person);
		mother.getChildren().add(person);
		return person;
	}

	public Person register
	(
		Date dob,
		Sex sex,
		Person father,
		Person mother,
		String first,
		String last,
		Address address
	)
	{
		Person person = new Person
		(
			dob,
			sex,
			father,
			mother,
			first,
			last,
			address
		);
		people.add(person);
		return person;
		
	}

	public void registerDeath(Person person, Date date)
	{
		person.setDod(date);
		people.remove(person);
		deceased.add(person);
	}

	public void registerMarriage(Person p1, Person p2)
	{
		p1.setSpouse(p2);
		p2.setSpouse(p1);
		p2.setLast(p1.getLast());
	}

	public void registerDivorce(Person p1, Person p2)
	{
		p1.setSpouse(null);
		p2.setSpouse(null);
	}
}
