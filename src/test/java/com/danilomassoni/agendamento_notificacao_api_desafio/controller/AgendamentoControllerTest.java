package com.danilomassoni.agendamento_notificacao_api_desafio.controller;

import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.danilomassoni.agendamento_notificacao_api_desafio.business.AgendamentoService;
import com.danilomassoni.agendamento_notificacao_api_desafio.controller.dto.in.AgendamentoRecord;
import com.danilomassoni.agendamento_notificacao_api_desafio.controller.dto.out.AgendamentoRecordOut;
import com.danilomassoni.agendamento_notificacao_api_desafio.infrastructure.enums.StatusNotificacaoEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@ExtendWith(MockitoExtension.class)
public class AgendamentoControllerTest {

    @InjectMocks
    AgendamentoController agendamentoController;

    @Mock 
    AgendamentoService service;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    

    private AgendamentoRecord agendamentoRecord;
    private AgendamentoRecordOut agendamentoRecordOut;

    @BeforeEach
    void setup(){

        mockMvc = MockMvcBuilders.standaloneSetup(agendamentoController).build();
        
        objectMapper.registerModule(new JavaTimeModule());

        agendamentoRecord = new AgendamentoRecord("email@email.com", "5517991658256",
             "Mensagem de teste", LocalDateTime.of(2025, 1, 2, 11, 1, 1));     
             
        agendamentoRecordOut = new AgendamentoRecordOut(1L, "email@email.com", "5517991698260",
              "Mensagem de teste saída", LocalDateTime.of(2025, 1, 2, 11, 1, 1), 
              StatusNotificacaoEnum.AGENDADO);
    }

    @Test
    void deveCriarAgendamentoComSucesso() throws Exception{
        when(agendamentoService.gravarAgendamento(agendamentoRecord)).thenReturn(agendamentoRecordOut);

        mockMvc.perform(post("/agendamento")
                .contentTyype(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(agendamentoRecord)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                



    }

    
    
}
