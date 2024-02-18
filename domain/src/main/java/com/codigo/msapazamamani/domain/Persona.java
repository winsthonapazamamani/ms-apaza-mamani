package com.codigo.msapazamamani.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Optional;

@Entity
@Table(name = "persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Long id;

    @Column(name = "num_docu")
    private String numDocu;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "ape_pat")
    private String apePat;

    @Column(name = "ape_mat")
    private String apeMat;

    @Column(name = "estado")
    private Integer estado;

    @Column(name = "usua_crea")
    private String usuaCrea;

    @Column(name = "date_create")
    private LocalDateTime dateCreate;

    @Column(name = "usua_modif")
    private String usuaModif;

    @Column(name = "date_modif")
    private LocalDateTime dateModif;

    @Column(name = "usua_delet")
    private String usuaDelet;

    @Column(name = "date_delet")
    private LocalDateTime dateDelet;

    @Getter
    @ManyToOne
    @JoinColumn(name = "id_tipo_documento")
    private TipoDocumento tipoDocumento;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "id_tipo_persona")
    private TipoPersona tipoPersona;

    public Persona() {}

    public Persona(String numDocu, String nombres, String apePat, String apeMat, Integer estado, String usuaCrea, LocalDateTime dateCreate, String usuaModif, LocalDateTime dateModif, String usuaDelet, LocalDateTime dateDelet, TipoDocumento tipoDocumento, TipoPersona tipoPersona) {
        this.numDocu = numDocu;
        this.nombres = nombres;
        this.apePat = apePat;
        this.apeMat = apeMat;
        this.estado = estado;
        this.usuaCrea = usuaCrea;
        this.dateCreate = dateCreate;
        this.usuaModif = usuaModif;
        this.dateModif = dateModif;
        this.usuaDelet = usuaDelet;
        this.dateDelet = dateDelet;
        this.tipoDocumento = tipoDocumento;
        this.tipoPersona = tipoPersona;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumDocu() {
        return numDocu;
    }

    public void setNumDocu(String numDocu) {
        this.numDocu = numDocu;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApePat() {
        return apePat;
    }

    public void setApePat(String apePat) {
        this.apePat = apePat;
    }

    public String getApeMat() {
        return apeMat;
    }

    public void setApeMat(String apeMat) {
        this.apeMat = apeMat;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public String getUsuaCrea() {
        return usuaCrea;
    }

    public void setUsuaCrea(String usuaCrea) {
        this.usuaCrea = usuaCrea;
    }
    public void setDateCreate(LocalDateTime dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getUsuaModif() {
        return usuaModif;
    }

    public void setUsuaModif(String usuaModif) {
        this.usuaModif = usuaModif;
    }

    public LocalDateTime getDateModif() {
        return dateModif;
    }

    public void setDateModif(LocalDateTime dateModif) {
        this.dateModif = dateModif;
    }

    public String getUsuaDelet() {
        return usuaDelet;
    }

    public void setUsuaDelet(String usuaDelet) {
        this.usuaDelet = usuaDelet;
    }

    public LocalDateTime getDateDelet() {
        return dateDelet;
    }

    public void setDateDelet(LocalDateTime dateDelet) {
        this.dateDelet = dateDelet;
    }

    public Optional<TipoPersona> getTipoPersona() {
        return Optional.ofNullable(tipoPersona);
    }

    public void setTipoPersona(TipoPersona tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }


    public void setTipoPersona(Optional<Object> tipoPersona) {
    }
}