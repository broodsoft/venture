package com.broodsoft.venture.jpa;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.broodsoft.venture.jpa.model.Address;
import com.broodsoft.venture.jpa.model.Person;

@StaticMetamodel(Address.class)
public abstract class Address_ extends com.broodsoft.venture.jpa.UniqueEntity_ {

	public static volatile SingularAttribute<Address, String> region;
	public static volatile SingularAttribute<Address, Integer> zip;
	public static volatile SingularAttribute<Address, String> street;
	public static volatile SetAttribute<Address, Person> residents;
	public static volatile SingularAttribute<Address, String> country;
	public static volatile SingularAttribute<Address, String> city;

}

