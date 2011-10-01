package com.broodsoft.venture.hsqldb.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.broodsoft.brew.doc.CodeAuthor;

@CodeAuthor(first = "Drazzle", last = "Bay")
public class Launcher
{
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private static EntityTransaction tx;

	public static void main(String... args)
	{
		emf = Persistence.createEntityManagerFactory("FileDB_PU");
//		emf = Persistence.createEntityManagerFactory("InMemoryDB_PU");
		em = emf.createEntityManager();
		tx = em.getTransaction();
		tx.begin();

		em.persist(new Credentials("gmail.com"));
		em.persist(new Credentials("yahoo.com"));

		tx.commit();
		em.close();
		emf.close();
	}
}
