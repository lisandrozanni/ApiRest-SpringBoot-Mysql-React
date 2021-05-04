package coop.tecso.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import coop.tecso.examen.model.Titulares;

@Repository
public interface TitularesRepository extends JpaRepository<Titulares, Long> {

}
