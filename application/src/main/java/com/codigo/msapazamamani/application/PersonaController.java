package com.codigo.msapazamamani.application;

import com.codigo.msapazamamani.domain.*;
import com.codigo.msapazamamani.infraestructure.ReniecClient;
import com.codigo.msapazamamani.infraestructure.ReniecResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v2/persona")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @Autowired
    private final TipoDocumentoService tipoDocumentoService;

    @Autowired
    private TipoPersonaService tipoPersonaService;

    @Autowired
    private ReniecClient reniecClient;
    private TipoPersona tipoPersona;

    public PersonaController(TipoDocumentoService tipoDocumentoService) {
        this.tipoDocumentoService = tipoDocumentoService;
    }

    @PostMapping
    public ResponseEntity<Persona> crearPersona(@RequestBody Persona persona) throws IOException {

        TipoDocumento tipoDocumento = tipoDocumentoService.getTipoDocumentoById(persona.getTipoDocumento().getIdTipoDocumento());


        persona.setTipoDocumento(tipoDocumento);
        persona.setTipoPersona(tipoPersona);
        Persona nuevaPersona = personaService.getClass(persona);

        ReniecResponse reniecResponse = reniecClient.getPersonaByDni(persona.getNumDocu());
        if (reniecResponse != null && reniecResponse.getData() != null) {
            nuevaPersona.setNombres(reniecResponse.getData().getNombres());
            nuevaPersona.setApePat(reniecResponse.getData().getApellidoPaterno());
            nuevaPersona.setApeMat(reniecResponse.getData().getApellidoMaterno());
        }

        return ResponseEntity.created(URI.create("/personas/" + nuevaPersona.getId())).body(nuevaPersona);
    }

    @GetMapping("/{numDoc}")
    public ResponseEntity<Persona> consultarPersona(@PathVariable String numDoc) {

        Persona persona = personaService.obtenerPersonaPorNumDoc(numDoc);

        if (persona == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(persona);
    }

    @GetMapping
    public ResponseEntity<List<Persona>> consultarPersonas() {

        List<Persona> personas = personaService.obtenerPersonasActivas();

        return ResponseEntity.ok(personas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Persona> actualizarPersona(@PathVariable Long id, @RequestBody Persona persona) {

        persona.setId(id);
        TipoDocumento tipoDocumento = tipoDocumentoService.getTipoDocumentoById(persona.getTipoDocumento().getIdTipoDocumento());


        persona.setTipoDocumento(tipoDocumento);
        persona.setTipoPersona(tipoPersona);
        Persona personaActualizada = personaService.actualizarPersona(persona);

        if (personaActualizada == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(personaActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPersona(@PathVariable Long id) {

        personaService.eliminarPersona(id);

        return ResponseEntity.noContent().build();
    }

    private class PersonaService {
        public Persona getClass(Persona persona) {
            return persona;
        }

        public Persona obtenerPersonaPorNumDoc(String numDoc) {
            return null;
        }

        public List<Persona> obtenerPersonasActivas() {
            return null;
        }

        public Persona actualizarPersona(Persona persona) {
            return persona;
        }

        public void eliminarPersona(Long id) {
        }
    }
}