package cat.itacademy.barcelonactiva.serrano.victor.s05.t01.n02.model.dto;

import javax.validation.constraints.NotEmpty;

import cat.itacademy.barcelonactiva.serrano.victor.s05.t01.n02.model.domain.Pais;

public class FlorEntityDto {
	private int id;
	@NotEmpty
	private String nombre;
	private Pais pais;
	private String tipoFlor;
	
	public FlorEntityDto() {
		super();
	}

	public FlorEntityDto(int id, @NotEmpty String nombre, Pais pais, String tipoFlor) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pais = pais;
		this.tipoFlor = tipoFlor;
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

	public String getTipoFlor() {
		return tipoFlor;
	}

	public void setTipoFlor(String tipoFlor) {
		this.tipoFlor = tipoFlor;
	}

	@Override
	public String toString() {
		return "FlorEntityDto [id=" + id + ", nombre=" + nombre + ", pais=" + pais + ", tipoFlor=" + tipoFlor + "]";
	}
	

}
