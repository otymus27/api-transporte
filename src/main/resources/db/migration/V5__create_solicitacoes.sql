-- Criação da tabela solicitacoes
CREATE TABLE tb_solicitacao (
                              id BIGINT PRIMARY KEY AUTO_INCREMENT,
                              data_solicitacao DATE NOT NULL,
                              destino VARCHAR(255) NOT NULL,
                              status VARCHAR(20) NOT NULL,
                              id_carro BIGINT NOT NULL,
                              id_motorista BIGINT NOT NULL,
                              id_usuario BIGINT NOT NULL,
                              id_setor BIGINT NOT NULL,
                              FOREIGN KEY (id_carro) REFERENCES tb_carro(id),
                              FOREIGN KEY (id_motorista) REFERENCES tb_motorista(id),
                              FOREIGN KEY (id_usuario) REFERENCES tb_usuarios(id),
                              FOREIGN KEY (id_setor) REFERENCES tb_setor(id)
);

-- Inserção de 5 registros iniciais
INSERT INTO tb_solicitacao (data_solicitacao, destino, status, id_carro, id_motorista, id_usuario, id_setor) VALUES
                                                                                                               ('2025-05-01', 'Aeroporto Internacional', 'PENDENTE', 1, 1, 1, 1),
                                                                                                               ('2025-05-02', 'Centro Administrativo', 'APROVADA', 2, 2, 2, 2),
                                                                                                               ('2025-05-03', 'Universidade Estadual', 'RECUSADA', 3, 3, 3, 3),
                                                                                                               ('2025-05-04', 'Zona Industrial', 'PENDENTE', 4, 4, 4, 4),
                                                                                                               ('2025-05-05', 'Hospital Central', 'APROVADA', 5, 5, 5, 5);
