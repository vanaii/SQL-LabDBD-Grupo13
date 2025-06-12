create table if not exists tienda(
	id_tienda serial PRIMARY KEY,
	nombre_tienda varchar(50),
	ubicacion_tienda varchar(50),
	nombre_jefe varchar(50)
);

create table if not exists lista_deseos(
	id_lista serial PRIMARY KEY,
	fecha_carrito date,
	nombre_lista varchar(50)
);

create table if not exists usuario(
	correo varchar(50) PRIMARY KEY,
	rol varchar(50),
	nombre_usuario varchar(50),
	contraseña varchar(50),
	direccion_cliente varchar(50),
	id_tienda serial,
	FOREIGN KEY (id_tienda) REFERENCES tienda(id_tienda),
	id_lista serial,
	FOREIGN KEY (id_lista) REFERENCES lista_deseos(id_lista)
);

create table if not exists permiso(
	id_permiso serial,
	correo varchar(50) PRIMARY KEY,
	FOREIGN KEY (correo) REFERENCES usuario(correo),
	permiso_app varchar(50),
	permiso_tienda varchar(50)
);