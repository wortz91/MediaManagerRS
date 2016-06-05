package org.nick.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.nick.entities.MediaItem;

public class MediaItemDAO {

	public List<MediaItem> getAllMediaItems() {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MediaManagerRS");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		
//		MediaItem gen = new MediaItem();
//		
//		//NickTest is the value that is given by the user/website/whatever else
//		gen.setMediaItemDescription("NickTest " + new Date());
//		
//		tx.begin();
//		em.persist(gen);
//		tx.commit();
//		
		Query query = em.createNamedQuery("MediaItem.findAll");
		
		List<MediaItem> list = query.getResultList();
		
		em.close();
		emf.close();
		
		return list;
	}

}
