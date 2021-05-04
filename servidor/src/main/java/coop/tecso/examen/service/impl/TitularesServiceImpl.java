package coop.tecso.examen.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import coop.tecso.examen.model.Titulares;
import coop.tecso.examen.repository.TitularesRepository;
import coop.tecso.examen.service.TitularesService;


@Service
public class TitularesServiceImpl implements TitularesService {

	@Autowired
	private TitularesRepository titularesRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Titulares> findAll() {
		return titularesRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Titulares> findAll(Pageable pageable) {
		return titularesRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Titulares> findById(Long id) {
		return titularesRepository.findById(id);
	}

	@Override
	@Transactional
	public Titulares save(Titulares titulares) {
		return titularesRepository.save(titulares);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		titularesRepository.deleteById(id);
	}

}