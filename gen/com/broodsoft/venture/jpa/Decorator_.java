package com.broodsoft.venture.jpa;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.broodsoft.venture.jpa.model.Decorator;

@StaticMetamodel(Decorator.class)
public abstract class Decorator_ extends com.broodsoft.venture.jpa.UniqueEntity_ {

	public static volatile SingularAttribute<Decorator, Object> base;

}

