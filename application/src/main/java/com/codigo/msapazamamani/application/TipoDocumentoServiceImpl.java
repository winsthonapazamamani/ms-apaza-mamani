package com.codigo.msapazamamani.application;
import com.codigo.msapazamamani.domain.TipoDocumento;
import com.codigo.msapazamamani.domain.TipoDocumentoRepository;
import com.codigo.msapazamamani.domain.TipoDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoDocumentoServiceImpl implements TipoDocumentoService {

    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;

    @Override
    public List<TipoDocumento> obtenerTodos() {
        return tipoDocumentoRepository.findAll();
    }

    @Override
    public Optional<TipoDocumento> obtenerPorId(Long id) {
        return tipoDocumentoRepository.findById(id);
    }

    @Override
    public TipoDocumento guardar(TipoDocumento tipoDocumento) {
        return tipoDocumentoRepository.save(tipoDocumento);
    }

    @Override
    public void eliminar(Long id) {
        tipoDocumentoRepository.deleteById(id);
    }

    @Override
    public TipoDocumento getTipoDocumentoById(Long idTipoDocumento) {
        return null;
    }

    @Override
    public TipoDocumento getTipoDocumentoByCodTipo(String codTipo) {
        return null;
    }
}