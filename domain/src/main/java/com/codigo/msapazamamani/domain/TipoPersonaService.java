package com.codigo.msapazamamani.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoPersonaService {

    @Autowired
    private TipoPersonaRepository tipoPersonaRepository;

    public List<TipoPersona> obtenerTodos() {
        return tipoPersonaRepository.findAll();
    }

    public Object obtenerPorId(Long id) {
        return tipoPersonaRepository.findById(id);
    }

    public TipoPersona guardar(TipoPersona tipoPersona) {
        return tipoPersonaRepository.save(tipoPersona);
    }

    public void eliminar(Long id) {
        tipoPersonaRepository.deleteById(id);
    }

    public Optional<TipoPersona> obtenerPorCodTipo(String codTipo) {
        return tipoPersonaRepository.findByCodTipo(codTipo);
    }

    public TipoPersona getTipoPersonaByCodTipo(String codTipo) {
        return null;
    }
}
