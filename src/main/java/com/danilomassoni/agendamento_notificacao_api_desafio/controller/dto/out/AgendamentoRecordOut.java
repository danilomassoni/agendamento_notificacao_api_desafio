package com.danilomassoni.agendamento_notificacao_api_desafio.controller.dto.out;

import java.time.LocalDateTime;

import com.danilomassoni.agendamento_notificacao_api_desafio.infrastructure.enums.StatusNotificacaoEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

public record AgendamentoRecordOut(Long id,
                                String emailDestinatario, 
                                String telefoneDestinatario,
                                String mensagem, 
                                @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:MM:SS")
                                LocalDateTime dataHoraEnvio,
                                StatusNotificacaoEnum statusNotificacao) {
                                
          
    
}
