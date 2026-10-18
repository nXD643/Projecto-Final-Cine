use complejo_cines;

insert into cine (calle, ciudad, nombre) values
("Bvar. Artigas 1825", "Montevideo", "Tres Cruces"),
("Av. Italia 5775", "Montevideo", "Portones");

insert into empleado (cine_ID, cargo, nombre, apellido, fecha_ingreso) values
(1, "cajero", "Marcos", "Díaz", "2021-05-01"),
(1, "acomodador", "Natalia", "Cruz", "2022-08-15"),
(2, "cajero", "Óscar", "Peña", "2020-03-10");

insert into sala (cine_ID, numero, largo_asientos, ancho_asientos, capacidad_maxima) values
(1, 1, 7, 10, 70),
(1, 2, 6, 6, 36),
(2, 1, 10, 10, 100);

insert into pelicula (titulo, anio_estreno, duracion, clasificacion_por_edad) values
("Aventura Estelar", "2020-01-01", "120 minutos", "12"),
("Risas en la Ciudad", "2023-01-01", "113 minutos", "ATP"),
("Sombras del Pasado", "2022-01-10", "90 minutos", "18");

insert into genero (pelicula_ID, genero) values
(1, "Ciencia ficción"),
(2, "Comedia"),
(3, "Terror");

insert into funcion (sala_ID, cine_ID, pelicula_ID, fecha, hora, precio_base) values
(1, 1, 1, "2024-04-10", "18:00", 320),
(2, 1, 2, "2024-04-11", "19:30", 320),
(3, 2, 3, "2024-04-12", "22:00", 400),
(1, 1, 1, "2024-04-10", "21:00", 380);

insert into cliente (documento, nombre, apellido, correo_electronico, contrasena) values
(44123456, "Paula", "Nuñez", "xxxxx@mail.com", "1234"),
(37654321, "Ramiro", "Techera", "aaaaaaa@mail.com", "8942"),
(58376015, "Sofía", "Larrosa", "bbbbbbbb@mail.com", "2931sofia");

insert into asiento (sala_ID, cine_ID, funcion_ID, fila, numero, estado) values
(1, 1, 1, 1, 1, false),
(1, 1, 1, 1, 2, false),
(2, 1, 2, 1, 1, false),
(3, 2, 3, 1, 1, false),
(2, 1, 2, 2, 1, false);

insert into compra (cliente_CI, importe_total, fecha, hora, metodo_pago, estado) values
(44123456, 320, "2024-04-10", "10:00", "Tarjeta", true),
(44123456, 100, "2024-04-10", "9:00", "Tarjeta", false),
(37654321, 200, "2024-04-11", "8:00", "Efectivo", true),
(58376015, 344, "2024-04-12", "10:00", "Tarjeta", true),
(58376015, 454, "2024-04-10", "12:00", "Tarjeta", true);

insert into entrada (precio_pagado, asiento_ID, sala_ID, cine_ID, funcion_ID, compra_ID) values
(320, 1, 1, 1, 1, 1),
(320, 2, 1, 1, 1, 2),
(320, 3, 2, 1, 2, 3),
(400, 4, 3, 2, 3, 4),
(380, 5, 2, 1, 2, 5);

insert into telefono (cliente_CI, telefono) values 
(58376015, 712357311),
(58376015, 682214123),
(58376015, 798372044);