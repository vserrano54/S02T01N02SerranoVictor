package cat.itacademy.barcelonactiva.serrano.victor.s05.t01.n02.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "tbl_continente")
public class Continente implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_continente", columnDefinition = "INT")
	private int id;
	
	@NotEmpty
	@Column(name = "nom_continente", columnDefinition = "VARCHAR(100)")
	private String nombre;

	public Continente() {}
	
	public Continente(int id, @NotEmpty String nombre) {
		this.id = id;
		this.nombre = nombre;
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

	@Override
	public String toString() {
		return "Continente [id=" + id + ", nombre=" + nombre + "]";
	}
	

}
