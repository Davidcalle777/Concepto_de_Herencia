CREATE DATABASE IF NOT EXISTS concepto_de_Herencia;
USE concepto_de_Herencia;

CREATE TABLE IF NOT EXISTS Persona (
                                       id INT AUTO_INCREMENT PRIMARY KEY,
                                       nombre VARCHAR(100) NOT NULL,
                                       apellido VARCHAR(100) NOT NULL,
                                       fecha_nacimiento DATE NOT NULL,
                                       genero VARCHAR(10),
                                       estatura DOUBLE,
                                       peso DOUBLE
);

CREATE TABLE IF NOT EXISTS Profesor (
                                        id INT PRIMARY KEY,
                                        especialidad VARCHAR(100),
                                        salario DOUBLE,
                                        anos_experiencia INT,
                                        titulo_academico VARCHAR(100),
                                        FOREIGN KEY (id) REFERENCES Persona(id) ON DELETE CASCADE
);
