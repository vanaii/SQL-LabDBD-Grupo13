-- 1.PRODUCTOS
INSERT INTO producto (url, stock, categoria, nombre_producto, venta_producto, precio_producto) VALUES
('https://img.cards/pikachu-vmax', 5, 'Carta', 'Pikachu VMAX',17 , 12000),
('https://img.board/risk', 7, 'Juego de Mesa', 'Risk', 26, 22000),
('https://img.cards/mewtwo-shadow', 6, 'Carta', 'Mewtwo Sombra',34, 19000),
('https://img.board/magic-maze', 6, 'Juego de Mesa', 'Magic Maze',18, 18000),
('https://img.cards/black-lotus', 2, 'Carta', 'Black Lotus',40, 40000),
('https://img.board/zombicide', 5, 'Juego de Mesa', 'Zombicide',21, 21000),
('https://img.cards/sailor-moon', 8, 'Carta', 'Sailor Moon Rare',57, 8000),
('https://img.board/monopoly-mario', 8, 'Juego de Mesa', 'Monopoly Mario Kart',30, 28000),
('https://img.cards/darth-vader', 5, 'Carta', 'Darth Vader Especial',12, 12000),
('https://img.board/trivial-pursuit', 9, 'Juego de Mesa', 'Trivial Pursuit Geek',26, 26000),
('https://img.cards/charizard-gx', 3, 'Carta', 'Charizard GX',100, 45000),
('https://img.board/catan', 10, 'Juego de Mesa', 'Catan',70, 35000),
('https://img.cards/blastoise-v', 7, 'Carta', 'Blastoise V',69, 18000),
('https://img.board/pandemic', 8, 'Juego de Mesa', 'Pandemic',30, 30000),
('https://img.cards/blue-eyes', 2, 'Carta', 'Blue Eyes White Dragon',23 , 60000),
('https://img.board/ticket-to-ride', 12, 'Juego de Mesa', 'Ticket to Ride',28, 28000),
('https://img.cards/umbreon-vmax', 4, 'Carta', 'Umbreon VMAX',25, 25000),
('https://img.board/carcassonne', 15, 'Juego de Mesa', 'Carcassonne',22, 22000),
('https://img.cards/dark-magician', 5, 'Carta', 'Dark Magician',20, 20000),
('https://img.board/7-wonders', 9, 'Juego de Mesa', '7 Wonders',32, 32000),
('https://img.cards/rayquaza-v', 6, 'Carta', 'Rayquaza V',5, 15000),
('https://img.board/azul', 11, 'Juego de Mesa', 'Azul',30,  27000),
('https://img.cards/lugia-legend', 1, 'Carta', 'Lugia Legend',14, 75000),
('https://img.board/splendor', 14, 'Juego de Mesa', 'Splendor',45,  26000),
('https://img.cards/mew-ex', 3, 'Carta', 'Mew EX', 2, 30000),
('https://img.board/wingspan', 7, 'Juego de Mesa', 'Wingspan',60, 40000),
('https://img.cards/celebi-star', 2, 'Carta', 'Celebi Star',55, 50000),
('https://img.board/terraforming-mars', 5, 'Juego de Mesa', 'Terraforming Mars',56, 45000),
('https://img.cards/gengar-vmax', 8, 'Carta', 'Gengar VMAX',23, 22000),
('https://img.board/gloomhaven', 3, 'Juego de Mesa', 'Gloomhaven',17, 120000);

-- 2.LISTAS DE DESEOS
INSERT INTO lista_deseos (fecha_carrito, nombre_lista) VALUES
('2025-01-01', 'Mi Colección Soñada'),
('2025-02-14', 'Amor a las Cartas'),
('2025-03-20', 'Top Juegos 2025'),
('2025-04-10', 'Viaje Geek'),
('2025-05-05', 'Lo Quiero Ya'),
('2025-06-01', 'Colección Pokémon 2025'),
('2025-06-05', 'Juegos para Fiesta'),
('2025-06-10', 'Cartas Raras MTG'),
('2025-06-15', 'Juegos Estratégicos'),
('2025-06-20', 'Regalos Cumpleaños');

