package com.example.yumi.Repository;

import com.example.yumi.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    Usuario findByEmail(String email);

}
