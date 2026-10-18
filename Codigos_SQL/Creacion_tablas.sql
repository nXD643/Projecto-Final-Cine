use complejo_cines;

create table cine(
	id int auto_increment,
    calle varchar(30) not null,
    nombre varchar(30) not null,
    primary key (id)
);

create table empleado(
	id int auto_increment,
    cine_ID int not null,
    cargo enum("acomodador", "cajero") not null,
    nombre varchar(30) not null,
    apellido varchar(30) not null,
    fecha_ingreso date not null,
    primary key (id),
    constraint fk_empleado_cine foreign key (cine_ID) references cine (id)
);

create table sala(
	id int auto_increment,
    cine_ID int,
    numero int not null,
    capacidad_maxima int not null,
    primary key (id, cine_ID),
    constraint fk_sala_cine foreign key (cine_ID) references cine (id)
);

create table funcion(
	id int auto_increment,
    sala_ID int,
    cine_ID int,
    fecha date not null,
    hora varchar(20) not null,
    precio_base int not null,
    primary key (id, sala_ID, cine_ID),
    constraint fk_funcion_sala foreign key (sala_ID) references sala (id),
	constraint fk_funcion_cine foreign key (cine_ID) references cine (id)
);

create table pelicula(
	id int auto_increment,
    titulo varchar(30) not null,
    anio_estreno date,
    duracion varchar(20),
    clasificacion_por_edad varchar(10) not null,
    primary key (id)
);

create table asiento(
	id int auto_increment,
    sala_ID int,
    cine_ID int,
    fila varchar(1) not null,
    numero int not null,
    primary key (id, sala_ID, cine_ID),
    constraint fk_asiento_sala foreign key (sala_ID) references sala (id),
	constraint fk_asiento_cine foreign key (cine_ID) references cine (id)
);

create table cliente(
	documento int,
    nombre varchar(30) not null,
    apellido varchar(30) not null,
    correo_electronico varchar(50) not null,
    contrasena varchar(30) not null,
    primary key (documento)   
);

create table proyecta(
	pelicula_ID int,
    sala_ID int,
    cine_ID int,
    funcion_ID int,
    primary key (pelicula_ID, sala_ID, cine_ID, funcion_ID),
	constraint fk_proyecta_sala foreign key (sala_ID) references sala (id),
	constraint fk_proyecta_cine foreign key (cine_ID) references cine (id),
	constraint fk_proyecta_pelicula foreign key (pelicula_ID) references pelicula (id),
	constraint fk_proyecta_funcion foreign key (funcion_ID) references funcion (id)
);

create table compra(
	id int auto_increment,
    cliente_CI int,
    fecha date not null,
    hora varchar(30) not null,
    metodo_pago varchar(20) not null,
    motivo text,
    estado boolean not null,
    primary key (id),
    constraint fk_compra_cliente foreign key (cliente_CI) references cliente (documento)
);

create table entrada(
	id int auto_increment,
    precio_pagado int not null,
    asiento_ID int,
    sala_ID int,
    cine_ID int,
    funcion_ID int,
    compra_ID int,
    primary key (id),
	constraint fk_entrada_sala foreign key (sala_ID) references sala (id),
	constraint fk_entrada_cine foreign key (cine_ID) references cine (id),
	constraint fk_entrada_asiento foreign key (asiento_ID) references asiento (id),
	constraint fk_entrada_funcion foreign key (funcion_ID) references funcion (id),
	constraint fk_entrada_compra foreign key (compra_ID) references compra (id)
);

create table genero(
	pelicula_ID int,
    genero varchar(20),
    primary key (pelicula_ID, genero),
    constraint fk_genero_pelicula foreign key (pelicula_ID) references pelicula (id)
);

create table telefono(
	cliente_CI int,
    telefono int,
    primary key (cliente_CI, telefono),
    constraint fk_telefono_cliente foreign key (cliente_CI) references cliente (documento)
);

create table aloja(
	asiento_ID int,
    sala_ID int,
    cine_ID int,
    funcion_ID int,
    primary key (asiento_ID, sala_ID, cine_ID, funcion_ID),
	constraint fk_aloja_sala foreign key (sala_ID) references sala (id),
	constraint fk_aloja_cine foreign key (cine_ID) references cine (id),
	constraint fk_aloja_asiento foreign key (asiento_ID) references asiento (id),
	constraint fk_aloja_funcion foreign key (funcion_ID) references funcion (id)
);