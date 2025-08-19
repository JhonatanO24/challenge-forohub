package com.challenge.forohub.controller;

import com.challenge.forohub.domain.respuestas.DatosActualizacionRespuesta;
import com.challenge.forohub.domain.respuestas.DatosDetalleRespuesta;
import com.challenge.forohub.domain.respuestas.DatosRegistroRespuesta;
import com.challenge.forohub.domain.respuestas.RespuestaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/respuestas")
@SecurityRequirement(name = "bearer-key")
public class RespuestaController {

    @Autowired
    private RespuestaService respuestaService;

    @PostMapping
    @Transactional
    public ResponseEntity<DatosDetalleRespuesta> registrar(@RequestBody @Valid DatosRegistroRespuesta datos, UriComponentsBuilder uriBuilder) {
        DatosDetalleRespuesta respuesta = respuestaService.registrar(datos);
        var uri = uriBuilder.path("/respuestas/{id}").buildAndExpand(respuesta.id()).toUri();
        return ResponseEntity.created(uri).body(respuesta);
    }

    @GetMapping("/topico/{idTopico}")
    public ResponseEntity<Page<DatosDetalleRespuesta>> listarPorTopico(@PathVariable Long idTopico, @PageableDefault(size = 10, sort = "fechaCreacion") Pageable paginacion) {
        Page<DatosDetalleRespuesta> page = respuestaService.listarPorTopico(idTopico, paginacion);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosDetalleRespuesta> obtenerPorId(@PathVariable Long id) {
        DatosDetalleRespuesta respuesta = respuestaService.obtenerPorId(id);
        return ResponseEntity.ok(respuesta);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DatosDetalleRespuesta> actualizar(@RequestBody @Valid DatosActualizacionRespuesta datos) {
        DatosDetalleRespuesta respuestaActualizada = respuestaService.actualizar(datos);
        return ResponseEntity.ok(respuestaActualizada);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        respuestaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}

