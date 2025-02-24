package com.danilomassoni.agendamento_notificacao_api_desafio.business;

import org.springframework.stereotype.Service;

import com.danilomassoni.agendamento_notificacao_api_desafio.business.mapper.IAgendamentoMapper;
import com.danilomassoni.agendamento_notificacao_api_desafio.controller.dto.in.AgendamentoRecord;
import com.danilomassoni.agendamento_notificacao_api_desafio.controller.dto.out.AgendamentoRecordOut;
import com.danilomassoni.agendamento_notificacao_api_desafio.infrastructure.exception.NotFoundException;
import com.danilomassoni.agendamento_notificacao_api_desafio.infrastructure.repositories.AgandemantoRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AgendamentoService {

    private final AgandemantoRepository repository;
    private final IAgendamentoMapper agendamentoMapper;

    public AgendamentoRecordOut gravarAgendamento(AgendamentoRecord agendamento){
        return agendamentoMapper.paraOut(repository.save(agendamentoMapper.paraEntity(agendamento)));
    }

    public AgendamentoRecordOut buscarAgendamentosPorId(Long id) {
        return agendamentoMapper.paraOut(repository.findById(id)
            .orElseThrow(() -> new NotFoundException("Id não encontrado")));
    }

    
}
