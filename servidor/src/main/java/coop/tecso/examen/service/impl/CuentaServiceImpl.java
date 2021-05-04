package coop.tecso.examen.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import coop.tecso.examen.enums.Moneda;
import coop.tecso.examen.exception.ErroresFuncionales;
import coop.tecso.examen.model.CuentaCorriente;
import coop.tecso.examen.repository.CuentaCorrienteRepository;
import coop.tecso.examen.service.CuentaService;

@Service
public class CuentaServiceImpl implements CuentaService {

	@Autowired
	private CuentaCorrienteRepository cuentaCorrienteRepository;

	@Override
	public CuentaCorriente crearCuentaCorriente(Long numeroCuenta, Moneda moneda, BigDecimal saldo) {

		CuentaCorriente cuenta = new CuentaCorriente();
		cuenta.setNumeroCuenta(numeroCuenta);
		cuenta.setSaldo(saldo);
		cuenta.setMoneda(moneda);

		Optional<CuentaCorriente> dupl = cuentaCorrienteRepository.findByNumeroCuenta(numeroCuenta);
		if (dupl.isPresent()) {
			throw new ErroresFuncionales("Numero de cuenta corriente ya existe : " + numeroCuenta);
		}

		return cuentaCorrienteRepository.save(cuenta);
	}


	@Override
	public void eliminarCuenta(Long numeroCuenta) {
		try{
			Optional<CuentaCorriente> cc = cuentaCorrienteRepository.findByNumeroCuentaAndMovimientosIsNull(numeroCuenta);
			if (cc.isPresent()) {
				throw new ErroresFuncionales("La cuenta tiene movimientos asociados");
			} else {
				cuentaCorrienteRepository.deleteById(numeroCuenta);
			}
		}catch(Exception e){
			throw new ErroresFuncionales("Error general: " + e.getMessage());
		}
	}


	@Override
	public List<CuentaCorriente> obtenerCuentasCorrientes() {
		return cuentaCorrienteRepository.findAll();
	}

	
	@Override
	@Transactional(readOnly = true)
	public Optional<CuentaCorriente> findById(Long numeroCuenta) {
		return cuentaCorrienteRepository.findById(numeroCuenta);
	}


	@Override
	@Transactional
	public void deleteById(Long numeroCuenta) {
		cuentaCorrienteRepository.deleteById(numeroCuenta);
	}
}
