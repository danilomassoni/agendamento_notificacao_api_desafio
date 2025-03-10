package com.danilomassoni.agendamento_notificacao_api_desafio.controller.dto.out;

import java.time.LocalDateTime;

import com.danilomassoni.agendamento_notificacao_api_desafio.infrastructure.enums.StatusNotificacaoEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

// A classe AgendamentoRecordOut é responsável por representar o objeto de resposta da API de agendamento de notificações.
public record AgendamentoRecordOut(Long id,
                                String emailDestinatario, 
                                String telefoneDestinatario,
                                String mensagem, 
                                @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
                                LocalDateTime dataHoraEnvio,
                                StatusNotificacaoEnum statusNotificacao) {
                                
          
    
}
