delimiter //

create procedure inicio_sesion(in ci int, passwd varchar(30))
begin
    select nombre, apellido, correo_electronico from cliente where documento = ci and contrasena = passwd;
end //

create procedure registro_cliente(in ci int, nom varchar(30), ape varchar(30), correo varchar(50), passwd varchar(30))
begin
    insert into cliente (documento, nombre, apellido, correo_electronico, contrasena) values (ci, nom, ape, correo, passwd);
end //

create procedure compras_cliente (in ci int)
begin 
	select fecha, hora, metodo_pago, motivo, estado, importe_total, id from compra where cliente_CI = ci;
end //

create procedure entradas_compra (in idCompra int)
begin
	select * from entrada where compra_ID = idCompra;
end //

create procedure get_cines ()
begin
	select * from cine;
end //

create procedure get_salas (in idCine int)
begin
	select * from sala where cine_ID = idCine;
end //

create procedure get_funciones (in idSala int)
begin
	select fecha, id, precio_base, pelicula_ID, hora from funcion where sala_ID = idSala;
end //

create procedure add_compra (in ci int, fecha date, hora varchar(30), metodo_pago varchar(20))
begin
	insert into compra (cliente_CI, fecha, hora, metodo_pago, estado) values (ci, fecha, hora, metodo_pago, true);
end //

create procedure add_entrada (in precio int, asiento int, sala int, cine int, funcion int, compra int)
begin
	insert into entrada (precio_pagado, asiento_ID, sala_ID, cine_ID, funcion_ID, compra_ID) values (precio, asiento, sala, cine, funcion, compra);
end //

create procedure cancelar_compra (in id_proporcionado int, texto text)
begin
	update compra set estado = false, motivo = texto where id = id_proporcionado;
end //

create procedure agregar_telefono (in ci int, nro_telefono varchar(15))
begin
	insert into telefono (cliente_CI, telefono) values (ci, nro_telefono);
end //

create procedure obtener_telefono (in ci int)
begin
	select telefono from telefono where cliente_CI = ci;
end //

create procedure obtener_pelicula (in id_pelicula int)
begin
	select duracion, clasificacion_por_edad, titulo, id, anio_estreno from pelicula where id = id_pelicula;
end //

create procedure obtener_generos (in id_pelicula int)
begin
	select genero from genero where pelicula_ID = id_pelicula;
end //

create procedure obtener_asientos (in id_funcion int)
begin
	select id, fila, numero, estado from asiento where funcion_ID = id_funcion;
end //

create procedure ocupar_asiento (in id_asiento int)
begin
	update asiento set estado = false where id = id_asiento;
end //

create procedure verificar_asiento (in id_asiento int)
begin
	select estado from asiento where id = id_asiento;
end //

create procedure eliminar_telefono (in nro_telefono varchar(15))
begin
	delete from telefono where telefono = nro_telefono;
end //

create procedure cancelar_compra (in id_compra int, explicacion text)
begin
	update compra set estado = false, motivo = explicacion where id = id_compra;
end //

create procedure nueva_compra (in ci int, total int, fecha_compra date, hora_compra varchar(10), metodo varchar(20))
begin
	insert into compra (cliente_CI, importe_total, fecha, hora, metodo_pago, estado) value (ci, total, fecha_compra, hora_compra, metodo, true);
end //

create procedure nueva_entrada (in precio int, id_asiento int, id_sala int, id_cine int, id_funcion int, id_compra int)
begin
	insert into entrada (precio_pagado, asiento_ID, sala_ID, cine_ID, funcion_ID, compra_ID) value (precio, id_asiento, id_sala, id_cine, id_funcion, id_compra);
end //