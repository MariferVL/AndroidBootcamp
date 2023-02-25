-- 1.obtener registros de cantidad de artículos mayor que 2, devolviendo todos sus campos.

-- Crear  Tabla:
CREATE TABLE `android`.`ventas` (
  `idVentas` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `comprador` VARCHAR(22) NULL,
  `vendedor` VARCHAR(22) NULL,
  `cantArticulos` INT NULL,
  `subtotal` INT NULL,
  `impuesto` INT NULL,
  `total` INT NULL,
  PRIMARY KEY (`idVentas`));
  
  ALTER TABLE ventas AUTO_INCREMENT=1001;
  
INSERT INTO `android`.`ventas` (`comprador`, `vendedor`, `cantArticulos`, `subtotal`, `impuesto`, `total`) VALUES ('Fito Paez', 'Su Hoo', '13', '432454', '8216', '440670');
INSERT INTO `android`.`ventas` (`comprador`, `vendedor`, `cantArticulos`, `subtotal`, `impuesto`, `total`) VALUES ('Marifer Stewar', 'Moisés Enlighted', '8', '23223', '4412', '27635');
INSERT INTO `android`.`ventas` (`comprador`, `vendedor`, `cantArticulos`, `subtotal`, `impuesto`, `total`) VALUES ('Consuelo Pickles', 'Bárbara Whats', '2', '1233', '234', '1267');
INSERT INTO `android`.`ventas` (`comprador`, `vendedor`, `cantArticulos`, `subtotal`, `impuesto`, `total`) VALUES ('David Beckham', 'Lautaro Campbell', '4', '987', '187', '1174');
INSERT INTO `android`.`ventas` (`comprador`, `vendedor`, `cantArticulos`, `subtotal`, `impuesto`, `total`) VALUES ('Sergio Thomson', 'José Alfonso del Campo', '11', '7652', '1453', '9105');

USE android;
-- 2. obtener registros cuyo subtotal sea menor que 1000, desplegando solo el ID de venta, el comprador y la cantidad de artículos.
SELECT subtotal, idVentas,comprador,cantArticulos FROM ventas WHERE subtotal < 1000;

-- 3.obtener registros de vendedor con nombre “SONIA GARRIDO”, y valor total de venta mayor o igual a 5000. Indicar todos los campos de la tabla en orden inverso al que se indica en la figura.
SELECT total,impuesto,subtotal,cantArticulos,vendedor,comprador,idVentas FROM ventas WHERE vendedor = 'Su Hoo' AND total >= 5000;

-- 4. retorne registros de comprador es “LUCAS” o de vendedor es “MARIA”. Despliegue solo los campos vendedor, comprador y total, en ese orden.
SELECT vendedor,comprador,total FROM ventas WHERE vendedor = 'Moisés Enlighted' OR comprador = 'Consuelo Pickles';

-- 5. despliegue registros con identificadores en el siguiente conjunto: 1,3 y 5.
SELECT * FROM ventas WHERE idVentas = 1 OR idVentas = 3 OR idVentas = 5;
