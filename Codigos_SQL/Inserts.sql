use complejo_cines;

insert into cine (calle, nombre) values
("Bvar. Artigas 1825", "Tres Cruces"),
("Av. Italia 5775", "Portones");

insert into empleado (cine_ID, cargo, nombre, apellido, fecha_ingreso) values
(1, "cajero", "Marcos", "Díaz", "2021-05-01"),
(1, "acomodador", "Natalia", "Cruz", "2022-08-15"),
(2, "cajero", "Óscar", "Peña", "2020-03-10");

insert into sala (cine_ID, numero, capacidad_maxima) values
(1, 1, 6),
(1, 2, 6),
(2, 1, 4);

insert into pelicula (titulo, clasificacion_por_edad) values
("Aventura Estelar", "12"),
("Risas en la Ciudad", "ATP"),
("Sombras del Pasado", "18");

insert into genero (pelicula_ID, genero) values
(1, "Ciencia ficción"),
(2, "Comedia"),
(3, "Terror");

insert into funcion (sala_ID, cine_ID, fecha, hora, precio_base) values
(1, 1, "2024-04-10", "18:00", 320),
(2, 1, "2024-04-11", "19:30", 320),
(3, 2, "2024-04-12", "22:00", 400),
(1, 1, "2024-04-10", "21:00", 380);

insert into proyecta (pelicula_ID, sala_ID, cine_ID, funcion_ID) values
(1, 1, 1, 1),
(2, 2, 1, 2),
(3, 3, 2, 3),
(1, 1, 1, 4);

insert into cliente (documento, nombre, apellido, correo_electronico, contrasena) values
(44123456, "Paula", "Nuñez", "xxxxx@mail.com", "1234"),
(37654321, "Ramiro", "Techera", "aaaaaaa@mail.com", "8942"),
(50112233, "Sofía", "Larrosa", "bbbbbbbb@mail.com", "2931sofia");

insert into asiento (sala_ID, cine_ID, fila, numero) values
(1, 1, "A", 1),
(1, 1, "A", 2),
(2, 1, "A", 1),
(3, 2, "A", 1),
(3, 1, "B", 1);

insert into aloja (asiento_ID, sala_ID, cine_ID, funcion_ID) values
(1, 1, 1, 1),
(2, 1, 1, 1),
(3, 2, 1, 2),
(4, 3, 2, 3),
(5, 1, 1, 4);

insert into compra (cliente_CI, fecha, hora, metodo_pago, estado) values
(44123456, "2024-04-10", "10:00", "Tarjeta", true),
(44123456, "2024-04-10", "9:00", "Tarjeta", false),
(37654321, "2024-04-11", "8:00", "Efectivo", true),
(50112233, "2024-04-12", "10:00", "Tarjeta", true),
(50112233, "2024-04-10", "12:00", "Tarjeta", true);

insert into entrada (precio_pagado, asiento_ID, sala_ID, cine_ID, funcion_ID, compra_ID) values
(320, 1, 1, 1, 1, 1),
(320, 2, 1, 1, 1, 2),
(320, 3, 2, 1, 2, 3),
(400, 4, 3, 2, 3, 4),
(380, 5, 1, 1, 4, 5);

