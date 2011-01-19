package com.broodsoft.venture.jpa.model.school;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import com.broodsoft.brew.doc.CodeAuthor;
import com.broodsoft.venture.jpa.model.Decorator;

@Entity
@CodeAuthor(first = "Drazzle", last = "Bay")
public class Athlete extends Decorator<Student>
{
	private static final long serialVersionUID = -5851582488994134655L;

	public static final String FOREIGN_KEY_COLUMN_NAME = "athlete";

	@ManyToMany(mappedBy = "athletes")
	protected Set<Roster> rosters;

	public Athlete()
	{
		this(null);
	}

	public Athlete(Student student)
	{
		super(student);

		rosters = new HashSet<Roster>();
	}

	public Set<Roster> getRosters()
	{
		return rosters;
	}

	public void addRoster(Roster roster)
	{
		rosters.add(roster);
	}
}
