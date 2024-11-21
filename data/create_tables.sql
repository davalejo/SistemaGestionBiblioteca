CREATE DATABASE biblioteca;

USE biblioteca;

CREATE TABLE Persona (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    tipo VARCHAR(20)
);

CREATE TABLE Usuario (
    id INT PRIMARY KEY,
    prestamos INT,
    FOREIGN KEY (id) REFERENCES Persona(id)
);

CREATE TABLE Bibliotecario (
    id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES Persona(id)
);

CREATE TABLE Libro (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100),
    autor VARCHAR(100),
    isbn VARCHAR(20),
    disponible BOOLEAN
);

CREATE TABLE Prestamo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    libro_id INT,
    usuario_id INT,
    fecha_prestamo DATE,
    fecha_devolucion DATE,
    FOREIGN KEY (libro_id) REFERENCES Libro(id),
    FOREIGN KEY (usuario_id) REFERENCES Usuario(id)
);
