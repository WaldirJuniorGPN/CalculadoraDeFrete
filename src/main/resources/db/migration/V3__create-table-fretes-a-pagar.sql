CREATE TABLE fretes_a_pagar (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    tabela_id BIGINT,
    nota_id BIGINT,
    valorDoFrete DECIMAL(19, 2),
    FOREIGN KEY (tabela_id) REFERENCES tabelas(id),
    FOREIGN KEY (nota_id) REFERENCES notas_fiscais(id)
);
