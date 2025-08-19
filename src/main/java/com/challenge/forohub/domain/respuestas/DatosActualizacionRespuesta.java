package com.challenge.forohub.domain.respuestas;

import jakarta.validation.constraints.NotNull;

public record DatosActualizacionRespuesta(@NotNull Long id,
                                          String mensaje,
                                          Boolean solucion) {
}
