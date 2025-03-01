package com.danilomassoni.agendamento_notificacao_api_desafio.business;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.danilomassoni.agendamento_notificacao_api_desafio.business.mapper.IAgendamentoMapper;
import com.danilomassoni.agendamento_notificacao_api_desafio.infrastructure.entity.Agendamento;

@ExtendWith(MockitoExtension.class)
public class AgendamentoServiceTest {
    

    @InjectMocks
    private AgendamentoService agendamentoService;

    @Mock
    private AgendamentoRepository agendamentoRepository;

    @Mock
    private IAgendamentoMapper agendamentoMapper;


}
