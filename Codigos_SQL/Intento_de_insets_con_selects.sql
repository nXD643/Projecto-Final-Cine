insert into cine (calle, nombre) values
("Bvar. Artigas 1825", "Tres Cruces"),
("Av. Italia 5775", "Portones");

insert into empleado (cine_ID, cargo, nombre, apellido, fecha_ingreso) values
((select id from cine where nombre = "Tres Cruces"), "cajero", "Marcos", "Díaz", "2021-05-01"),
((select id from cine where nombre = "Tres Cruces"), "acomodador", "Natalia", "Cruz", "2022-08-15"),
((select id from cine where nombre = "Portones"), "cajero", "Óscar", "Peña", "2020-03-10");

insert into sala (cine_ID, numero, capacidad_maxima) values
((select id from cine where nombre = "Tres Cruces"), 1, 6),
((select id from cine where nombre = "Tres Cruces"), 2, 6),
((select id from cine where nombre = "Portones"), 1, 4);

insert into pelicula (titulo, clasificacion_por_edad) values
("Aventura Estelar", "12"),
("Risas en la Ciudad", "ATP"),
("Sombras del Pasado", "18");

insert into genero (pelicula_ID, genero) values
((select id from pelicula where titulo = "Aventura Estelar"), "Ciencia ficción"),
((select id from pelicula where titulo = "Risas en la Ciudad"), "Comedia"),
((select id from pelicula where titulo = "Sombras del Pasado"), "Terror");

insert into funcion (sala_ID, cine_ID, fecha, hora, precio_base) values
((select id from sala where numero = 1 and cine_ID = (select id from cine where nombre = "Tres Cruces")), 
(select id from cine where nombre = "Tres Cruces"), "2024-04-10", "18:00", 320),
((select id from sala where numero = 2 and cine_ID = (select id from cine where nombre = "Tres Cruces")), 
(select id from cine where nombre = "Tres Cruces"), "2024-04-11", "19:30", 320),
((select id from sala where numero = 1 and cine_ID = (select id from cine where nombre = "Portones")), 
(select id from cine where nombre = "Portones"), "2024-04-12", "22:00", 400),
((select id from sala where numero = 1 and cine_ID = (select id from cine where nombre = "Tres Cruces")), 
(select id from cine where nombre = "Tres Cruces"), "2024-04-10", "21:00", 380);

insert into proyecta (pelicula_ID, sala_ID, cine_ID, funcion_ID) values
((select id from pelicula where titulo = "Aventura Estelar"), (select id from sala where numero = 1 and cine_ID = (select id from cine where nombre = "Tres Cruces")), 
(select id from cine where nombre = "Tres Cruces"), (select id from funcion where cine_ID = ((select id from cine where nombre = "Tres Cruces")
and sala_ID = (select id from sala where numero = 1) and fecha = "2024-04-10" and hora = "18:00"))),

((select id from pelicula where titulo = "Risas en la Ciudad"), (select id from sala where numero = 2 and cine_ID = (select id from cine where nombre = "Tres Cruces")), 
(select id from cine where nombre = "Tres Cruces"), (select id from funcion where (cine_ID = (select id from cine where nombre = "Tres Cruces")
and sala_ID = (select id from sala where numero = 2) and fecha = "2024-04-11" and hora = "19:30"))),

((select id from pelicula where titulo = "Sombras del Pasado"), (select id from sala where numero = 1 and cine_ID = (select id from cine where nombre = "Portones")), 
(select id from cine where nombre = "Portones"), (select id from funcion where cine_ID = ((select id from cine where nombre = "Portones")
and sala_ID = (select id from sala where numero = 1) and fecha = "2024-04-11" and hora = "22:00"))),

((select id from pelicula where titulo = "Aventura Estelar"), (select id from sala where numero = 1 and cine_ID = (select id from cine where nombre = "Tres Cruces")), 
(select id from cine where nombre = "Tres Cruces"), (select id from funcion where cine_ID = ((select id from cine where nombre = "Tres Cruces")
and sala_ID = (select id from sala where numero = 1) and fecha = "2024-04-10" and hora = "21:00")));

insert into cliente (documento, nombre, apellido, correo_electronico, contrasena) values
(44123456, "Paula", "Nuñez", "xxxxx@mail.com", "1234"),
(37654321, "Ramiro", "Techera", "aaaaaaa@mail.com", "8942"),
(50112233, "Sofía", "Larrosa", "bbbbbbbb@mail.com", "2931sofia");

insert into asiento

insert into entrada (precio_pagado, fecha_emision, asiento_ID, sala_ID, cine_ID, funcion_ID, compra_ID)