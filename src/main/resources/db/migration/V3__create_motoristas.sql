-- Criação da tabela motoristas
CREATE TABLE tb_motorista (
                            id BIGINT PRIMARY KEY AUTO_INCREMENT,
                            matricula VARCHAR(20) NOT NULL UNIQUE,
                            nome VARCHAR(100) NOT NULL,
                            telefone VARCHAR(20) NOT NULL
);

-- Inserção de 5 registros iniciais
INSERT INTO tb_motorista (matricula, nome, telefone) VALUES
                                                       ('M001', 'João da Silva', '(11) 91234-5678'),
                                                       ('M002', 'Maria Oliveira', '(21) 98765-4321'),
                                                       ('M003', 'Carlos Souza', '(31) 99887-1122'),
                                                       ('M004', 'Ana Costa', '(41) 97333-4444'),
                                                       ('M005', 'Pedro Mendes', '(51) 99900-1234');