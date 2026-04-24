DROP DATABASE IF EXISTS dimatti;
CREATE DATABASE dimatti;
USE dimatti;

create table usuarios(
id_usuario int auto_increment primary key not null,
nome varchar(100),
email varchar(50),
senha varchar(20)

);

INSERT INTO usuarios(nome, senha, email) VALUES
('Joao', 12345678, 'joao@gmail.com');


	select * from usuarios;