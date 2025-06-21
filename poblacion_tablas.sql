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