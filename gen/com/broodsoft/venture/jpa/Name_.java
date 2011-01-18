package com.broodsoft.venture.jpa;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.broodsoft.venture.jpa.model.Name;

@StaticMetamodel(Name.class)
public abstract class Name_ {

	public static volatile SingularAttribute<Name, String> middleName;
	public static volatile SingularAttribute<Name, String> lastName;
	public static volatile SingularAttribute<Name, Integer> hashCode;
	public static volatile SingularAttribute<Name, String> firstName;

}

