package coop.tecso.examen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import coop.tecso.examen.dto.MovimientoDto;
import coop.tecso.examen.dto.ResponseDto;
import coop.tecso.examen.enums.EstadoResponse;
import coop.tecso.examen.service.MovimientoService;

@RestController
@RequestMapping(value = "/movimiento")
@CrossOrigin
public class MovimientoController {
	

	@Autowired
	private MovimientoService movimientoService;
	

	@PostMapping(value = "/agregar")
	public @ResponseBody ResponseDto agregarMovimiento(@RequestBody MovimientoDto movimientoDto) {
		ResponseDto response = new ResponseDto();
		movimientoService.agregarMovimiento(movimientoDto);
		response = new ResponseDto(EstadoResponse.OK, "Movimiento agregado con exito!");
		return response;
	}

	
	@GetMapping(value = "/lista")
	public @ResponseBody List<MovimientoDto> getMovimientos() {
		List<MovimientoDto> listMov = movimientoService.movimientosOrdenados();
		return listMov;
	}

}
