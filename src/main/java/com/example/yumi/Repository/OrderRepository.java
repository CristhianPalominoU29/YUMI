package com.example.yumi.Repository;

import com.example.yumi.Model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Pedido,Long> {
}