-- 3.TIENDAS
INSERT INTO tienda (nombre_tienda, ubicacion_tienda, nombre_jefe) VALUES
('Juegos Galácticos', 'Nueva York', 'Elon Musk'),
('Cartas Legendarias', 'Tokio', 'Hayao Miyazaki'),
('La Mesa Mística', 'Berlín', 'Emma Watson'),
('Freaky Store', 'Santiago', 'Bad Bunny'),
('Geek Central', 'Los Ángeles', 'Robert Downey Jr.'),
('Heroes Hideout', 'Metropolis', 'Clark Kent'),
('Amazon Armory', 'Themyscira', 'Diana Prince'),
('Shield Supply', 'Washington DC', 'Steve Rogers'),
('Asgard Outpost', 'New Asgard', 'Thor Odinson'),
('Spy Games', 'Budapest', 'Natasha Romanoff');

-- 4.USUARIOS
INSERT INTO usuario (correo, rol, nombre_usuario, contraseña, direccion_cliente, id_tienda, id_lista) VALUES
('admin@invenpo.com', 'Administrador', 'Tony Stark', 'ironman123', 'Malibu, CA', 1, 1),
('jefe1@invenpo.com', 'Jefe', 'Bruce Wayne', 'batcave456', 'Gotham City', 2, 2),
('cliente1@invenpo.com', 'Cliente', 'Peter Parker', 'spidey789', 'Queens, NY', NULL, 3),
('cliente2@invenpo.com', 'Cliente', 'Leia Organa', 'alderaan007', 'Corellia', NULL, 4),
('jefe2@invenpo.com', 'Jefe', 'Gandalf', 'mellon999', 'Minas Tirith', 5, 5),
('cliente3@invenpo.com', 'Cliente', 'Clark Kent', 'superman123', 'Metropolis', NULL, 6),
('cliente4@invenpo.com', 'Cliente', 'Diana Prince', 'wonder456', 'Themyscira', NULL, 7),
('jefe3@invenpo.com', 'Jefe', 'Steve Rogers', 'captain789', 'Brooklyn, NY', 8, 8),
('cliente5@invenpo.com', 'Cliente', 'Natasha Romanoff', 'blackwidow', 'St. Petersburg', NULL, 9),
('jefe4@invenpo.com', 'Jefe', 'Thor Odinson', 'mjolnir', 'Asgard', 9, 10);

-- 5.PERMISOS
INSERT INTO permiso (correo, permiso_app, permiso_tienda) VALUES
('admin@invenpo.com', 'CRUD_TOTAL', 'ADMIN_TODO'),
('jefe1@invenpo.com', 'CRUD_PRODUCTO', 'GESTION_LOCAL'),
('jefe2@invenpo.com', 'CRUD_PRODUCTO', 'GESTION_LOCAL'),
('cliente1@invenpo.com', 'LECTURA', 'LECTURA'),
('cliente2@invenpo.com', 'LECTURA', 'LECTURA'),
('jefe3@invenpo.com', 'CRUD_PRODUCTO', 'GESTION_LOCAL'),
('jefe4@invenpo.com', 'CRUD_PRODUCTO', 'GESTION_LOCAL'),
('cliente3@invenpo.com', 'LECTURA', 'LECTURA'),
('cliente4@invenpo.com', 'LECTURA', 'LECTURA'),
('cliente5@invenpo.com', 'LECTURA', 'LECTURA');

-- 6.CARROS DE COMPRAS
INSERT INTO carro_de_compras (monto_total, cantidad, correo) VALUES
(24, 2, 'cliente1@invenpo.com'),
(35, 3, 'cliente2@invenpo.com'),
(15, 1, 'cliente1@invenpo.com'),
(60, 5, 'cliente2@invenpo.com'),
(10, 1, 'cliente1@invenpo.com'),
(90, 2, 'cliente3@invenpo.com'),
(65, 3, 'cliente4@invenpo.com'),
(120, 1, 'cliente5@invenpo.com'),
(45, 2, 'cliente3@invenpo.com'),
(80, 4, 'cliente4@invenpo.com'),
(150, 3, 'cliente5@invenpo.com'),
(30, 1, 'cliente3@invenpo.com'),
(55, 2, 'cliente4@invenpo.com'),
(200, 5, 'cliente5@invenpo.com'),
(25, 1, 'cliente3@invenpo.com');

