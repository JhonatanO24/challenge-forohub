CREATE TABLE respuestas (
    id BIGINT NOT NULL AUTO_INCREMENT,
    mensaje VARCHAR(767) NOT NULL,
    fecha_creacion DATETIME NOT NULL,
    id_topico BIGINT NOT NULL,
    id_autor BIGINT NOT NULL,
    solucion BOOLEAN NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_topico) REFERENCES topicos(id),
    FOREIGN KEY (id_autor) REFERENCES usuarios(id)
);