package coop.tecso.examen.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "titulares")
public class Titulares extends AbstractPersistentObject implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nombre", length = 80)
	private String nombre;
	
	@Column(name="apellido",length = 250)
	private String apellido;
	
	@Column(name="cuentaCorriente", unique = true)
	private String cuentaCorriente;

	@Column(name="rut", unique = true)
	private String rut;
	
	@Column(name="caracteristica")
	private String caracteristica;

	@Column(name="razon")
	private String razon;
	
	@Column(name="anio")
	private String anio;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCuentaCorriente() {
		return cuentaCorriente;
	}

	public void setCuentaCorriente(String cuentaCorriente) {
		this.cuentaCorriente = cuentaCorriente;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
	}

	public String getRazon() {
		return razon;
	}

	public void setRazon(String razon) {
		this.razon = razon;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	
}
