package it.film.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQuery(name="trovatutti", query="SELECT f FROM Film f")
@Entity
@Table(name = "film")
public class Film implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String titolo;
	private int anno;
	private String regista;
	private String tipo;
	private String incasso;
	
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	
	@Column(name="titolo")
	public String getTitolo() {
		return titolo;
	}
	@Column(name="anno")
	public int getAnno() {
		return anno;
	}
	@Column(name="regista")
	public String getRegista() {
		return regista;
	}
	@Column(name="tipo")
	public String getTipo() {
		return tipo;
	}
	@Column(name="incasso")
	public String getIncasso() {
		return incasso;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public void setAnno(int anno) {
		this.anno = anno;
	}
	public void setRegista(String regista) {
		this.regista = regista;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public void setIncasso(String incasso) {
		this.incasso = incasso;
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", titolo=" + titolo + ", anno=" + anno + ", regista=" + regista + ", tipo=" + tipo
				+ ", incasso=" + incasso + "]";
	}
	
	

}
