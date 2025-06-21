-- 1. Agregar un juego de mesa / carta al carrito de compras
INSERT INTO producto_x_carro_de_compras (id_producto, id_carro)
VALUES (13, 1); --range id_producto (1,30), range id_carro(1,15)
----Como hay varios carros de compras y productos puede variar el numero dependiendo del carro y producto que quiera agregar
---Carro 3,4 y 5 vacios

-- 2. Eliminar un juego de mesa / carta del carrito de compras
DELETE FROM producto_x_carro_de_compras
WHERE id_producto = 13 AND id_carro = 1; --range id_producto (1,30), range id_carro(1,15)
----Como hay varios carros de compras y productos puede variar el numero dependiendo del carro y producto que quiera eliminar

-- 3. Mostrar los juegos de mesa / cartas del carrito de compras
SELECT p.nombre_producto, p.categoria
FROM producto p
JOIN producto_x_carro_de_compras pc ON p.id_producto = pc.id_producto
WHERE pc.id_carro = 1; -- range (1,15)
----Como hay varios carros de compras puede variar el numero dependiendo del carro que quiera consultar
---Carro 3,4 y 5 vacios

-- 4. Mostrar el precio total a pagar por el carrito de compras
SELECT pc.id_carro, SUM(p.precio_producto) AS total_a_pagar
FROM producto_x_carro_de_compras pc
JOIN producto p ON p.id_producto = pc.id_producto
WHERE pc.id_carro = 2 --range (1,15)
GROUP BY pc.id_carro;
----Como hay varios carros de compras puede variar el numero dependiendo del carro que quiera consultar
---Carro 3,4 y 5 vacios

-- 5. Mostrar todos los juegos de mesa y cartas que se venden en una ubicación geográfica específica
SELECT * 
FROM producto p
JOIN usuario u ON p.id_producto = ANY (
    SELECT id_producto FROM producto_x_carro_de_compras pc
    JOIN carro_de_compras cdc ON pc.id_carro = cdc.id_carro
    WHERE cdc.correo = u.correo
)
JOIN tienda t ON u.id_tienda = t.id_tienda
WHERE t.ubicacion_tienda = 'Santiago';

-- 6. Mostrar ranking de los productos con más ventas
SELECT nombre_producto, categoria, venta_producto
FROM producto
ORDER BY venta_producto DESC
LIMIT 10;

-- 7. Mostrar lista de deseos de un usuario
SELECT ld.nombre_lista, p.nombre_producto, p.categoria
FROM lista_deseos ld
JOIN lista_deseos_x_producto ldp ON ld.id_lista = ldp.id_lista
JOIN producto p ON ldp.id_producto = p.id_producto
WHERE ld.id_lista = 1; --range(1,10)
----Como hay varias listas de deseos puede variar el numero dependiendo de la lista que quiera consultar
