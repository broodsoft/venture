package com.broodsoft.venture.jpa.school;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.broodsoft.venture.jpa.model.school.Student;

@StaticMetamodel(Student.class)
public abstract class Student_ extends com.broodsoft.venture.jpa.Decorator_ {

	public static volatile SingularAttribute<Student, Long> studentId;

}

