package com.broodsoft.venture.jpa.model;

import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import com.broodsoft.brew.doc.CodeAuthor;

@MappedSuperclass
@CodeAuthor(first = "Drazzle", last = "Bay")
public abstract class Decorator<T> extends UniqueEntity
{
	private static final long serialVersionUID = 8961899486231852745L;

	@OneToOne
	@JoinColumn(name="base")
	protected T base;

	public Decorator()
	{
		this(null);
	}

	public Decorator(T base)
	{
		setBase(base);
	}

	public T getBase()
	{
		return base;
	}

	protected void setBase(T base)
	{
		this.base = base;
	}
}
