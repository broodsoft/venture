package com.broodsoft.db4o;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Person extends Model
{
	public enum Sex{ MALE, FEMALE; }

	private final Date birth;
	private final Sex sex;
	private final Person father;
	private final Person mother;
	private final Set<Person> children;

	private String first;
	private String last;
	private Address address;

	private Person spouse; 
	private Date death;

	public Person
	(
		Date birth,
		Sex sex,
		Person father,
		Person mother,
		String first,
		String last,
		Address address
	)
	{
		this.birth = birth;
		this.sex = sex;
		this.father = father;
		this.mother = mother;
		this.first = first;
		this.last = last;
		this.address = address;
		this.children = new HashSet<Person>();
		this.spouse = null;
	}

	public Date getDod(){ return death; }
	public void setDod(Date death){ this.death = death; }

	public Date getDob(){ return birth; }
	public Sex getSex(){ return sex; }

	public Person getFather(){ return father; }
	public Person getMother(){ return mother; }

	public Person getSpouse(){ return spouse; }
	public void setSpouse(Person spouse){ this.spouse = spouse; }

	public Collection<Person> getChildren(){ return children; }

	public String getFirst(){ return first; }
	public void setFirst(String first){ this.first = first; }

	public String getLast(){ return last; }
	public void setLast(String last){ this.last = last; }

	public Address getAddress(){ return address; }
	public void setAddress(Address address){ this.address = address; }
}
