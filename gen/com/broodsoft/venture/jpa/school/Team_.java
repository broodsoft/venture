package com.broodsoft.venture.jpa.school;

import com.broodsoft.venture.jpa.model.school.Roster;
import com.broodsoft.venture.jpa.model.school.Team;
import com.broodsoft.venture.jpa.model.school.Roster.Type;
import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Team.class)
public abstract class Team_ extends com.broodsoft.venture.jpa.UniqueEntity_ {

	public static volatile MapAttribute<Team, Type, Roster> rosters;
	public static volatile SingularAttribute<Team, String> name;

}

