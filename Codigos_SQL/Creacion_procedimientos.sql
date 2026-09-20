delimiter //

create procedure inicio_sesion(in ci int, passwd varchar(30))
begin
    select * from cliente where documento = ci and contrasena = passwd;
end //

delimiter //

create procedure registro_cliente(in ci int, nom varchar(30), ape varchar(30), correo varchar(50), passwd varchar(30))
begin
    insert into cliente (documento, nombre, apellido, correo_electronico, contrasena) values (ci, nom, ape, correo, passwd);
end //

delimiter ;

delimiter //

create procedure compras_cliente (in ci int)
begin 
	select * from compras where cliente_CI = ci;
end //

delimiter ;