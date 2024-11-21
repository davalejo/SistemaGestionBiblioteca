-- Personas
INSERT INTO Persona (nombre, apellido, tipo) VALUES
('Juan', 'Perez', 'Usuario'),
('Ana', 'Gomez', 'Usuario'),
('Carlos', 'Lopez', 'Bibliotecario'),
('Maria', 'Diaz', 'Usuario'),
('Luis', 'Torres', 'Bibliotecario');

-- Usuarios
INSERT INTO Usuario (id, prestamos) VALUES
(1, 0),
(2, 1),
(4, 3);

-- Bibliotecarios
INSERT INTO Bibliotecario (id) VALUES
(3),
(5);

-- Libros
INSERT INTO Libro (titulo, autor, isbn, disponible) VALUES
('Libro 1', 'Autor A', '1234567890', TRUE),
('Libro 2', 'Autor B', '2345678901', TRUE),
('Libro 3', 'Autor C', '3456789012', TRUE),
('Libro 4', 'Autor D', '4567890123', FALSE),
('Libro 5', 'Autor E', '5678901234', TRUE);

-- Préstamos
INSERT INTO Prestamo (libro_id, usuario_id, fecha_prestamo, fecha_devolucion) VALUES
(4, 2, '2024-01-10', '2024-01-20'),
(3, 4, '2024-02-01', NULL);