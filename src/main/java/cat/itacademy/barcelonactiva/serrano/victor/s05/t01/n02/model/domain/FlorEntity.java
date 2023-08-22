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
@Table(name = "tbl_FlorEntity")
public class FlorEntity implements Serializable  {
	

private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "pk_FlorID", columnDefinition = "INT")
private int id;

@NotEmpty
@Column(name = "nom_Flor", columnDefinition = "VARCHAR(80)")
private String nombre;

@ManyToOne
@JoinColumn(name = "id_pais")
private Pais pais;

public FlorEntity() {
	
}

public FlorEntity(int id, @NotEmpty String nombre, Pais pais) {
	super();
	this.id = id;
	this.nombre = nombre;
	this.pais = pais;
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

public Pais getPais() {
	return pais;
}

public void setPais(Pais pais) {
	this.pais = pais;
}

@Override
public String toString() {
	return "FlorEntity [id=" + id + ", nombre=" + nombre + ", pais=" + pais + "]";
}



}
