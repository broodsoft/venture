package com.broodsoft.venture.jpa;

import com.broodsoft.venture.jpa.model.Address;
import com.broodsoft.venture.jpa.model.Gender;
import com.broodsoft.venture.jpa.model.Name;
import com.broodsoft.venture.jpa.model.Person;
import com.broodsoft.venture.jpa.model.PhoneNumber;
import com.broodsoft.venture.jpa.model.PhoneNumber.Category;

import java.util.Date;
import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Person.class)
public abstract class Person_ extends com.broodsoft.venture.jpa.UniqueEntity_ {

	public static volatile SingularAttribute<Person, Date> dateOfBirth;
	public static volatile SingularAttribute<Person, Address> address;
	public static volatile MapAttribute<Person, Category, PhoneNumber> phoneNumberLookup;
	public static volatile SingularAttribute<Person, Name> name;
	public static volatile SingularAttribute<Person, Gender> gender;

}

