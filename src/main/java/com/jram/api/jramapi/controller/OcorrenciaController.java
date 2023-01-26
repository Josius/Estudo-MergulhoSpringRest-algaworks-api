package com.jram.api.jramapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jram.api.jramapi.DTOs.OcorrenciaDTO;
import com.jram.api.jramapi.DTOs.input.OcorrenciaInputDTO;
import com.jram.api.jramapi.assembler.OcorrenciaAssembler;
import com.jram.api.jramapi.entitiy.Entrega;
import com.jram.api.jramapi.entitiy.Ocorrencia;
import com.jram.api.jramapi.service.BuscaEntregaService;
import com.jram.api.jramapi.service.RegistroOcorrenciaService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {
    
    private BuscaEntregaService buscaEntregaService;
    private RegistroOcorrenciaService registroOcorrenciaService;
    private OcorrenciaAssembler ocorrenciaAssembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OcorrenciaDTO registrar(@PathVariable Long entregaId, @Valid @RequestBody OcorrenciaInputDTO ocorrenciaInputDTO){

        Ocorrencia ocorrenciaRegistrada =  registroOcorrenciaService.registrar(entregaId, ocorrenciaInputDTO.getDescricao());

        return ocorrenciaAssembler.toDTO(ocorrenciaRegistrada);
    }

    @GetMapping
    public List<OcorrenciaDTO> listar(@PathVariable Long entregaId){
        
        Entrega entrega = buscaEntregaService.buscar(entregaId);

        return ocorrenciaAssembler.toCollectionModel(entrega.getOcorrencias());
    }
}
