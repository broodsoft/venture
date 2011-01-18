package com.broodsoft.venture.jpa;

import com.broodsoft.venture.jpa.model.Person;
import com.broodsoft.venture.jpa.model.PhoneNumber;
import com.broodsoft.venture.jpa.model.PhoneNumber.Category;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(PhoneNumber.class)
public abstract class PhoneNumber_ extends com.broodsoft.venture.jpa.UniqueEntity_ {

	public static volatile SingularAttribute<PhoneNumber, Integer> extension;
	public static volatile SingularAttribute<PhoneNumber, Category> category;
	public static volatile SingularAttribute<PhoneNumber, Integer> areaCode;
	public static volatile SingularAttribute<PhoneNumber, Integer> firstThree;
	public static volatile SingularAttribute<PhoneNumber, Integer> countryCode;
	public static volatile SingularAttribute<PhoneNumber, Integer> lastFour;
	public static volatile SetAttribute<PhoneNumber, Person> owners;

}

