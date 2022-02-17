package it.film.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


import it.film.entity.Film;

public class FilmDao implements IFilmDao {
	
	private EntityManager em = EntityManagerHelper.getEntityManager();

	@Override
	public void salva(Film f) {
		em.getTransaction().begin();
		em.persist(f);
		em.getTransaction().commit();
		
	}

	@Override
	public void aggiorna(Film f) {
		em.getTransaction().begin();
		em.merge(f);
		em.getTransaction().commit();
		
	}

	@Override
	public Film trova(int id) {
		Film film = em.find(Film.class,id);
		return film;
	}

	/** il metodo cerca i film del regista indicato
	 * 
	 * @author Nicla Pasculli
	 *@param regista : il nome del regista(attributo dell'entity film)
	 * @return listaFilmRegista lista di tutti i film di quel regista
	 * 
	 */
	@Override
	public List<Film> trovaRegista(String regista) {
		Query q = em.createQuery("SELECT f FROM Film f WHERE f.regista='" +regista+"'" );
		List<Film> listaFilmRegista = q.getResultList();
		return listaFilmRegista;
	}

	@Override
	public void elimina(int id) {
		em.getTransaction().begin();
		em.remove(em.find(Film.class, id));
		em.getTransaction().commit();
		
	}

	@Override
	public List<Film> trovaTutti() {
		Query q = em.createNamedQuery("trovatutti");
		List<Film> listaFilm = q.getResultList();
		
		return listaFilm;
	}
	

}
