package com.example.yumi.Service;

import com.example.yumi.Model.Usuario;
import com.example.yumi.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder codificadorContrasena;

    public Usuario registrarUsuario(Usuario usuario){
        usuario.setPassword(codificadorContrasena.encode(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }

    public Usuario buscarPorCorreo(String correo){
        return usuarioRepository.findByEmail(correo);
    }

}
