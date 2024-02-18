package com.codigo.msapazamamani.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tipo_documento")
public class TipoDocumento {
    // Getters and setters
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoDocumento;

    @Column(nullable = false, length = 45)
    private String codTipo;

    @Column(nullable = false, length = 45)
    private String descTipo;

    @Column(nullable = false)
    private int estado;

    @Column(length = 45)
    private String usuaCrea;

    @Column(name = "date_create", nullable = false)
    private LocalDateTime dateCreate;

    @Column(length = 45)
    private String usuaModif;

    @Column(name = "date_modif")
    private LocalDateTime dateModif;

    @Column(length = 45)
    private String usuaDelet;

    @Column(name = "date_delet")
    private LocalDateTime dateDelet;

}