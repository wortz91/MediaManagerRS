package org.nick.application;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.nick.entities.Genre;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MediaManagerRS");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		Genre gen = new Genre();
		
		//NickTest is the value that is given by the user/website/whatever else
		gen.setGenreDescription("NickTest " + new Date());
		
		tx.begin();
		em.persist(gen);
		tx.commit();
		
		Query query = em.createNamedQuery("Genre.findAll");
		
		List<Genre> list = query.getResultList();
		
		for(Genre genre : list) {
			System.out.println(genre.getGenreDescription());
		}
		
		em.close();
		emf.close();
	}

}
