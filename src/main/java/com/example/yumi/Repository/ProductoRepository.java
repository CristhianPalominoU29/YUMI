package com.example.yumi.Repository;

import com.example.yumi.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto,Long> {

}
