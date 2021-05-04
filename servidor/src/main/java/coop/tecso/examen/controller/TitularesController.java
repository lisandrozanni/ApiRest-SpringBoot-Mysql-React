package coop.tecso.examen.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coop.tecso.examen.model.Titulares;
import coop.tecso.examen.service.TitularesService;


@RestController
@RequestMapping(value = "/titular")
@CrossOrigin
public class TitularesController {
	
	@Autowired
	private TitularesService titularesService;
	
	
	@PostMapping(value = "/crear-titular")
	public ResponseEntity<?> create (@RequestBody Titulares titulares) {
		return ResponseEntity.status(HttpStatus.CREATED).body(titularesService.save(titulares));
	}
	
	
	@GetMapping(value = "/buscar-titular/{id}")
	public ResponseEntity<?> read (@PathVariable(value = "id") Long userId) {
		Optional<Titulares> oUser = titularesService.findById(userId);
		
		if(!oUser.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(oUser);
	}
	
	
	@PutMapping(value = "/editar-titular/{id}")
	public ResponseEntity<?> update (@RequestBody Titulares titularesDetails, @PathVariable(value = "id") Long titularesDetailsId) {
		Optional<Titulares> titulares = titularesService.findById(titularesDetailsId);
		
		if(!titulares.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		
		titulares.get().setNombre(titularesDetails.getNombre());
		titulares.get().setApellido(titularesDetails.getApellido());
		titulares.get().setCuentaCorriente(titularesDetails.getCuentaCorriente());
		titulares.get().setRut(titularesDetails.getRut());
		titulares.get().setCaracteristica(titularesDetails.getCaracteristica());
		titulares.get().setRazon(titularesDetails.getRazon());
		titulares.get().setAnio(titularesDetails.getAnio());
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(titularesService.save(titulares.get()));
		
	}
	
	
	@DeleteMapping(value = "/eliminar-titular/{id}")
	public ResponseEntity<?> delete (@PathVariable(value = "id") Long titularesId) {
		
		if(!titularesService.findById(titularesId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		titularesService.deleteById(titularesId);
		return ResponseEntity.ok().body("Titular eliminado");
	}
	
	
	@GetMapping(value = "/todos")
	public List<Titulares> readAll () {
		
		List<Titulares> titulares = StreamSupport
				.stream(titularesService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
		return titulares;
	}

}
