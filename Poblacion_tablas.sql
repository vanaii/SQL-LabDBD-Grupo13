-- Tabla Tienda
CREATE TABLE IF NOT EXISTS tienda (
    id_tienda SERIAL PRIMARY KEY,
    nombre_tienda VARCHAR(50),
    ubicacion_tienda VARCHAR(50),
    nombre_jefe VARCHAR(50)
);

-- Tabla Lista de Deseos
CREATE TABLE IF NOT EXISTS lista_deseos (
    id_lista SERIAL PRIMARY KEY,
    fecha_carrito DATE,
    nombre_lista VARCHAR(50)
);

-- Tabla Usuario
CREATE TABLE IF NOT EXISTS usuario (
    correo VARCHAR(50) PRIMARY KEY,
    rol VARCHAR(50),
    nombre_usuario VARCHAR(50),
    contraseña VARCHAR(50),
    direccion_cliente VARCHAR(100),
    id_tienda INT UNIQUE,
    id_lista INT UNIQUE,
    FOREIGN KEY (id_tienda) REFERENCES tienda(id_tienda),
    FOREIGN KEY (id_lista) REFERENCES lista_deseos(id_lista)
);

-- Tabla Permiso
CREATE TABLE IF NOT EXISTS permiso (
    id_permiso SERIAL UNIQUE,
    correo VARCHAR(50),
    permiso_app VARCHAR(50),
    permiso_tienda VARCHAR(50),
    PRIMARY KEY (id_permiso, correo),
    FOREIGN KEY (correo) REFERENCES usuario(correo)
);

-- Tabla Carro de Compras
CREATE TABLE IF NOT EXISTS carro_de_compras (
    id_carro SERIAL UNIQUE PRIMARY KEY,
    monto_total INT,
    cantidad INT,
    correo VARCHAR(50),
    FOREIGN KEY (correo) REFERENCES usuario(correo)
);

-- Tabla Boleta
CREATE TABLE IF NOT EXISTS boleta (
    n_boleta SERIAL PRIMARY KEY,
    metodo_pago VARCHAR(50),
    estado_pago VARCHAR(50),
    monto_pago INT,
    impuestos VARCHAR(50),
    num_transaccion VARCHAR(50),
    fecha_c DATE,
    id_carro INT UNIQUE,
    FOREIGN KEY (id_carro) REFERENCES carro_de_compras(id_carro)
);

-- Tabla Producto
CREATE TABLE IF NOT EXISTS producto (
    id_producto SERIAL UNIQUE PRIMARY KEY,
    url VARCHAR(100),
    stock INT,
    categoria VARCHAR(50),
    nombre_producto VARCHAR(50),
    venta_producto INT
);

-- Tabla Carta
CREATE TABLE IF NOT EXISTS carta (
    id_carta SERIAL UNIQUE PRIMARY KEY,
    id_producto INT UNIQUE,
    rareza VARCHAR(50),
    año INT,
    estado VARCHAR(50),
    formato VARCHAR(50),
    id_carro INT UNIQUE,
    FOREIGN KEY (id_producto) REFERENCES producto(id_producto),
    FOREIGN KEY (id_carro) REFERENCES carro_de_compras(id_carro)
);

-- Tabla Juego de Mesa
CREATE TABLE IF NOT EXISTS juego_de_mesa (
    id_juego SERIAL UNIQUE PRIMARY KEY,
    id_producto INT UNIQUE,
    tipo_juego VARCHAR(50),
    FOREIGN KEY (id_producto) REFERENCES producto(id_producto)
);

-- Tabla Ranking
CREATE TABLE IF NOT EXISTS ranking (
    id_rank SERIAL UNIQUE PRIMARY KEY,
    posicion_rank INT,
    posicion_mundial INT,
    id_producto INT UNIQUE,
    FOREIGN KEY (id_producto) REFERENCES producto(id_producto)
);

-- Tabla Valoración
CREATE TABLE IF NOT EXISTS valoracion (
    id_usuario VARCHAR(50) UNIQUE,
    id_producto INT UNIQUE,
    fecha_v DATE,
    comentario VARCHAR(300),
    puntuacion INT,
    PRIMARY KEY (id_usuario, id_producto),
    FOREIGN KEY (id_usuario) REFERENCES usuario(correo),
    FOREIGN KEY (id_producto) REFERENCES producto(id_producto)
);

-- Tabla Usuario x Producto
CREATE TABLE IF NOT EXISTS usuario_x_producto (
    correo VARCHAR(50),
    id_producto INT,
    PRIMARY KEY (correo, id_producto),
    FOREIGN KEY (correo) REFERENCES usuario(correo),
    FOREIGN KEY (id_producto) REFERENCES producto(id_producto)
);

-- Tabla Lista de Deseos x Producto
CREATE TABLE IF NOT EXISTS lista_deseos_x_producto (
    id_lista INT,
    id_producto INT,
    PRIMARY KEY (id_lista, id_producto),
    FOREIGN KEY (id_lista) REFERENCES lista_deseos(id_lista),
    FOREIGN KEY (id_producto) REFERENCES producto(id_producto)
);

-- Tabla Producto x Carro de Compras
CREATE TABLE IF NOT EXISTS producto_x_carro_de_compras (
    id_producto INT,
    id_carro INT,
    PRIMARY KEY (id_producto, id_carro),
    FOREIGN KEY (id_producto) REFERENCES producto(id_producto),
    FOREIGN KEY (id_carro) REFERENCES carro_de_compras(id_carro)
);

-- Tabla Lista de Deseos x Carro de Compras
CREATE TABLE IF NOT EXISTS lista_deseos_x_carro_de_compras (
    id_lista INT,
    id_carro INT,
    PRIMARY KEY (id_lista, id_carro),
    FOREIGN KEY (id_lista) REFERENCES lista_deseos(id_lista),
    FOREIGN KEY (id_carro) REFERENCES carro_de_compras(id_carro)
);

-- Tabla Lista de Deseos x Ranking Carta
CREATE TABLE IF NOT EXISTS lista_deseos_x_ranking_carta (
    id_lista INT,
    id_carta INT,
    PRIMARY KEY (id_lista, id_carta),
    FOREIGN KEY (id_lista) REFERENCES lista_deseos(id_lista),
    FOREIGN KEY (id_carta) REFERENCES carta(id_carta)
);

-- Tabla Ranking Carta
CREATE TABLE IF NOT EXISTS ranking_carta (
    id_rank_c SERIAL,
    id_lista INT,
    id_carta INT,
    posicion_rank INT,
    PRIMARY KEY (id_rank_c, id_lista, id_carta),
    FOREIGN KEY (id_lista) REFERENCES lista_deseos(id_lista),
    FOREIGN KEY (id_carta) REFERENCES carta(id_carta)
);