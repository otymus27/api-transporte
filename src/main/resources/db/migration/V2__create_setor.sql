CREATE TABLE tb_setor (
                              id BIGINT AUTO_INCREMENT PRIMARY KEY,
                              nome VARCHAR(255) NOT NULL UNIQUE
);

-- Dados iniciais
INSERT INTO tb_setor (nome) VALUES
                                    ('NUTRAN'),
                                    ('NARP'),
                                    ('NTINF'),
                                    ('RADIOLOGIA'),
                                    ('LABORATORIO')
