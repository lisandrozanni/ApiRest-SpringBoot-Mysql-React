package coop.tecso.examen.dto;

import static javax.persistence.TemporalType.TIMESTAMP;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonFormat;


import coop.tecso.examen.model.Movimiento;


public class MovimientoDto {
	
	@Column(name="tipoMovimiento", length = 50, nullable = false)
	private String tipoMovimiento;	
	
	@Column(name="descripcion", length = 200, nullable = false)
	private String descripcion;
	
	@Column(name="importe", nullable = false)
	private BigDecimal importe;
	
	@Column(name="numeroCuenta", unique = true, nullable = false)
	private Long numeroCuenta;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd-MM-yyyy HH:mm", timezone="America/Argentina/Buenos_Aires")
    @CreatedDate
    @Temporal(TIMESTAMP)
	private Date fechaCreacion;
	
	
	
	public MovimientoDto(Movimiento mov, Long numerocuenta){

		this.tipoMovimiento = mov.getTipoMovimiento().toString();
		this.fechaCreacion = mov.getFechaCreacion();
		this.descripcion = mov.getDescripcion();
		this.importe = mov.getImporte();
		this.numeroCuenta = numerocuenta;
	}
	
	public MovimientoDto(Movimiento mov){

		this.tipoMovimiento = mov.getTipoMovimiento().toString();
		this.fechaCreacion = mov.getFechaCreacion();
		this.descripcion = mov.getDescripcion();
		this.importe = mov.getImporte();
	}
	
	public MovimientoDto()
	{		
	}
	

	public String getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getImporte() {
		return importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

	public Long getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(Long numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}	

}