-- 7.CARTAS
INSERT INTO carta (id_producto, rareza, año, estado, formato, id_carro) VALUES
(1, 'Ultra Rara', 1999, 'Nuevo', 'Holográfico', 1),
(3, 'Legendaria', 1996, 'Excelente', 'Foil', 2),
(5, 'Exclusiva', 2010, 'Perfecto', 'Full Art', 3),
(7, 'Promocional', 2018, 'Excelente', 'Stamped', 4),
(9, 'Oscura', 2012, 'Bueno', '3D', 5),
(11, 'Secret Rare', 2020, 'Nuevo', 'Rainbow', NULL),
(13, 'Ultra Rare', 2019, 'Excelente', 'Foil', NULL),
(15, 'Ghost Rare', 2002, 'Bueno', 'Holográfico', NULL),
(17, 'Hyper Rare', 2021, 'Nuevo', 'Rainbow', NULL),
(19, 'Super Rare', 2008, 'Excelente', 'Foil', NULL),
(21, 'Ultra Rare', 2022, 'Nuevo', 'Holográfico', NULL),
(23, 'Secret Rare', 2005, 'Perfecto', 'Full Art', NULL),
(25, 'Promo Rare', 2015, 'Bueno', 'Stamped', NULL),
(27, 'Star Rare', 2003, 'Excelente', 'Holográfico', NULL),
(29, 'Alt Art', 2023, 'Nuevo', 'Full Art', NULL);

-- 8.JUEGOS DE MESA
INSERT INTO juego_de_mesa (id_producto, tipo_juego) VALUES
(2, 'Tablero'),
(4, 'Guerra'),
(6, 'Rol'),
(8, 'Cooperativo'),
(10, 'Familia'),
(12, 'Estrategia'),
(14, 'Cooperativo'),
(16, 'Familiar'),
(18, 'Colocación'),
(20, 'Civilización'),
(22, 'Abstracto'),
(24, 'Económico'),
(26, 'Estrategia'),
(28, 'Ciencia Ficción'),
(30, 'Rol');

-- 9.BOLETAS
INSERT INTO boleta (metodo_pago, estado_pago, monto_pago, impuestos, num_transaccion, fecha_c, id_carro) VALUES
('Tarjeta', 'Aprobado', 24, 'IVA', '11111', '2025-01-03', 1),
('Transferencia', 'Rechazado', 35, 'IVA', '22222', '2025-01-04', 2),
('Efectivo', 'Aprobado', 15, 'IVA', '33333', '2025-01-06', 3),
('Tarjeta', 'Rechazado', 60, 'IVA', '44444', '2025-01-09', 4),
('Criptomoneda', 'Aprobado', 10, 'IVA', '55555', '2025-01-11', 5),
('Tarjeta', 'Aprobado', 90, 'IVA', '66666', '2025-06-02', 6),
('PayPal', 'Aprobado', 65, 'IVA', '77777', '2025-06-06', 7),
('Transferencia', 'Pendiente', 120, 'IVA', '88888', '2025-06-11', 8),
('Efectivo', 'Aprobado', 45, 'IVA', '99999', '2025-06-16', 9),
('Tarjeta', 'Rechazado', 80, 'IVA', '10101', '2025-06-21', 10),
('Criptomoneda', 'Aprobado', 150, 'IVA', '12121', '2025-06-22', 11),
('Tarjeta', 'Aprobado', 30, 'IVA', '13131', '2025-06-23', 12),
('PayPal', 'Pendiente', 55, 'IVA', '14141', '2025-06-24', 13),
('Transferencia', 'Aprobado', 200, 'IVA', '15151', '2025-06-25', 14),
('Efectivo', 'Aprobado', 25, 'IVA', '16161', '2025-06-26', 15);

-- 10.VALORACIONES
INSERT INTO valoracion (id_usuario, fecha_v, comentario, puntuacion, id_producto) VALUES
('cliente1@invenpo.com', '2025-01-05', 'Impresionante carta vintage.', 5, 1),
('cliente2@invenpo.com', '2025-01-07', 'Muy divertido para jugar en familia.', 4, 2),
('cliente3@invenpo.com', '2025-06-03', 'La carta Charizard GX es espectacular.', 5, 11),
('cliente4@invenpo.com', '2025-06-07', 'Catan es un clásico que nunca decepciona.', 5, 12),
('cliente5@invenpo.com', '2025-06-12', 'Blastoise V tiene un diseño increíble.', 4, 13),
('jefe1@invenpo.com', '2025-06-15', 'Excelente producto para nuestra tienda.', 5, 5),
('jefe2@invenpo.com', '2025-06-18', 'Muy buen juego para recomendar.', 4, 10),
('jefe3@invenpo.com', '2025-06-20', 'Calidad premium, clientes satisfechos.', 5, 15),
('jefe4@invenpo.com', '2025-06-22', 'Vende muy bien en nuestra tienda.', 4, 20),
('admin@invenpo.com', '2025-06-25', 'Producto estrella de nuestro catálogo.', 5, 25);

