CREATE TABLE notas_fiscais (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome_fornecedor VARCHAR(255) NOT NULL,
    valor_da_nf DECIMAL(19, 2) NOT NULL,
    data_de_emissao DATE NOT NULL
);
