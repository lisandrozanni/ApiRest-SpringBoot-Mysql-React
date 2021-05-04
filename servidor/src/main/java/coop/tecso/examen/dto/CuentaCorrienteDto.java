package coop.tecso.examen.dto;

import static javax.persistence.TemporalType.TIMESTAMP;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import coop.tecso.examen.model.CuentaCorriente;


public class CuentaCorrienteDto implements Serializable{

	private static final long serialVersionUID = 3714376091138473277L;
	
	@Column(name="numeroCuenta",  length = 50, unique = true, nullable = false)
	private Long numeroCuenta;
	
	@Column(name="moneda",  length = 100, nullable = false)
	private String moneda;	
	
	@Column(name="saldo",  length = 100, nullable = false)
	private BigDecimal saldo;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd-MM-yyyy", timezone="America/Argentina/Buenos_Aires")
    @CreatedDate
    @Temporal(TIMESTAMP)
	private Date fechaCreacion;
	
	
	public CuentaCorrienteDto(CuentaCorriente cuenta){
		 
		this.fechaCreacion = cuenta.getFechaCreacion();
		this.numeroCuenta = cuenta.getNumeroCuenta();
		this.moneda = cuenta.getMoneda().toString();
		this.saldo = cuenta.getSaldo();
	}	
	
	
	public CuentaCorrienteDto()
	{		
	}
	
	public Long getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(Long numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public BigDecimal getSaldo() {
		return saldo;
	}
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

}
