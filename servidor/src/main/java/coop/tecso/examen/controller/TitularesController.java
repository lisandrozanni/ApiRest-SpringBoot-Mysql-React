package coop.tecso.examen.controller;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import coop.tecso.examen.dto.ResponseDto;
import coop.tecso.examen.enums.EstadoResponse;
import coop.tecso.examen.exception.ErroresFuncionales;
import coop.tecso.examen.model.Titulares;
import coop.tecso.examen.service.TitularesService;


@RestController
@RequestMapping(value = "/titular")
@CrossOrigin
public class TitularesController {
	
	@Autowired
	private TitularesService titularesService;
	
	
	@PostMapping(value = "/crear-titular")
	public @ResponseBody ResponseDto create (@RequestBody Titulares titulares) throws URISyntaxException {
		ResponseDto response = new ResponseDto();
		titularesService.save(titulares);
		response = new ResponseDto(EstadoResponse.CREATED, "El titular se creo con exito!");
		return response;
	}
	
	
	@GetMapping(value = "/buscar-titular/{id}")
	public ResponseEntity<?> read (@PathVariable(value = "id") Long userId) {
		Optional<Titulares> oUser = titularesService.findById(userId);
		
		if(!oUser.isPresent()) {
			throw new ErroresFuncionales("El titular que desea buscar no existe");
		}
		
		return ResponseEntity.ok(oUser);
	}
	
	
	@PutMapping(value = "/editar-titular/{id}")
	public @ResponseBody ResponseDto update (@RequestBody Titulares titularesDetails, @PathVariable(value = "id") Long titularesDetailsId) {
		Optional<Titulares> titulares = titularesService.findById(titularesDetailsId);
		
		if(!titulares.isPresent()) {
			throw new ErroresFuncionales("El titular que desea editar no existe");
		}
		
		
		titulares.get().setNombre(titularesDetails.getNombre());
		titulares.get().setApellido(titularesDetails.getApellido());
		titulares.get().setCuentaCorriente(titularesDetails.getCuentaCorriente());
		titulares.get().setRut(titularesDetails.getRut());
		titulares.get().setCaracteristica(titularesDetails.getCaracteristica());
		titulares.get().setRazon(titularesDetails.getRazon());
		titulares.get().setAnio(titularesDetails.getAnio());
		
		
		ResponseDto response = new ResponseDto();
		titularesService.save(titulares.get());
		response = new ResponseDto(EstadoResponse.OK, "El titular modificado con exito!");
		return response;
		
	}
	
	
	@DeleteMapping(value = "/eliminar-titular/{id}")
	public @ResponseBody ResponseDto delete (@PathVariable(value = "id") Long titularesId) {
		
		if(!titularesService.findById(titularesId).isPresent()) {
			throw new ErroresFuncionales("No se encontro el titular que desea eliminar");
		}
		ResponseDto response = new ResponseDto();
		titularesService.deleteById(titularesId);
		response = new ResponseDto(EstadoResponse.OK, "Titular eliminado con exito!");
		return response;
	}
	
	
	@GetMapping(value = "/todos")
	public List<Titulares> readAll () {
		
		List<Titulares> titulares = StreamSupport
				.stream(titularesService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
		return titulares;
	}

}
