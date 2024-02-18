package com.codigo.msapazamamani.domain;

import java.util.List;
import java.util.Optional;

public interface TipoDocumentoService {
    List<TipoDocumento> obtenerTodos();
    Optional<TipoDocumento> obtenerPorId(Long id);
    TipoDocumento guardar(TipoDocumento tipoDocumento);
    void eliminar(Long id);

    TipoDocumento getTipoDocumentoById(Long idTipoDocumento);

    TipoDocumento getTipoDocumentoByCodTipo(String codTipo);
}