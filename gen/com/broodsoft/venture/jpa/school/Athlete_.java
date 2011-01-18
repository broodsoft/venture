package com.broodsoft.venture.jpa.school;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.broodsoft.venture.jpa.model.school.Athlete;
import com.broodsoft.venture.jpa.model.school.Roster;

@StaticMetamodel(Athlete.class)
public abstract class Athlete_ extends com.broodsoft.venture.jpa.Decorator_ {

	public static volatile SetAttribute<Athlete, Roster> rosters;

}

