package com.broodsoft.venture.jpa;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.broodsoft.venture.jpa.model.UniqueEntity;

@StaticMetamodel(UniqueEntity.class)
public abstract class UniqueEntity_ {

	public static volatile SingularAttribute<UniqueEntity, Long> id;

}

