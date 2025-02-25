package com.danilomassoni.agendamento_notificacao_api_desafio.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danilomassoni.agendamento_notificacao_api_desafio.business.AgendamentoService;
import com.danilomassoni.agendamento_notificacao_api_desafio.controller.dto.in.AgendamentoRecord;
import com.danilomassoni.agendamento_notificacao_api_desafio.controller.dto.out.AgendamentoRecordOut;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequiredArgsConstructor
@RequestMapping("/agendamento")
public class AgendamentoController {

    private final AgendamentoService agendamentoService;


    @PostMapping
    public ResponseEntity<AgendamentoRecordOut> gravarAgendamento(@RequestBody AgendamentoRecord agendamentoRecord) {
        return ResponseEntity.ok(agendamentoService.gravarAgendamento(agendamentoRecord));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoRecordOut> buscarAgendamentoPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(agendamentoService.buscarAgendamentosPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelamentoAgendamento(@PathVariable("id") Long id){
        agendamentoService.cancelarAgendamento(id);
        return ResponseEntity.accepted().build();
    }




    
}
