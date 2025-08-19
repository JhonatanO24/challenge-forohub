package com.challenge.forohub.domain.usuario;

import com.challenge.forohub.domain.ValidacionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public DatosDetalleUsuario registrar(DatosRegistroUsuario datos) {
        if (usuarioRepository.findByCorreoElectronico(datos.correoElectronico()) != null) {
            throw new ValidacionException("Ya existe un usuario con este correo electrónico.");
        }
        Usuario usuario = new Usuario(null, datos.nombre(), datos.correoElectronico(), passwordEncoder.encode(datos.contrasena()));
        usuarioRepository.save(usuario);
        return new DatosDetalleUsuario(usuario);
    }

    public Page<DatosDetalleUsuario> listar(Pageable paginacion) {
        return usuarioRepository.findAll(paginacion).map(DatosDetalleUsuario::new);
    }

    public DatosDetalleUsuario obtenerPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ValidacionException("No se encontró el usuario con el ID proporcionado."));
        return new DatosDetalleUsuario(usuario);
    }

    public DatosDetalleUsuario actualizar(DatosActualizacionUsuario datos) {
        Usuario usuario = usuarioRepository.findById(datos.id())
                .orElseThrow(() -> new ValidacionException("No se encontró el usuario con el ID proporcionado para actualizar."));

        if (datos.nombre() != null) {
            usuario.setNombre(datos.nombre());
        }
        if (datos.correoElectronico() != null) {
            usuario.setCorreoElectronico(datos.correoElectronico());
        }
        if (datos.contrasena() != null) {
            usuario.setContrasena(passwordEncoder.encode(datos.contrasena()));
        }
        usuarioRepository.save(usuario);
        return new DatosDetalleUsuario(usuario);
    }

    public void eliminar(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new ValidacionException("No se encontró el usuario con el ID proporcionado para eliminar.");
        }
        usuarioRepository.deleteById(id);
    }
}
