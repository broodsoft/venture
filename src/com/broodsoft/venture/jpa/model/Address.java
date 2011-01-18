package com.broodsoft.venture.jpa.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.broodsoft.brew.doc.CodeAuthor;

@Entity
@CodeAuthor(first = "Drazzle", last = "Bay")
public class Address extends UniqueEntity
{
	private static final long serialVersionUID = -4621203234210059881L;

	public static final String FOREIGN_KEY_NAME = "address";

	protected String street;
	protected String city;
	protected String region;
	protected int zip;
	protected String country;

	@OneToMany(mappedBy = "address")
	protected Set<Person> residents;

	protected Address()
	{
		this(null, null, null, -1, null);
	}

	public Address(String street, String city, String region, int zip)
	{
		this(street, city, region, zip, "United States of America");
	}

	public Address(String street, String city, int zip, String country)
	{
		this(street, city, "", zip, country);
	}

	public Address(String street, String city, String region, int zip, String country)
	{
		this.street = street;
		this.city = city;
		this.region = region;
		this.zip = zip;
		this.country = country;

		residents = new HashSet<Person>();
	}

	public String getStreet(){ return street; }
	public String getCity(){ return city; }
	public String getRegion(){ return region; }
	public int getZip(){ return zip; }
	public String getCountry(){ return country; }

	public void addResident(Person resident){ residents.add(resident); }
	public void removeResident(Person resident){ residents.remove(resident); }

	@Override
	public String toString()
	{
		return String.format("%1$s\n%2$s, %3$s %4$s\n%5$s", street, city, region, zip, country);
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;

		result = prime * result + ((city == null)    ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((region == null)  ? 0 : region.hashCode());
		result = prime * result + ((street == null)  ? 0 : street.hashCode());
		result = prime * result + zip;

		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if(obj == this)
			return true;

		if(!(obj instanceof Person))
			return false;

		Address other = (Address)obj;
		return
			zip == other.zip &&
			street.equals(other.street) &&
			city.equals(other.city) &&
			region.equals(other.region) &&
			country.equals(other.country);
	}

	
}
