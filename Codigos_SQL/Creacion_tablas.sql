use complejo_cines;

create table cine(
	id int auto_increment,
    calle varchar(100) not null,
    ciudad varchar(30) not null,
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
    largo_asientos int not null,
    ancho_asientos int not null,
    capacidad_maxima int not null,
    primary key (id, cine_ID),
    unique (cine_ID, numero),
    constraint fk_sala_cine foreign key (cine_ID) references cine (id)
);

create table pelicula(
	id int auto_increment,
    titulo varchar(30) not null,
    anio_estreno date,
    duracion varchar(20),
    clasificacion_por_edad varchar(10) not null,
    primary key (id)
);

create table funcion(
	id int auto_increment,
    sala_ID int,
    cine_ID int,
    pelicula_ID int,
    fecha date not null,
    hora varchar(20) not null,
    precio_base int not null,
    primary key (id),
    unique (sala_ID, pelicula_ID, fecha, hora),
    constraint fk_funcion_sala foreign key (sala_ID, cine_ID) references sala (id, cine_ID),
	constraint fk_funcion_pelicula foreign key (pelicula_ID) references pelicula (id)
);

create table asiento(
	id int auto_increment,
    sala_ID int,
    cine_ID int,
    funcion_ID int,
    fila int not null,
    numero int not null,
    estado boolean not null,
    primary key (id, sala_ID, cine_ID, funcion_ID),
    unique (sala_ID, fila, numero, funcion_ID),
    constraint fk_asiento_sala foreign key (sala_ID, cine_ID) references sala (id, cine_ID)
);

create table cliente(
	documento int,
    nombre varchar(30) not null,
    apellido varchar(30) not null,
    correo_electronico varchar(50) not null,
    contrasena varchar(30) not null,
    primary key (documento)   
);

create table compra(
	id int auto_increment,
    cliente_CI int,
    importe_total int,
    fecha date not null,
    hora varchar(10) not null,
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
    unique(asiento_ID, sala_ID, cine_ID, funcion_ID),
    primary key (id),
	constraint fk_entrada_asiento foreign key (asiento_ID, sala_ID, cine_ID, funcion_ID) references asiento (id, sala_ID, cine_ID, funcion_ID),
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
    telefono varchar(15),
    primary key (telefono),
    constraint fk_telefono_cliente foreign key (cliente_CI) references cliente (documento)
);