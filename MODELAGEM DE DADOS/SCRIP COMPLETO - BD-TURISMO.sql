create database turismo;

use turismo;

CREATE TABLE Cliente (
id_cliente INTEGER PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(50),
endereco VARCHAR(200),
telefone VARCHAR(20)
);

CREATE TABLE Promocao (
observacao VARCHAR(200),
nomePacote VARCHAR(50),
percentual DECIMAL(10),
id_promocao INTEGER PRIMARY KEY AUTO_INCREMENT
);

CREATE TABLE Destino (
descricao VARCHAR(200),
valor DECIMAL(10),
nome VARCHAR(50),
id_destino INTEGER PRIMARY KEY AUTO_INCREMENT,
hotel VARCHAR(50),
id_cliente INTEGER,
id_promocao INTEGER,
FOREIGN KEY(id_cliente) REFERENCES Cliente (id_cliente),
FOREIGN KEY(id_promocao) REFERENCES Promocao (id_promocao)
);


SELECT * FROM PROMOCAO;
SELECT * FROM DESTINO;
SELECT * FROM CLIENTE;


