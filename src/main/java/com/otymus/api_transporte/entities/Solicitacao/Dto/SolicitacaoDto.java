package com.otymus.api_transporte.entities.Solicitacao.Dto;

import com.otymus.api_transporte.entities.Carro.Carro;
import com.otymus.api_transporte.entities.Motorista.Motorista;
import com.otymus.api_transporte.entities.Setor.Setor;
import com.otymus.api_transporte.entities.Usuario.Usuario;

import java.time.LocalDate;

public record SolicitacaoDto(
        Long id,
        LocalDate dataSolicitacao,
        String destino,
        String status,
        Carro carro,
        Motorista motorista,
        Usuario usuario,
        Setor setor
) {
}
