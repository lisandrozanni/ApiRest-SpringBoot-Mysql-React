package coop.tecso.examen.service;

import java.math.BigDecimal;
import java.util.List;


import coop.tecso.examen.enums.Moneda;
import coop.tecso.examen.model.CuentaCorriente;

public interface CuentaService {

	public CuentaCorriente crearCuentaCorriente(Long numeroCuenta, Moneda moneda, BigDecimal saldo);

	public void eliminarCuenta(Long numeroCuenta);
	
	public List<CuentaCorriente> obtenerCuentasCorrientes();
	

}

