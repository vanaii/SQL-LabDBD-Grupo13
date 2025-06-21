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
