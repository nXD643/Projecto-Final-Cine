delimiter //

create procedure inicio_sesion(in ci int, passwd varchar(30))
begin
    select * from cliente where documento = ci and contrasena = passwd;
end //

create procedure registro_cliente(in ci int, nom varchar(30), ape varchar(30), correo varchar(50), passwd varchar(30))
begin
    insert into cliente (documento, nombre, apellido, correo_electronico, contrasena) values (ci, nom, ape, correo, passwd);
end //

create procedure compras_cliente (in ci int)
begin 
	select * from compra where cliente_CI = ci;
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
	select * from funcione where sala_ID = idSala;
end //

create procedure get_asientos (in idFuncion int)
begin
	select * from sala where funcion_ID = idFuncion;
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