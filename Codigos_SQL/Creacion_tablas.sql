use complejo_cines;

create table cine(
	id int auto_increment,
    calle varchar(30),
    ciudad varchar(30),
    nombre varchar(30),
    primary key (id)
);

create table empleado(
	id int auto_increment,
    cargo varchar(10),
    nombre varchar(30),
    apellido varchar(30),
    fecha_ingreso date,
    primary key (id)
);

create table sala(
	id int auto_increment,
    cine_ID int auto_increment,
    numero int,
    capacidad_maxima int,
    primary key (id, cine_ID),
    constraint fk_sala_cine foreign key (cine_ID) references cine (id)
);

create table funcion(
	id int auto_increment,
    sala_ID int auto_increment,
    cine_ID int auto_increment,
    fecha date,
    hora varchar(20),
    precio_base int,
    primary key (id, sala_ID, cine_ID),
    constraint fk_funcion_sala foreign key (sala_ID) references sala (id),
	constraint fk_funcion_cine foreign key (cine_ID) references cine (id)
);

create table pelicula(
	id int auto_increment,
    titulo varchar(30),
    ano_estreno date,
    duarcion varchar(20),
    clasificacion_por_edad int,
    primary key (id)
);

create table asiento(
	id int auto_increment,
    sala_ID int auto_increment,
    cine_ID int auto_increment,
    fila int,
    numero int,
    primary key (id, sala_ID, cine_ID),
    constraint fk_asiento_sala foreign key (sala_ID) references sala (id),
	constraint fk_asiento_cine foreign key (cine_ID) references cine (id)
);

create table cliente(
	documento int8,
    nombre varchar(30) not null,
    apellido varchar(30) not null,
    correo_electronico varchar(50) not null,
    contraseña varchar(30) not null,
    primary key (documento)   
);

create table entrada(
	id int auto_increment,
    precio_pagado int,
    fecha_emision date,
    asiento_ID int auto_increment,
    sala_ID int auto_increment,
    cine_ID int auto_increment,
    funcion_ID int auto_increment,
    primary key (id),
	constraint fk_entrada_sala foreign key (sala_ID) references sala (id),
	constraint fk_entrada_cine foreign key (cine_ID) references cine (id),
	constraint fk_entrada_asiento foreign key (asiento_ID) references asiento (id),
	constraint fk_entrada_funcion foreign key (funcion_ID) references funcion (id)
);

create table trabaja(
	empleado_ID int auto_increment,
    cine_ID int auto_increment,
    primary key (empleado_ID, cine_ID),
	constraint fk_trabaja_empleado foreign key (empleado_ID) references empleado (id),
	constraint fk_trabaja_cine foreign key (cine_ID) references cine (id)
);

create table proyecta(
	pelicula_ID int auto_increment,
    sala_ID int auto_increment,
    cine_ID int auto_increment,
    funcion_ID int auto_increment,
    primary key (pelicula_ID, sala_ID, cine_ID, funcion_ID),
	constraint fk_proyecta_sala foreign key (sala_ID) references sala (id),
	constraint fk_proyecta_cine foreign key (cine_ID) references cine (id),
	constraint fk_proyecta_pelicula foreign key (pelicula_ID) references pelicula (id),
	constraint fk_proyecta_funcion foreign key (funcion_ID) references funcion (id)
);

create table compra(
	id int auto_increment,
    cliente_CI int8,
    entrada_ID int auto_increment,
    fecha date,
    hora varchar(30),
    metodo_pago varchar(20),
    motivo text,
    estado boolean,
    primary key (id),
    constraint fk_compra_cliente foreign key (cliente_CI) references cliente (id),
	constraint fk_compra_entrada foreign key (entrada_ID) references entrada (id)
);

create table genero(
	pelicula_ID int auto_increment,
    genero varchar(20),
    primary key (pelicula_ID, genero),
    constraint fk_genero_pelicula foreign key (pelicula_ID) references pelicula (id)
);

create table telefono(
	cliente_CI int8,
    telefono int8,
    primary key (cliente_CI, telefono),
    constraint fk_telefono_cliente foreign key (cliente_CI) references cliente (id)
);

create table aloja(
	asiento_ID int auto_increment,
    sala_ID int auto_increment,
    cine_ID int auto_increment,
    funcion_ID int auto_increment,
    primary key (asiento_ID, sala_ID, cine_ID, funcion_ID),
	constraint fk_aloja_sala foreign key (sala_ID) references sala (id),
	constraint fk_aloja_cine foreign key (cine_ID) references cine (id),
	constraint fk_aloja_asiento foreign key (asiento_ID) references asiento (id),
	constraint fk_aloja_funcion foreign key (funcion_ID) references funcion (id)
);