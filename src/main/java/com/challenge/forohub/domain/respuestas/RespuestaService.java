package com.challenge.forohub.domain.respuestas;

import com.challenge.forohub.domain.ValidacionException;
import com.challenge.forohub.domain.topico.TopicoRepository;
import com.challenge.forohub.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RespuestaService {

    @Autowired
    private RespuestaRepository respuestaRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public DatosDetalleRespuesta registrar(DatosRegistroRespuesta datos) {
        if (!topicoRepository.existsById(datos.idTopico())) {
            throw new ValidacionException("No existe un tópico con el ID proporcionado.");
        }
        if (!usuarioRepository.existsById(datos.idAutor())) {
            throw new ValidacionException("No existe un usuario con el ID proporcionado.");
        }
        var topico = topicoRepository.getReferenceById(datos.idTopico());
        var autor = usuarioRepository.getReferenceById(datos.idAutor());
        var respuesta = new Respuesta(null, datos.mensaje(), null, false, topico, autor);
        respuestaRepository.save(respuesta);
        return new DatosDetalleRespuesta(respuesta);
    }

    public Page<DatosDetalleRespuesta> listarPorTopico(Long idTopico, Pageable paginacion) {
        return respuestaRepository.findByTopicoId(idTopico, paginacion).map(DatosDetalleRespuesta::new);
    }

    public DatosDetalleRespuesta obtenerPorId(Long id) {
        Respuesta respuesta = respuestaRepository.findById(id)
                .orElseThrow(() -> new ValidacionException("No se encontró la respuesta con el ID proporcionado."));
        return new DatosDetalleRespuesta(respuesta);
    }

    public DatosDetalleRespuesta actualizar(DatosActualizacionRespuesta datos) {
        Respuesta respuesta = respuestaRepository.findById(datos.id())
                .orElseThrow(() -> new ValidacionException("No se encontró la respuesta con el ID proporcionado para actualizar."));

        if (datos.mensaje() != null) {
            respuesta.setMensaje(datos.mensaje());
        }
        if (datos.solucion() != null) {
            respuesta.setSolucion(datos.solucion());
        }
        respuestaRepository.save(respuesta);
        return new DatosDetalleRespuesta(respuesta);
    }

    public void eliminar(Long id) {
        if (!respuestaRepository.existsById(id)) {
            throw new ValidacionException("No se encontró la respuesta con el ID proporcionado para eliminar.");
        }
        respuestaRepository.deleteById(id);
    }
}

