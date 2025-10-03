package com.example.yumi.Controller;

import com.example.yumi.Model.Pedido;
import com.example.yumi.Model.Usuario;
import com.example.yumi.Service.PedidoService;
import com.example.yumi.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    public PedidoService orderService;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Pedido> crearPedido(@RequestParam String email, @RequestParam double total) {
        Usuario usuarioActual = usuarioService.buscarPorCorreo(email);
        return ResponseEntity.ok(orderService.crearPedido(usuarioActual, total));
    }


}
