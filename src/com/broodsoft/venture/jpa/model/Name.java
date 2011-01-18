package com.broodsoft.venture.jpa.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.broodsoft.brew.doc.CodeAuthor;

@Embeddable
@CodeAuthor(first = "Drazzle", last = "Bay")
public class Name
{
	@Column(name="first")
	protected String firstName;

	@Column(name="last")
	protected String lastName;

	@Column(name="middle")
	protected String middleName;

	protected Name()
	{
		this(null, null, null);
	}

	public Name(String firstName, String lastName)
	{
		this(firstName, "", lastName);
	}

	public Name(String firstName, String middleName, String lastName)
	{
		setFirstName(firstName);
		setMiddleName(middleName);
		setLastName(lastName);
	}

	public String getFirstName(){ return firstName; }
	public void setFirstName(String firstName){ this.firstName = firstName; }

	public String getLastName(){ return lastName; }
	public void setLastName(String lastName){ this.lastName = lastName; }

	public String getMiddleName(){ return middleName; }
	public void setMiddleName(String middleName){ this.middleName = middleName; }

	@Override
	public String toString()
	{
		return firstName+" "+(middleName == null || middleName.length() == 0 ? "" : middleName+" ")+lastName;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;

		result = prime * result + ((firstName == null)  ? 0 : firstName.hashCode());
		result = prime * result + ((middleName == null) ? 0 : middleName.hashCode());
		result = prime * result	+ ((lastName == null)   ? 0 : lastName.hashCode());

		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if(obj == this)
			return true;

		if(!(obj instanceof Name))
			return false;

		Name other = (Name)obj;
		return
			firstName.equals(other.firstName) &&
			middleName.equals(other.middleName) &&
			lastName.equals(other.lastName);
	}
}
