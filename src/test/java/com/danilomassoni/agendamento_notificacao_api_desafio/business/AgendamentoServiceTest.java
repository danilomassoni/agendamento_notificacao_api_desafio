package com.danilomassoni.agendamento_notificacao_api_desafio.business;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.danilomassoni.agendamento_notificacao_api_desafio.business.mapper.IAgendamentoMapper;
import com.danilomassoni.agendamento_notificacao_api_desafio.infrastructure.entity.Agendamento;
import com.danilomassoni.agendamento_notificacao_api_desafio.infrastructure.enums.StatusNotificacaoEnum;
import com.danilomassoni.agendamento_notificacao_api_desafio.infrastructure.repositories.AgandemantoRepository;
import com.danilomassoni.agendamento_notificacao_api_desafio.controller.dto.in.AgendamentoRecord;
import com.danilomassoni.agendamento_notificacao_api_desafio.controller.dto.out.AgendamentoRecordOut;

import java.time.LocalDateTime;



@ExtendWith(MockitoExtension.class)
public class AgendamentoServiceTest {
    

    @InjectMocks
    private AgendamentoService agendamentoService;

    @Mock
    private AgandemantoRepository agendamentoRepository;


    @Mock
    private IAgendamentoMapper agendamentoMapper;

    
    private AgendamentoRecord agendamentoRecord;
    private AgendamentoRecordOut agendamentoRecordOut;
    private Agendamento agendamentoEntity;

    @BeforeEach
    void setUp() {
        agendamentoEntity = new Agendamento(1L, "email@email.com", "55887996578",
                LocalDateTime.of(2025, 1, 2, 11, 1, 1),
                LocalDateTime.now(),null,
                "Mensagem ao cliente",
                StatusNotificacaoEnum.AGENDADO);

        agendamentoRecord = new AgendamentoRecord("email@email.com", "55887996578",
                "Mensagem ao cliente", LocalDateTime.of(2025, 1, 2, 11, 1, 1));

        agendamentoRecordOut = new AgendamentoRecordOut(1L, "email@email.com", "55887996578",
                "Mensagem ao cliente", LocalDateTime.of(2025, 1, 2, 11, 1, 1),
                StatusNotificacaoEnum.AGENDADO);
    }

    @Test
    void deveGravarAgendamentoComSucesso(){
        when(agendamentoMapper.paraEntity(agendamentoRecord)).thenReturn(agendamentoEntity);
        when(agendamentoRepository.save(agendamentoEntity)).thenReturn(agendamentoEntity);
        when(agendamentoMapper.paraOut(agendamentoEntity)).thenReturn(agendamentoRecordOut);

        AgendamentoRecordOut out = agendamentoService.gravarAgendamento(agendamentoRecord);

        verify(agendamentoMapper, times(1)).paraEntity(agendamentoRecord);
        verify(agendamentoRepository, times(1)).save(agendamentoEntity);
        verify(agendamentoMapper, times(1)).paraOut(agendamentoEntity);
        assertThat(out).usingRecursiveComparison().isEqualTo(agendamentoRecordOut);
    }

}
