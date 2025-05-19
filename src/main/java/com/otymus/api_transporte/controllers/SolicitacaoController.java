package com.otymus.api_transporte.controllers;

import com.otymus.api_transporte.entities.Solicitacao.Dto.SolicitacaoCadastroDto;
import com.otymus.api_transporte.entities.Solicitacao.Dto.SolicitacaoDto;
import com.otymus.api_transporte.entities.Solicitacao.Dto.SolicitacaoResponseDto;
import com.otymus.api_transporte.exceptions.ErrorMessage;
import com.otymus.api_transporte.services.SolicitacaoService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/solicitacao")
public class SolicitacaoController {

    private static final Logger logger = LoggerFactory.getLogger(SolicitacaoController.class);
    public record Mensagem(String mensagem) {}

    @Autowired
    private final SolicitacaoService solicitacaoService;

    public SolicitacaoController(SolicitacaoService solicitacaoService) {
        this.solicitacaoService = solicitacaoService;
    }

    @PostMapping
    @Transactional
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<Object> cadastrar(@RequestBody SolicitacaoCadastroDto dto) {
        logger.info("Recebendo dados para cadastro de solicitação: {}", dto);
        SolicitacaoDto resposta = solicitacaoService.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<List<SolicitacaoResponseDto>> listar() {
        return ResponseEntity.ok(solicitacaoService.listarTodos());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<Object> buscarPorId(@PathVariable Long id) {
        SolicitacaoDto dto = solicitacaoService.buscarPorId(id);
        if (dto != null) {
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMessage("Solicitação com ID " + id + " não encontrado"));
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<?> excluir(@PathVariable Long id) {
        logger.info("Tentando excluir solicitação com ID: {}", id);
        boolean excluido = solicitacaoService.excluir(id);
        if (excluido) {
            return ResponseEntity.ok(new Mensagem("Solicitação excluída com sucesso."));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new Mensagem("Solicitação com ID " + id + " não encontrado."));
        }
    }

    @PutMapping("/{id}")
    @Transactional
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody SolicitacaoCadastroDto dto) {
        logger.info("Atualizando solicitação com ID: {} e dados: {}", id, dto);
        SolicitacaoDto resposta = solicitacaoService.atualizar(id, dto);
        if (resposta != null) {
            return ResponseEntity.ok(resposta);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMessage("Solicitação com ID " + id + " não encontrado"));
        }
    }

    @GetMapping("/paginado/")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public List<SolicitacaoDto> listarPaginado(@RequestParam(defaultValue = "0") int page,
                                               @RequestParam(defaultValue = "5") int size) {
        return solicitacaoService.listarPaginado(page, size);
    }

}
