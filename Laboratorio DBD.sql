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
	id_permiso serial PRIMARY KEY,
	correo varchar(50) PRIMARY KEY,
	FOREIGN KEY (correo) REFERENCES usuario(correo),
	permiso_app varchar(50),
	permiso_tienda varchar(50)
);

create table if not exists carro_de_compras(
	id_carro serial PRIMARY KEY,
	monto_total int,
	cantidad int,
	correo varchar(50),
	FOREIGN KEY (correo) REFERENCES usuario(correo)
);

create table if not exists boleta(
	n_boleta serial PRIMARY KEY,
	metodo_pago varchar(50),
	fecha_c date,
	id_carro serial,
	FOREIGN KEY (id_carro) REFERENCES carro_de_compras(id_carro)
);

create table if not exists carta(
	id_carta serial PRIMARY KEY,
	id_producto serial PRIMARY KEY,
	FOREIGN KEY (id_producto) REFERENCES producto(id_producto),
	rareza varchar(50),
	año int,
	estado varchar(50),
	formato varchar(50),
	id_carro serial,
	FOREIGN KEY (id_carro) REFERENCES carro_de_compras(id_carro)
);

create table if not exists juego_de_mesa(
	id_juego serial PRIMARY KEY,
	id_producto serial PRIMARY KEY,
	FOREIGN KEY(id_producto) REFERENCES producto(id_producto),
	Tipo_juego varchar(50)
);