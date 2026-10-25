use complejo_cines;

select f.id as funcion, f.fecha, f.hora, f.sala_ID, p.titulo, count(e.id) 
from funcion f join pelicula p
on f.pelicula_ID =p.id 
join entrada e
on e.funcion_ID = f.id
group by p.id 
order by (p.id) desc;

select sum(e.precio_pagado), p.titulo
from funcion f join pelicula p
on f.pelicula_ID =p.id 
join entrada e
on e.funcion_ID = f.id
group by p.id 
order by (sum(e.precio_pagado)) desc;

select cli.nombre, count(e.id)
from cliente cli left join compra com
on cli.documento = com.cliente_CI
left join entrada e
on com.id = e.compra_ID
group by (cli.documento)
order by (count(e.id)) desc;


-- ¿Que cine tiene más asientos disponibles?
select c.nombre as Nombre, count(a.id) as Asientos_disponibles
from cine c join sala s
on c.id = s.cine_ID
join funcion f
on s.id = f.sala_ID
join asiento a
on f.id = a.funcion_ID
where a.estado = true
group by c.id
order by count(a.id) desc;