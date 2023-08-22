package cat.itacademy.barcelonactiva.serrano.victor.s05.t01.n02.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "tbl_pais")
public class Pais implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pais", columnDefinition = "INT")
	private int id;
	
	@NotEmpty
	@Column(name = "nom_pais", columnDefinition = "VARCHAR(80)")
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name = "id_continente")
	private Continente continente;
	
	public Pais() {}

	public Pais(int id, @NotEmpty String nombre, Continente continente) {
		this.id = id;
		this.nombre = nombre;
		this.continente = continente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Continente getContinente() {
		return continente;
	}

	public void setContinente(Continente continente) {
		this.continente = continente;
	}

	@Override
	public String toString() {
		return "Pais [id=" + id + ", nombre=" + nombre + ", continente=" + continente + "]";
	}
}

