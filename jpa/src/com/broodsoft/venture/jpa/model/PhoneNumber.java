package com.broodsoft.venture.jpa.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.broodsoft.brew.doc.CodeAuthor;

@Entity
@Table(name = "phone_number")
@CodeAuthor(first = "Drazzle", last = "Bay")
public class PhoneNumber extends UniqueEntity
{
	private static final long serialVersionUID = -8654327023234129639L;

	public static final String FOREIGN_KEY_NAME = "phone_number";

	public static enum Category
	{
		HOME, CELL, WORK, FAX, OTHER;

		public static final String FOREIGN_KEY_NAME = "phone_number_category";
	}

	@Enumerated(EnumType.STRING)
	protected Category category;

	@Column(name = "country_code")
	protected int countryCode;

	@Column(name = "area_code")
	protected int areaCode;

	@Column(name = "first_three")
	protected int firstThree;

	@Column(name = "last_four")
	protected int lastFour;

	protected int extension;

	@ManyToMany(mappedBy = "phoneNumberLookup")
	protected Set<Person> owners;

	protected PhoneNumber()
	{
		this(null, -1, -1, -1, -1, -1);
	}

	public PhoneNumber(Category category, int areaCode, int firstThree, int lastFour)
	{
		this(category, 1, areaCode, firstThree, lastFour, -1);
	}

	public PhoneNumber(Category category, int countryCode, int areaCode, int firstThree, int lastFour)
	{
		this(category, countryCode, areaCode, firstThree, lastFour, -1);
	}

	public PhoneNumber(Category category, int countryCode, int areaCode, int firstThree, int lastFour, int extension)
	{
		this.category = category;
		this.countryCode = countryCode;
		this.areaCode = areaCode;
		this.firstThree = firstThree;
		this.lastFour = lastFour;
		this.extension = extension;

		owners = new HashSet<Person>();
	}

	public Category getCategory(){ return category; }
	public int getCountryCode(){ return countryCode; }
	public int getAreaCode(){ return areaCode; }
	public int getFirstThree(){ return firstThree; }
	public int getLastFour(){ return lastFour; }
	public int getExtension(){ return extension; }

	public Set<Person> getOwners(){ return owners; }
	public void addOwner(Person owner){ owners.add(owner); }
	public void removeOwner(Person owner){ owners.remove(owner); }

	public String toString()
	{
		return "("+areaCode+") "+firstThree+"-"+lastFour;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;

		result = prime * result + countryCode;
		result = prime * result + areaCode;
		result = prime * result + firstThree;
		result = prime * result + lastFour;
		result = prime * result + extension;

		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if(obj == this)
			return true;

		if(!(obj instanceof PhoneNumber))
			return false;

		PhoneNumber other = (PhoneNumber)obj;
		return
			countryCode == other.countryCode &&
			areaCode == other.areaCode &&
			firstThree == other.firstThree &&
			lastFour == other.lastFour &&
			extension == other.extension;
	}

	
}
