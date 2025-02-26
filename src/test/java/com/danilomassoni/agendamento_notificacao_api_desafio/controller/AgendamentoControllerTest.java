package com.danilomassoni.agendamento_notificacao_api_desafio.controller;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.danilomassoni.agendamento_notificacao_api_desafio.business.AgendamentoService;
import com.danilomassoni.agendamento_notificacao_api_desafio.controller.dto.in.AgendamentoRecord;
import com.danilomassoni.agendamento_notificacao_api_desafio.controller.dto.out.AgendamentoRecordOut;
import com.danilomassoni.agendamento_notificacao_api_desafio.infrastructure.enums.StatusNotificacaoEnum;

@ExtendWith(MockitoExtension.class)
public class AgendamentoControllerTest {

    @InjectMocks
    AgendamentoController agendamentoController;

    @Mock 
    AgendamentoService service;

    private AgendamentoRecord agendamentoRecord;
    private AgendamentoRecordOut agendamentoRecordOut;

    @BeforeEach
    void setup{
        agendamentoRecord = new AgendamentoRecord("email@email.com", "5517991658256",
             "Mensagem de teste", LocalDateTime.of(2025, 1, 2, 11, 1, 1));     
             
        agendamentoRecordOut = new AgendamentoRecordOut(1L, "email@email.com", "5517991698260",
              "Mensagem de teste saída", LocalDateTime.of(2025, 1, 2, 11, 1, 1), 
              StatusNotificacaoEnum.AGENDADO);
    }

    
    
}
