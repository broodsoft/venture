package com.broodsoft.brew.db.db4o;

import static java.lang.annotation.ElementType.FIELD;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.broodsoft.brew.doc.CodeAuthor;

@Target({FIELD})
@Retention(RetentionPolicy.RUNTIME)
@CodeAuthor(first = "Drazzle", last = "Bay")
public @interface Db4oId
{
	
}
