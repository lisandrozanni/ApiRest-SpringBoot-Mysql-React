package coop.tecso.examen.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import coop.tecso.examen.model.CuentaCorriente;

public interface CuentaCorrienteRepository extends JpaRepository<CuentaCorriente, Long>{

	Optional<CuentaCorriente> findByNumeroCuenta(Long numeroCuenta);
	
	Optional<CuentaCorriente> findByNumeroCuentaAndMovimientosIsNull(Long numeroCuenta);

}
