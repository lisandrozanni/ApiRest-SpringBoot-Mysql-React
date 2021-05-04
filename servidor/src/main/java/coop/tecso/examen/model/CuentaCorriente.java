package coop.tecso.examen.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import coop.tecso.examen.enums.Moneda;

@Entity
@Table(name = "cuenta_corriente")
public class CuentaCorriente extends AbstractPersistentObject {

	private static final long serialVersionUID = 2581370374121616244L;

	
	@Column(name="numeroCuenta",  length = 50, unique = true, nullable = false) 
	private Long numeroCuenta;
	
	@Column(name="moneda",  length = 10, nullable = false) 
	private Moneda moneda;
	
	@Column(name="saldo",  length = 100, nullable = false) 
	private BigDecimal saldo;
		
    @OneToMany(targetEntity=Movimiento.class)
	private Set<Movimiento> movimientos;
    
	
	public Long getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(Long numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public Moneda getMoneda() {
		return moneda;
	}

	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public Set<Movimiento> getMovimientos() {
		if (this.movimientos == null){
			this.movimientos = new HashSet<Movimiento>();
		}
		return movimientos;
	}

	public void setMovimientos(Set<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}    

 
}
