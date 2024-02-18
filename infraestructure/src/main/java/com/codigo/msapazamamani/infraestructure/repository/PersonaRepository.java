package com.codigo.msapazamamani.infraestructure.repository;

import com.codigo.msapazamamani.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
    List<Persona> findByActivoTrue();
    List<Persona> findByTipoDocumento(String tipoDocumento);
    Persona findByNumeroDocumento(String numeroDocumento);
    List<Persona> findByTipoPersona(String tipoPersona);

    List<Persona> findByNumDocu(String numDocu);

    Persona findByEstado(int i);
}