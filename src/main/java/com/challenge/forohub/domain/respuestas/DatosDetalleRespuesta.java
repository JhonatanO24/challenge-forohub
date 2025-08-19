package com.challenge.forohub.domain.respuestas;

import java.time.LocalDateTime;

public record DatosDetalleRespuesta(Long id,
                                    String mensaje,
                                    LocalDateTime fechaCreacion,
                                    Boolean solucion,
                                    Long idTopico,
                                    Long idAutor) {
    public DatosDetalleRespuesta(Respuesta respuesta) {
        this(
                respuesta.getId(),
                respuesta.getMensaje(),
                respuesta.getFechaCreacion(),
                respuesta.getSolucion(),
                respuesta.getTopico().getId(),
                respuesta.getAutor().getId()
        );
    }
}