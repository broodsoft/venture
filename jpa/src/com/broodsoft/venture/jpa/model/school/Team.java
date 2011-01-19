package com.broodsoft.venture.jpa.model.school;

import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.MapKey;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.OneToMany;

import com.broodsoft.brew.doc.CodeAuthor;
import com.broodsoft.venture.jpa.model.UniqueEntity;

@Entity
@CodeAuthor(first = "Drazzle", last = "Bay")
public class Team extends UniqueEntity
{
	private static final long serialVersionUID = -1282903021507422390L;

	public static final String FOREIGN_KEY_COLUMN_NAME = "team";

	protected String name;

	@OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
	@MapKeyEnumerated(EnumType.STRING)
	@MapKey(name = "type")
	protected Map<Roster.Type, Roster> rosters;

	public Team()
	{
		this("");
	}

	public Team(String name, Roster... rosters)
	{
		this.rosters = new EnumMap<Roster.Type, Roster>(Roster.Type.class);

		setName(name);
		if(rosters != null)
			for(Roster roster : rosters)
				addRoster(roster);
	}

	public String getName()
	{
		return name;
	}

	public Collection<Roster> getRosters()
	{
		return rosters.values();
	}

	public Roster getRoster(Roster.Type type)
	{
		return rosters.get(type);
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void addRoster(Roster roster)
	{
		roster.setTeam(this);
		rosters.put(roster.getType(), roster);
	}

	@Override
	public String toString()
	{
		return getName();
	}
}
