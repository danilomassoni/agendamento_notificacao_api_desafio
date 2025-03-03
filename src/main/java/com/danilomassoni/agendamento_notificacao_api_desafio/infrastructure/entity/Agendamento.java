package com.danilomassoni.agendamento_notificacao_api_desafio.infrastructure.entity;

import java.time.LocalDateTime;

import com.danilomassoni.agendamento_notificacao_api_desafio.infrastructure.enums.StatusNotificacaoEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "agendamento")
@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String emailDestinatario; 
    private String telefoneDestinatario;
    private LocalDateTime dataHoraEnvio;
    private LocalDateTime dataHoraAndamento;
    private LocalDateTime dataHoraModificacao; 
    private String mensagem; 
    private StatusNotificacaoEnum statusNotificacao;
    
    @PrePersist
    private void PrePersist(){
        dataHoraAndamento = LocalDateTime.now();
        statusNotificacao = StatusNotificacaoEnum.AGENDADO;
    }
}
