package com.codigo.msapazamamani.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_persona")
public class TipoPersona {

    public String toString;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoPersona;

    @Column(name = "cod_tipo", nullable = false, length = 45)
    private String codTipo;

    @Column(name = "desc_tipo", nullable = false, length = 45)
    private String descTipo;

    @Column(name = "estado", nullable = false)
    private Integer estado;


    public Long getIdTipoPersona() {
        return null;
    }

    public String getCodTipo() {
        return null;
    }
}