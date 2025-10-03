package com.example.yumi.Controller;

import com.example.yumi.Model.Usuario;
import com.example.yumi.Service.UsuarioService;
import com.example.yumi.config.Utiljwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private BCryptPasswordEncoder codificadorContrasena;

    @Autowired
    private Utiljwt utilJwt;

    @PostMapping("/registrar")
    public ResponseEntity<Usuario> registrar(@RequestBody Usuario usuario){
        return ResponseEntity.ok(usuarioService.registrarUsuario(usuario));
    }

    @PostMapping("/iniciar-sesion")
    public ResponseEntity<String> iniciarSesion(@RequestBody Usuario usuario) {
        Usuario encontrado = usuarioService.buscarPorCorreo(usuario.getEmail());
        if (encontrado != null && codificadorContrasena.matches(usuario.getPassword(), encontrado.getPassword())) {
            return ResponseEntity.ok(utilJwt.generarToken(usuario.getEmail()));
        }
        return ResponseEntity.status(401).body("Credenciales inválidas");
    }
}
