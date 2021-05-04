package coop.tecso.examen.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import coop.tecso.examen.model.Titulares;


public interface TitularesService {

	public Iterable<Titulares> findAll();
	
	public Page<Titulares> findAll(Pageable pageable);
	
	public Optional<Titulares> findById(Long id);
	
	public Titulares save(Titulares titulares);
	
	public void deleteById(Long id);
	
}
