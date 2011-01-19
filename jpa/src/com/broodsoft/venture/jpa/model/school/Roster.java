package com.broodsoft.venture.jpa.model.school;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.broodsoft.brew.doc.CodeAuthor;
import com.broodsoft.venture.jpa.model.UniqueEntity;

@Entity
@CodeAuthor(first = "Drazzle", last = "Bay")
public class Roster extends UniqueEntity
{
	public enum Type{ MALE_VARSITY, MALE_JUNIOR_VARSITY, FEMALE_VARSITY, FEMALE_JUNIOR_VARSITY, MIXED_VARSITY, MIXED_JUNIOR_VARSITY; }

	private static final long serialVersionUID = -6321979818939843538L;

	public static final String FOREIGN_KEY_COLUMN_NAME = "roster";

	@Enumerated(EnumType.STRING)
	protected Roster.Type type;

	@ManyToOne
	@JoinColumn(name = Team.FOREIGN_KEY_COLUMN_NAME)
	protected Team team;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable
	(
		name = FOREIGN_KEY_COLUMN_NAME+"_"+Athlete.FOREIGN_KEY_COLUMN_NAME,
		joinColumns = @JoinColumn(name = FOREIGN_KEY_COLUMN_NAME),
		inverseJoinColumns = @JoinColumn(name = Athlete.FOREIGN_KEY_COLUMN_NAME)
	)
	protected Set<Athlete> athletes;

	public Roster()
	{
		this(null);
	}

	public Roster(Roster.Type type, Athlete... athletes)
	{
		this.athletes = new HashSet<Athlete>();

		setType(type);
		if(athletes != null)
			for(Athlete athlete : athletes)
				addAthlete(athlete);
	}

	protected Roster.Type getType()
	{
		return type;
	}

	public Team getTeam()
	{
		return team;
	}

	public Set<Athlete> getAthletes()
	{
		return athletes;
	}

	protected void setType(Roster.Type type)
	{
		this.type = type;
	}

	public void setTeam(Team team)
	{
		this.team = team;
	}

	public void addAthlete(Athlete athlete)
	{
		athlete.addRoster(this);
		athletes.add(athlete);
	}
}
