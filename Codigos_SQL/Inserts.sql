use complejo_cines;

insert into cine (calle, ciudad, nombre) values
("Bvar. Artigas 1825", "Montevideo", "Tres Cruces"),
("Av. Luis Alberto de Herrera 1290", "Montevideo", "Montevideo"),
("José Ellauri 350", "Montevideo", "Punta Carretas"),
("Av. Italia 5775", "Montevideo", "Portones");

insert into empleado (cine_ID, cargo, nombre, apellido, fecha_ingreso) values
(1, "cajero", "Marcos", "Díaz", "2021-05-01"),
(1, "acomodador", "Natalia", "Cruz", "2022-08-15"),
(2, "cajero", "Óscar", "Peña", "2020-03-10");

insert into sala (cine_ID, numero, largo_asientos, ancho_asientos, capacidad_maxima) values
(1, 1, 13, 10, 70),
(1, 2, 10, 6, 36),
(1, 3, 9, 6, 36),
(2, 1, 10, 10, 100),
(2, 2, 15, 10, 150),
(3, 1, 10, 5, 50),
(3, 2, 7, 5, 30),
(4, 1, 10, 10, 100),
(4, 2, 10, 10, 100);

insert into pelicula (titulo, anio_estreno, duracion, clasificacion_por_edad) values
("Aventura Estelar", "2020-01-01", "120 minutos", "12"),
("Risas en la Ciudad", "2023-01-01", "113 minutos", "ATP"),
("Cataclismo Universal", "2021-10-01", "100 minutos", "16"),
("WW3", "2024-01-11", "203 minutos", "18"),
("Sombras del Pasado", "2022-01-10", "90 minutos", "18");

insert into genero (pelicula_ID, genero) values
(1, "Ciencia ficción"),
(2, "Comedia"),
(3, "Drama"),
(4, "Acción"),
(5, "Terror");

insert into funcion (sala_ID, cine_ID, pelicula_ID, fecha, hora, precio_base) values
(1, 1, 1, "2024-04-10", "18:00", 320),
(2, 1, 5, "2027-04-10", "21:00", 380),
(3, 1, 1, "2024-04-10", "21:00", 320),
(4, 2, 2, "2024-04-11", "19:30", 320),
(5, 2, 3, "2024-04-13", "19:00", 420),
(6, 3, 4, "2027-04-12", "17:00", 400),
(7, 3, 2, "2024-04-11", "19:30", 320),
(8, 4, 3, "2024-04-13", "19:00", 420),
(9, 4, 5, "2024-04-11", "13:00", 420),
(9, 4, 3, "2025-04-12", "22:00", 400);


insert into cliente (documento, nombre, apellido, correo_electronico, contrasena) values
(12345672, "Paula", "Nuñez", "xxxxx@mail.com", "1234"),
(48338819, "Pepe", "Pepi", "123456@mail.com", "adada"),
(51348948, "Ramiro", "Techera", "aaaaaaa@mail.com", "8942"),
(58376015, "Sofía", "Larrosa", "bbbbbbbb@mail.com", "1234");

insert into asiento (sala_ID, cine_ID, funcion_ID, fila, numero, estado) values
(1, 1, 1, 1, 1, false),
(1, 1, 1, 1, 2, false),
(1, 1, 1, 2, 2, true),
(2, 1, 2, 1, 1, true),
(2, 1, 2, 1, 2, false),
(2, 1, 2, 2, 2, false),
(3, 1, 3, 1, 1, true),
(3, 1, 3, 1, 3, true),
(3, 1, 3, 1, 2, false),
(4, 2, 4, 1, 1, true),
(4, 2, 4, 3, 3, false),
(4, 2, 4, 1, 2, true),
(5, 2, 5, 1, 4, true),
(5, 2, 5, 1, 3, false),
(5, 2, 5, 3, 2, true),
(6, 3, 6, 1, 1, false),
(6, 3, 6, 2, 1, true),
(6, 3, 6, 3, 1, false),
(7, 3, 7, 3, 1, true),
(7, 3, 7, 3, 2, true),
(7, 3, 7, 3, 3, true),
(8, 4, 8, 1, 1, true),
(8, 4, 8, 2, 1, true),
(8, 4, 8, 1, 2, true),
(9, 4, 9, 1, 1, true),
(9, 4, 10, 2, 1, true),
(9, 4, 9, 2, 2, true);

insert into compra (cliente_CI, importe_total, fecha, hora, metodo_pago, estado) values
(12345672, 640, "2024-04-10", "10:00", "Tarjeta", true),
(12345672, 720, "2024-01-10", "9:00", "Tarjeta", false),
(48338819, 320, "2024-04-11", "8:00", "Efectivo", true),
(51348948, 320, "2024-04-06", "19:00", "Tarjeta", true),
(51348948, 320, "2024-03-12", "18:00", "Efectivo", true),
(58376015, 400, "2024-04-12", "10:00", "Tarjeta", false),
(58376015, 380, "2026-04-10", "12:00", "Efectivo", true);

insert into entrada (precio_pagado, asiento_ID, sala_ID, cine_ID, funcion_ID, compra_ID) values
(320, 1, 1, 1, 1, 1),
(320, 2, 1, 1, 1, 1),
(320, 5, 2, 1, 2, 2),
(400, 6, 2, 1, 2, 2),
(320, 9, 3, 1, 3, 3),
(320, 11, 4, 2, 4, 4),
(320, 14, 5, 2, 5, 5),
(400, 16, 6, 3, 6, 6),
(380, 18, 6, 3, 6, 7);

insert into telefono (cliente_CI, telefono) values 
(12345672, 124314245),
(12345672, 837540735),
(48338819, 623687272),
(48338819, 986796874),
(51348948, 625319634),
(51348948, 089668754),
(58376015, 712357311),
(58376015, 682214123),
(58376015, 798372044);