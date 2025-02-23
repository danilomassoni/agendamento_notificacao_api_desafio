package com.danilomassoni.agendamento_notificacao_api_desafio.controller.dto.in;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public record AgendamentoRecord(String emailDestinatario, 
                                String telefoneDestinatario,
                                String mensagem, 
                                @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:MM:SS")
                                LocalDateTime dataHoraEnvio) {
                                
          
    
}
