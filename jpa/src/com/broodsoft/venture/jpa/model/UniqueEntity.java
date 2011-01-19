package com.broodsoft.venture.jpa.model;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.MappedSuperclass;

import com.broodsoft.brew.doc.CodeAuthor;

@MappedSuperclass
@CodeAuthor(first = "Drazzle", last = "Bay")
public abstract class UniqueEntity implements Serializable
{
	private static final long serialVersionUID = -826419473364119071L;

	@Id
	@GeneratedValue
	protected long id;

	protected UniqueEntity()
	{
		id = -1;
	}

	public long getId()
	{
		return id;
	}
}
