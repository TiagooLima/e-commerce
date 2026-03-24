DROP DATABASE IF EXISTS dimatti;
CREATE DATABASE dimatti;
USE dimatti;

CREATE TABLE usuarios(
id INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(100) NOT NULL,
email VARCHAR(100) NOT NULL,
telefone VARCHAR(11)
);

INSERT INTO usuarios(nome, email, telefone) VALUES
('Matheus', 'matheus@gmail.com', '47997188861'),
('Ana', 'ana@gmail.com', '47123456789');


SELECT * FROM usuarios;
