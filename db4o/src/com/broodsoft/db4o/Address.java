package com.broodsoft.db4o;

public class Address
{
	private String number;
	private String street;
	private String city;
	private String state;
	private int zip;

	public Address(String number, String street, String city, String state, int zip)
	{
		this.number = number;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	public String getNumber()
	{
		return number;
	}
	public String getStreet()
	{
		return street;
	}
	public String getCity()
	{
		return city;
	}
	public String getState()
	{
		return state;
	}
	public int getZip()
	{
		return zip;
	}
	public void setNumber(String number)
	{
		this.number = number;
	}
	public void setStreet(String street)
	{
		this.street = street;
	}
	public void setCity(String city)
	{
		this.city = city;
	}
	public void setState(String state)
	{
		this.state = state;
	}
	public void setZip(int zip)
	{
		this.zip = zip;
	}

	
}
