package coop.tecso.examen.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coop.tecso.examen.dto.MovimientoDto;
import coop.tecso.examen.enums.Moneda;
import coop.tecso.examen.enums.TipoMovimiento;
import coop.tecso.examen.exception.ErroresFuncionales;
import coop.tecso.examen.model.CuentaCorriente;
import coop.tecso.examen.model.Movimiento;
import coop.tecso.examen.repository.CuentaCorrienteRepository;
import coop.tecso.examen.repository.MovimientoRepository;
import coop.tecso.examen.service.MovimientoService;

@Service
public class MovimientoServiceImpl implements MovimientoService {

	@Autowired
	private MovimientoRepository movimientoRepository;

	@Autowired
	private CuentaCorrienteRepository cuentaCorrienteRepository;

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public Movimiento agregarMovimiento(MovimientoDto movimientoDto) {


		Optional<CuentaCorriente> cc = cuentaCorrienteRepository.findByNumeroCuenta(movimientoDto.getNumeroCuenta());
		if (!cc.isPresent()) {
			throw new ErroresFuncionales(
					"El numero de cuenta corriente " + movimientoDto.getNumeroCuenta() + " es inexistente"); 
		}

		CuentaCorriente ccVerificar = cc.get();
		if (movimientoDto.getTipoMovimiento().equals(TipoMovimiento.CREDITO)) {
			ccVerificar.setSaldo(ccVerificar.getSaldo().add(movimientoDto.getImporte()));
		} else {
			ccVerificar.setSaldo(ccVerificar.getSaldo().subtract(movimientoDto.getImporte()));
		}

		if ((ccVerificar.getMoneda().equals(Moneda.PESO))
				&& (ccVerificar.getSaldo().compareTo(new BigDecimal("-1000")) == -1)) {
			throw new ErroresFuncionales(
					"El movimiento para la cuenta : " + movimientoDto.getNumeroCuenta() + " genero un descubierto mayor a $1000! ");
		}

		if ((ccVerificar.getMoneda().equals(Moneda.DOLAR))
				&& (ccVerificar.getSaldo().compareTo(new BigDecimal("-300")) == -1)) {
			throw new ErroresFuncionales(
					"El movimiento para la cuenta : " + movimientoDto.getNumeroCuenta() + " genero un descubierto mayor a $300! ");
		}

		if ((ccVerificar.getMoneda().equals(Moneda.EURO))
				&& (ccVerificar.getSaldo().compareTo(new BigDecimal("-150")) == -1)) {
			throw new ErroresFuncionales(
					"El movimiento para la cuenta : " + movimientoDto.getNumeroCuenta() + " genero un descubierto mayor a $150! ");
		}
		
		if ((ccVerificar.getMovimientos().size() == 10 )) {
			throw new ErroresFuncionales(
					"Exedio el numero de movimientos");
		}

		Movimiento mov = new Movimiento();

		mov.setFechaCreacion(mov.getFechaCreacion());
		mov.setDescripcion(movimientoDto.getDescripcion());
		mov.setImporte(movimientoDto.getImporte());
		mov.setTipoMovimiento(TipoMovimiento.CREDITO.equals(movimientoDto.getTipoMovimiento()) ? TipoMovimiento.CREDITO
				: TipoMovimiento.DEBITO);
		movimientoRepository.save(mov);

		ccVerificar.getMovimientos().add(mov);
		cuentaCorrienteRepository.save(ccVerificar);

		return mov;
	}


	@Override
	public List<MovimientoDto> movimientosOrdenados() {
		List<MovimientoDto> listaMovimientoResult = new ArrayList<>();
		List<CuentaCorriente> listOrdenada = cuentaCorrienteRepository.findAll();
		for (CuentaCorriente cc : listOrdenada) {
			listaMovimientoResult.addAll(cc.getMovimientos().stream()
					.map(mov -> new MovimientoDto(mov, cc.getNumeroCuenta()))
					.collect(Collectors.toList()));
		}
		return listaMovimientoResult;
	}

}
