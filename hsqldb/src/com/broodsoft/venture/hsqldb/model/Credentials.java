package com.broodsoft.venture.hsqldb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "credentials")

@NamedQueries
({
	@NamedQuery(name = "getCredentialsCount", query = "select count(c) from Credentials c ")
})
public class Credentials
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String site;

	public Credentials(){}

	public Credentials(String site)
	{
		setSite(site);
	}

	public long getId()
	{
		return id;
	}

	public String getSite()
	{
		return site;
	}

	public void setSite(String site)
	{
		this.site = site;
	}
}