-- 11.RANKINGS
INSERT INTO ranking (posicion_rank, posicion_mundial, id_producto) VALUES
(1, 15, 5),
(2, 30, 2),
(3, 45, 11),
(4, 50, 12),
(5, 55, 13),
(6, 60, 14),
(7, 65, 15),
(8, 70, 16),
(9, 75, 17),
(10, 80, 18),
(11, 85, 19),
(12, 90, 20);

-- 12.USUARIO X PRODUCTO
INSERT INTO usuario_x_producto (correo, id_producto) VALUES
('cliente1@invenpo.com', 1),
('cliente2@invenpo.com', 2),
('cliente3@invenpo.com', 11),
('cliente4@invenpo.com', 12),
('cliente5@invenpo.com', 13),
('jefe1@invenpo.com', 5),
('jefe2@invenpo.com', 10),
('jefe3@invenpo.com', 15),
('jefe4@invenpo.com', 20),
('admin@invenpo.com', 25),
('cliente1@invenpo.com', 6),
('cliente2@invenpo.com', 7),
('cliente3@invenpo.com', 16),
('cliente4@invenpo.com', 17),
('cliente5@invenpo.com', 18),
('jefe1@invenpo.com', 8),
('jefe2@invenpo.com', 9),
('jefe3@invenpo.com', 19),
('jefe4@invenpo.com', 21),
('admin@invenpo.com', 22),
('cliente1@invenpo.com', 23),
('cliente2@invenpo.com', 24),
('cliente3@invenpo.com', 26),
('cliente4@invenpo.com', 27),
('cliente5@invenpo.com', 28),
('jefe1@invenpo.com', 29),
('jefe2@invenpo.com', 30),
('jefe3@invenpo.com', 3),
('jefe4@invenpo.com', 4),
('admin@invenpo.com', 14);

-- 13.LISTA DESEOS X PRODUCTO
INSERT INTO lista_deseos_x_producto (id_lista, id_producto) VALUES
-- Lista 1
(1, 1), (1, 6), (1, 2), (1, 26), (1, 27),
-- Lista 2
(2, 2), (2, 4), (2, 28), (2, 29), (2, 8),
-- Lista 3
(3, 7), (3, 30), (3, 11), (3, 16),
-- Lista 4
(4, 8), (4, 3), (4, 12), (4, 13), (4, 22),
-- Lista 5
(5, 8), (5, 9), (5, 10), (5, 14), (5, 15),
-- Lista 6
(6, 11), (6, 12), (6, 13), (6, 16), (6, 21),
-- Lista 7
(7, 14), (7, 15), (7, 16), (7, 17),
-- Lista 8
(8, 17), (8, 19), (8, 25),
-- Lista 9
(9, 20), (9, 21), (9, 22), (9, 19),
-- Lista 10
(10, 23), (10, 24), (10, 25), (10, 20);

-- 14.PRODUCTO X CARRO DE COMPRAS
INSERT INTO producto_x_carro_de_compras (id_producto, id_carro) VALUES
(1, 1),
(2, 2),
(11, 6),
(12, 7),
(13, 8),
(14, 9),
(15, 10),
(16, 11),
(17, 12),
(18, 13),
(19, 14),
(20, 15),
(21, 6),
(22, 7),
(23, 8),
(24, 9),
(25, 10),
(26, 11),
(27, 12),
(28, 13),
(29, 14),
(30, 15);

--15. LISTA DESEOS X CARRO DE COMPRAS
INSERT INTO lista_deseos_x_carro_de_compras (id_lista, id_carro) VALUES
(1, 1),
(2, 2),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10),
(1, 11),
(2, 12),
(3, 13),
(4, 14),
(5, 15),
(6, 1),
(7, 2),
(8, 3);

-- 16.LISTA DESEOS X RANKING CARTA
INSERT INTO lista_deseos_x_ranking_carta (id_lista, id_carta) VALUES
(1, 1),
(2, 2),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10),
(1, 11),
(2, 12),
(3, 13),
(4, 14),
(5, 15);

-- 17. RANKINGS CARTA
INSERT INTO ranking_carta (id_lista, id_carta, posicion_rank) VALUES
(1, 1, 1),
(2, 2, 2),
(6, 6, 3),
(7, 7, 4),
(8, 8, 5),
(9, 9, 6),
(10, 10, 7),
(1, 11, 8),
(2, 12, 9),
(3, 13, 10),
(4, 14, 11),
(5, 15, 12);