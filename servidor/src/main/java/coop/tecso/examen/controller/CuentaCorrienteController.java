package coop.tecso.examen.controller;

import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import coop.tecso.examen.dto.CuentaCorrienteDto;
import coop.tecso.examen.dto.ResponseDto;
import coop.tecso.examen.enums.EstadoResponse;
import coop.tecso.examen.enums.Moneda;
import coop.tecso.examen.model.CuentaCorriente;
import coop.tecso.examen.service.CuentaService;

@RestController
@RequestMapping("/cuenta")
@CrossOrigin
public class CuentaCorrienteController {


	@Autowired
	private CuentaService cuentaService;

	
	@PostMapping("/crear")
	public @ResponseBody ResponseDto create(@RequestBody CuentaCorrienteDto cuentaCorrienteDto)
		throws URISyntaxException {
		ResponseDto response = new ResponseDto();
		cuentaService.crearCuentaCorriente(cuentaCorrienteDto.getNumeroCuenta(),
				Moneda.getMoneda(cuentaCorrienteDto.getMoneda()), cuentaCorrienteDto.getSaldo());
		response = new ResponseDto(EstadoResponse.CREATED, "Se ah creado la cuenta con exito!");
		return response;
	}

	
	@GetMapping(value = "/visualizar")
	public @ResponseBody List<CuentaCorrienteDto> getCuentas() {
		List<CuentaCorriente> cuentasCorrientes = cuentaService.obtenerCuentasCorrientes();
		List<CuentaCorrienteDto> listResp = cuentasCorrientes.stream().map(serch -> new CuentaCorrienteDto(serch))
				.collect(Collectors.toList());
		return listResp;
	}
	
	
	@DeleteMapping(value = "/{numeroCuenta}")
	public @ResponseBody ResponseDto delete(@PathVariable Long numeroCuenta) {
		ResponseDto response = new ResponseDto();
		cuentaService.eliminarCuenta(numeroCuenta);
		response = new ResponseDto(EstadoResponse.OK, "Se ah eliminado la cuenta con exito!");
		return response;
	}
	

}
