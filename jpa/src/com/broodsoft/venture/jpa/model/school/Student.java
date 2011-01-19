package com.broodsoft.venture.jpa.model.school;

import javax.persistence.Entity;

import com.broodsoft.brew.doc.CodeAuthor;
import com.broodsoft.venture.jpa.model.Decorator;
import com.broodsoft.venture.jpa.model.Person;

@Entity
@CodeAuthor(first = "Drazzle", last = "Bay")
public class Student extends Decorator<Person>
{
	private static final long serialVersionUID = -2918966592336559185L;

	protected long studentId;

	public Student()
	{
		this(-1, null);
	}

	public Student(long studentId, Person base)
	{
		super(base);

		this.studentId = studentId;
	}

	public long getStudentId(){ return studentId; }
}
