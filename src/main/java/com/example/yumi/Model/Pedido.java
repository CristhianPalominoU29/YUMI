package com.example.yumi.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación con Usuario (FK)
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    // Fecha de la orden
    private LocalDateTime fechaPediddo;

    // Total de la compra
    private Double total;

    // Estado del pedido (ej: PENDIENTE, PAGADO, ENVIADO)
    private String estado;

    public Pedido() {
    }

    public Pedido(Long id, Usuario usuario, LocalDateTime fechaPediddo, Double total, String estado) {
        this.id = id;
        this.usuario = usuario;
        this.fechaPediddo = fechaPediddo;
        this.total = total;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getFechaPediddo() {
        return fechaPediddo;
    }

    public void setFechaPediddo(LocalDateTime fechaPediddo) {
        this.fechaPediddo = fechaPediddo;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
