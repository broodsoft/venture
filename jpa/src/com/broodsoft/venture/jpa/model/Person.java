package com.broodsoft.venture.jpa.model;

import java.util.Date;
import java.util.EnumMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.broodsoft.brew.doc.CodeAuthor;

@Entity
@CodeAuthor(first = "Drazzle", last = "Bay")
public class Person extends UniqueEntity
{
	private static final long serialVersionUID = -2819406760540606283L;

	public static final String FOREIGN_KEY_NAME = "person";

	@Embedded
	protected Name name;

	@Column(name="dob")
	@Temporal(TemporalType.DATE)
	protected Date dateOfBirth;

	@Enumerated(EnumType.STRING)
	protected Gender gender;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable
	(
		name = "phone_book",
		joinColumns = @JoinColumn(name = FOREIGN_KEY_NAME),
		inverseJoinColumns = @JoinColumn(name = PhoneNumber.FOREIGN_KEY_NAME)
	)
	@MapKeyEnumerated(EnumType.STRING)
	@MapKeyColumn(name = PhoneNumber.Category.FOREIGN_KEY_NAME)
	protected Map<PhoneNumber.Category, PhoneNumber> phoneNumberLookup;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = Address.FOREIGN_KEY_NAME)
	protected Address address;

	protected Person()
	{
		this(null, null, null);
	}

	public Person(Gender gender, Date dateOfBirth)
	{
		this(gender, dateOfBirth, new Name());
	}

	public Person(Gender gender, Date dateOfBirth, Name name)
	{
		this.gender = gender;
		this.dateOfBirth = ((dateOfBirth == null) ? null : (Date)dateOfBirth.clone());
		this.name = name;

		phoneNumberLookup = new EnumMap<PhoneNumber.Category, PhoneNumber>(PhoneNumber.Category.class);
	}

	public Name getName(){ return name; }

	public Gender getGender(){ return gender; }
	public Date getDateOfBirth(){ return dateOfBirth; }

	public Address getAddress(){ return address; }
	public void setAddress(Address address)
	{
		if(this.address != null)
			this.address.removeResident(this);

		this.address = address;
		address.addResident(this);
	}

	public PhoneNumber getPhoneNumber(PhoneNumber.Category category){ return phoneNumberLookup.get(category); }
	public void addPhoneNumber(PhoneNumber phoneNumber)
	{
		PhoneNumber oldPhoneNumber = phoneNumberLookup.put(phoneNumber.getCategory(), phoneNumber);
		if(oldPhoneNumber != null)
			oldPhoneNumber.removeOwner(this);
		phoneNumber.addOwner(this);
	}

	@Override
	public String toString()
	{
		return name.toString();
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;

		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((gender == null)      ? 0 : gender.hashCode());
		result = prime * result	+ ((name == null)        ? 0 : name.hashCode());

		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if(obj == this)
			return true;

		if(!(obj instanceof Person))
			return false;

		Person other = (Person)obj;
		return
			gender.equals(other.gender) &&
			dateOfBirth.equals(other.dateOfBirth) &&
			name.equals(other.name);
	}
}
