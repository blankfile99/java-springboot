CREATE TABLE pacientes (
                         id bigserial PRIMARY KEY,
                         nome varchar(100) NOT NULL,
                         email varchar(100) NOT NULL UNIQUE,
                         logradouro varchar(100) NOT NULL,
                         telefone varchar(50) NOT NULL,
                         cpf varchar(25) NOT NULL,
                         bairro varchar(100) NOT NULL,
                         cep varchar(9) NOT NULL,
                         complemento varchar(100),
                         numero varchar(20),
                         uf char(2) NOT NULL,
                         cidade varchar(100) NOT NULL
);