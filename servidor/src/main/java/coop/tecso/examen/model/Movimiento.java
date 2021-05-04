package coop.tecso.examen.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import coop.tecso.examen.enums.TipoMovimiento;

@Entity
@Table(name = "movimientos")
public class Movimiento extends AbstractPersistentObject{

	private static final long serialVersionUID = -3950224366411194160L;
	
	@Column(name="tipoMovimiento",  length = 10, nullable = false)
	private TipoMovimiento tipoMovimiento;
	
	@Column(name="descripcion",  length = 200, nullable = false)
	private String descripcion;
	
	@Column(name="importe",  length = 100, nullable = false) 
	private BigDecimal importe;

	
	public TipoMovimiento getTipoMovimiento() {
		return tipoMovimiento;
	}
	public void setTipoMovimiento(TipoMovimiento tipoMovimiento) {
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
	
	
}
