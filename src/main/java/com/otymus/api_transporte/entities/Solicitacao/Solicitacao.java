package com.otymus.api_transporte.entities.Solicitacao;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.otymus.api_transporte.entities.Carro.Carro;
import com.otymus.api_transporte.entities.Motorista.Motorista;
import com.otymus.api_transporte.entities.Setor.Setor;
import com.otymus.api_transporte.entities.Usuario.Usuario;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Entity
@Table(name = "tb_solicitacao")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Solicitacao {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_solicitacao", nullable = false)
    private LocalDate dataSolicitacao;

    @Column(nullable = false)
    private String destino;

    @Column(nullable = false)
    private String status; // PENDENTE, APROVADA, RECUSADA

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_carro", nullable = false)
    private Carro carro;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_motorista", nullable = false)
    private Motorista motorista;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_setor", nullable = false)
    private Setor setor;

}
