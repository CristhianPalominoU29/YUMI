package com.example.yumi.Controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class NofiticacionController {
    @MessageMapping("/notificar")
    @SendTo("/tema/notificaciones")
    public String enviarNotificacion(String mensaje) {
        return mensaje;  // Envía a todos los suscriptores
    }
}
