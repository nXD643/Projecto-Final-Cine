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
	select * from compras where cliente_CI = ci;
end //

create procedure entradas_compra (in idCompra int)
begin
	select * from entradas where compra_ID = idCompra;
end //

create procedure get_cines ()
begin
	select * from cines;
end //

create procedure get_salas (in idCine int)
begin
	select * from salas where cine_ID = idCine;
end //

create procedure get_funciones (in idSala int)
begin
	select * from funciones where sala_ID = idSala;
end //

create procedure get_asientos (in idFuncion int)
begin
	select * from salas where funcion_ID = idFuncion;
end //