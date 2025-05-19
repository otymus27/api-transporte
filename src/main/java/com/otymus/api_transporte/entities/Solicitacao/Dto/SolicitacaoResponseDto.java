package com.otymus.api_transporte.entities.Solicitacao.Dto;


import java.time.LocalDate;

// Usado para listagem e visualização (GET)
public record SolicitacaoResponseDto(
        Long id,
        LocalDate dataSolicitacao,
        String destino,
        String status,
        Long idCarro,
        String placaCarro,
        Long idMotorista,
        String nomeMotorista,
        Long idSetor,
        String nomeSetor,
        Long idUsuario,
        String nomeUsuario
) {}
