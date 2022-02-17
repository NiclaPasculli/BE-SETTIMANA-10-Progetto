package it.film.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerHelper {
	
private static EntityManagerFactory emfactory;
	
	
	public static EntityManager getEntityManager() {
		
		return getEmfactory().createEntityManager();
	}

	
	public static EntityManagerFactory getEmfactory() {
		if(emfactory == null) {
			emfactory = Persistence.createEntityManagerFactory("filmPS");
		}
		return emfactory;
	}
	

}
