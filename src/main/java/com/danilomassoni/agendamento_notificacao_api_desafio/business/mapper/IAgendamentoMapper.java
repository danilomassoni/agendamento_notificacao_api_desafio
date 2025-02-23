package com.danilomassoni.agendamento_notificacao_api_desafio.business.mapper;

import org.mapstruct.Mapper;

import com.danilomassoni.agendamento_notificacao_api_desafio.controller.dto.in.AgendamentoRecord;
import com.danilomassoni.agendamento_notificacao_api_desafio.controller.dto.out.AgendamentoRecordOut;
import com.danilomassoni.agendamento_notificacao_api_desafio.infrastructure.entity.Agendamento;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface IAgendamentoMapper {

    Agendamento paraEntity(AgendamentoRecord agendamento);
    
    AgendamentoRecordOut paraOut(Agendamento agendamento0);
}
