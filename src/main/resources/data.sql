CREATE TABLE produtos (
    id varchar(36) PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    descricao VARCHAR(300),
    quantidade INT NOT NULL,
    preco NUMERIC(10, 2) NOT NULL,
    dataPostagem date
);