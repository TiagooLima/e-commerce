DROP DATABASE IF EXISTS dimatti;
CREATE DATABASE dimatti;
USE dimatti;

CREATE TABLE usuarios(
id INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(100) NOT NULL,
email VARCHAR(100) NOT NULL,
telefone VARCHAR(11),
senha VARCHAR(32) NOT NULL
);

INSERT INTO usuarios(nome, email, telefone, senha) VALUES
('Matheus', 'matheus@gmail.com', '47997188861', '123456789'),
('Ana', 'ana@gmail.com', '47123456789', '1234567789');


SELECT * FROM usuarios;

SELECT nome, senha FROM usuarios  WHERE nome = usuarios;