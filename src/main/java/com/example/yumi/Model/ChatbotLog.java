package com.example.yumi.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "chatbot_logs")
public class ChatbotLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Column(columnDefinition = "TEXT")
    private String usuarioMensaje;

    @Column(columnDefinition = "TEXT")
    private String botRespuesta;

    private LocalDateTime timestamp;


}
