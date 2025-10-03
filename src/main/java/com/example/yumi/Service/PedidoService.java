package com.example.yumi.Service;

import com.example.yumi.Model.Pedido;
import com.example.yumi.Model.Usuario;
import com.example.yumi.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PedidoService {

    @Autowired
    private OrderRepository orderRepository;

    public PedidoService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Pedido crearPedido(Usuario usuario, Double total){
        Pedido pedido = new Pedido();
        pedido.setUsuario(usuario);
        pedido.setFechaPediddo(LocalDateTime.now());
        pedido.setTotal(total);
        pedido.setEstado("PENDIENTE");
        return orderRepository.save(pedido);
    }

}
