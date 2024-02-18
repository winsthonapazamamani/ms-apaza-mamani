package com.codigo.msapazamamani.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TipoPersonaRepository extends JpaRepository<TipoPersona, Long> {
    Optional<TipoPersona> findByCodTipo(String codTipo);
}