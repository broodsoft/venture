package com.broodsoft.venture.jpa.school;

import com.broodsoft.venture.jpa.model.school.Athlete;
import com.broodsoft.venture.jpa.model.school.Roster;
import com.broodsoft.venture.jpa.model.school.Team;
import com.broodsoft.venture.jpa.model.school.Roster.Type;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Roster.class)
public abstract class Roster_ extends com.broodsoft.venture.jpa.UniqueEntity_ {

	public static volatile SetAttribute<Roster, Athlete> athletes;
	public static volatile SingularAttribute<Roster, Team> team;
	public static volatile SingularAttribute<Roster, Type> type;

}

