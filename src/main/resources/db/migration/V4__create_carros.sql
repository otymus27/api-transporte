-- Criação da tabela carros
CREATE TABLE tb_carro (
                        id BIGINT PRIMARY KEY AUTO_INCREMENT,
                        marca VARCHAR(50) NOT NULL,
                        modelo VARCHAR(100) NOT NULL,
                        placa VARCHAR(10) NOT NULL UNIQUE
);

-- Inserção de 5 registros iniciais
INSERT INTO tb_carro (marca, modelo, placa) VALUES
                                              ('Toyota', 'Corolla', 'ABC1A23'),
                                              ('Honda', 'Civic', 'DEF4B56'),
                                              ('Chevrolet', 'Onix', 'GHI7C89'),
                                              ('Volkswagen', 'Gol', 'JKL0D12'),
                                              ('Fiat', 'Argo', 'MNO3E45');
