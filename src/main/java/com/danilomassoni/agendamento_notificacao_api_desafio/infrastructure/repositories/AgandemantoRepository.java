package com.danilomassoni.agendamento_notificacao_api_desafio.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.danilomassoni.agendamento_notificacao_api_desafio.infrastructure.entity.Agendamento;

public interface AgandemantoRepository extends JpaRepository<Agendamento, Long> {


}
