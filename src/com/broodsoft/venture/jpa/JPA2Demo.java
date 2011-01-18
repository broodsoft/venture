package com.broodsoft.venture.jpa;

import static com.broodsoft.venture.jpa.JPA2DemoPersistence.PU;
import static com.broodsoft.venture.jpa.model.Gender.*;
import static com.broodsoft.venture.jpa.model.PhoneNumber.Category.*;

import java.util.Calendar;
import java.util.Collection;

import com.broodsoft.brew.db.jpa.JPAStatement;
import com.broodsoft.brew.doc.CodeAuthor;
import com.broodsoft.venture.jpa.manager.PersonManager;
import com.broodsoft.venture.jpa.model.*;
import com.broodsoft.venture.jpa.model.school.*;

@CodeAuthor(first = "Drazzle", last = "Bay")
public class JPA2Demo
{
	public static void main(String[] args)
	{
		populateDatabase();
		testQueries();
	}

	public static void populateDatabase()
	{
		PU.connection.execute(new JPAStatement()
		{
			@Override
			protected void executeStatement()
			{
				Calendar c = Calendar.getInstance();

				c.set(1624, 2, 24);
				Person Drazzle = new Person(MALE, c.getTime(), new Name("Drazzle", "A", "Bay"));
				Drazzle.setAddress(new Address("13 Lucky St.", "Awesomeville", "XZ", 13666));
				Drazzle.addPhoneNumber(new PhoneNumber(CELL, 666, 999, 1313));
				Drazzle.addPhoneNumber(new PhoneNumber(HOME, 123, 444, 9874));
				Drazzle.addPhoneNumber(new PhoneNumber(OTHER, 321, 123, 4567));
				getEntityManager().persist(Drazzle);

				c.set(1623, 5, 11);
				Person roomie = new Person(MALE, c.getTime(), new Name("Room", "Mate"));
				roomie.setAddress(Drazzle.getAddress());
				roomie.addPhoneNumber(new PhoneNumber(CELL, 999, 666, 1313));
				roomie.addPhoneNumber(Drazzle.getPhoneNumber(HOME));
				getEntityManager().persist(roomie);

				c.set(1601, 9, 5);
				Person dad = new Person(MALE, c.getTime(), new Name("Drazzle", "R", "Bay"));
				dad.setAddress(new Address("7 Super Blvd.", "Cool City", "UQ", 55674));
				dad.addPhoneNumber(new PhoneNumber(CELL, 111, 555, 1234));
				dad.addPhoneNumber(Drazzle.getPhoneNumber(OTHER));
				getEntityManager().persist(dad);

				Student s = new Student(702963803, Drazzle);
				getEntityManager().persist(s);
				Athlete a = new Athlete(s);
				getEntityManager().persist(s);

				Roster xcVarsity = new Roster(Roster.Type.MALE_VARSITY, a);
				Roster xcJV = new Roster(Roster.Type.MALE_JUNIOR_VARSITY);
				Team xc = new Team("xc", xcVarsity, xcJV);
				getEntityManager().persist(xc);

				Roster nordicVarsity = new Roster(Roster.Type.MALE_VARSITY, a);
				Roster nordicJV = new Roster(Roster.Type.MALE_JUNIOR_VARSITY);
				Team nordic = new Team("nordic", nordicVarsity, nordicJV);
				getEntityManager().persist(nordic);
			}
		});
	}

	public static void testQueries()
	{
		findPeopleByFirstName("Drazzle");

		findPhoneNumberOwners(123, 444, 9874);
		findPhoneNumberOwners(321, 123, 4567);
	}

	public static void findPeopleByFirstName(String firstName)
	{
		Collection<Person> peopleWithSameFirstName = PU.connection.getPersonManager().findPeopleByFirstName(firstName);
		System.out.println("Found "+peopleWithSameFirstName.size()+" people who share the same first name");
		for(Person person : peopleWithSameFirstName)
			System.out.println("\t"+person.getName());
	}

	public static void findPhoneNumberOwners(int areaCode, int firstThree, int lastFour)
	{
		Collection<PhoneNumber> phoneNumbers = PU.connection.getQueryAdapter(PersonManager.class).findPhoneNumber(areaCode, firstThree, lastFour);
		for(PhoneNumber phoneNumber : phoneNumbers)
		{
			System.out.println("Phone number "+phoneNumber+" is shared by: ");
			for(Person owner : phoneNumber.getOwners())
				System.out.println("\t"+owner.getName());
		}
	}
}
