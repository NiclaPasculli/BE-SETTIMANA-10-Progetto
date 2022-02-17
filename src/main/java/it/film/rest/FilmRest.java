package it.film.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


import it.film.dao.FilmDao;
import it.film.dto.FilmDto;
import it.film.entity.Film;

@RequestMapping("/film")
@RestController
@Api(value="FilmRest", tags="crea e cerca film")
public class FilmRest {
Logger log = LoggerFactory.getLogger(getClass());
	
	FilmDao filmdao;
	
	public FilmDao getFilmdao() {
		if(filmdao == null) {
			filmdao = new FilmDao();
		}
		return filmdao;
	}
	
	@GetMapping
	@ApiOperation(
			value="Mostra la lista di tutti i film presenti",
			produces="application/json",
			response = Film.class, responseContainer = "List")
	
	public ResponseEntity<List<Film>> trovaTutti(){
		try {
			return new ResponseEntity<List<Film>>(getFilmdao().trovaTutti(), HttpStatus.OK);
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<List<Film>>((List<Film>)null, HttpStatus.BAD_REQUEST);
		}
	}
	@DeleteMapping("{id}")	
	@ApiOperation(
			value="Elimina un film")
	
	public ResponseEntity<String> deleteFilm(@PathVariable int id) {
		try {
		getFilmdao().elimina(id);
		return new ResponseEntity<String>("Eliminazione avvenuta", HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>("Eliminazione NON avvenuta", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping
	@ApiOperation(
			value="Inserisci un film",
			consumes="application/json"
			
			)
	public ResponseEntity<String> inserisciFilm(@RequestBody FilmDto  fDto) {
		if(fDto.getRegista() == null || fDto.getRegista().isBlank()) {
			log.error("Aggiungi il regista");
			return new ResponseEntity<String>("Il regista DEVE essere inserito", HttpStatus.I_AM_A_TEAPOT);
		}
		Film f = new Film();
		f.setTitolo(fDto.getTitolo());
		f.setAnno(fDto.getAnno());
		f.setRegista(fDto.getRegista());
		f.setTipo(fDto.getTipo());
		
		String incassoCriptato = BCrypt.hashpw(fDto.getIncasso(), BCrypt.gensalt());
		f.setIncasso(incassoCriptato);
		
		
		
		try {
			getFilmdao().salva(f);
			return new ResponseEntity<String>("Inserimento avvenuto" + f + incassoCriptato , HttpStatus.OK);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<String>("Inserimento NON avvenuto", HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@GetMapping("/byregista")
	@ApiOperation(value="ricerca per regista",
				produces="application/json",
				response= Film.class, responseContainer = "List")                
	public ResponseEntity<List<Film>> cercaByRegista(@RequestParam String regista){
		try {
			log.info("La ricerca è stata completata, controlla il risultato");
			return new ResponseEntity<List<Film>>((List<Film>) getFilmdao().trovaRegista(regista), HttpStatus.OK);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<List<Film>>((List<Film>)null, HttpStatus.METHOD_NOT_ALLOWED);
		}
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value="Aggiorna film del DB",
				  consumes="application/json"
	)
	
	public ResponseEntity<String> aggiornaFilm(@RequestBody FilmDto fDto, @PathVariable int id){
		Film f = new Film();
		f.setTitolo(fDto.getTitolo());
		f.setAnno(fDto.getAnno());
		f.setRegista(fDto.getRegista());
		f.setTipo(fDto.getTipo());
		String incassoCriptato = BCrypt.hashpw(fDto.getIncasso(), BCrypt.gensalt());
		f.setIncasso(incassoCriptato);
		f.setId(id);
		try {
			getFilmdao().aggiorna(f);
			log.info("Hai aggiornato la persona!");
			return new ResponseEntity<String>("Aggiornamento avvenuto" , HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>("Aggiornamento NON avvenuto", HttpStatus.METHOD_FAILURE);
		}
	}
	

}
