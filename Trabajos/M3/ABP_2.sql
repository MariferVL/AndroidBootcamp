CREATE SCHEMA `abp2` ;
USE abp2;
CREATE TABLE clientes ( 
idcliente INT NOT NULL, 
nombres VARCHAR(50) NOT NULL, 
apellidos VARCHAR(50) NOT NULL, 
direccion VARCHAR(70) NOT NULL, 
telefono INT);
ALTER TABLE clientes ADD CONSTRAINT clientes_pk PRIMARY KEY ( idcliente
);
CREATE TABLE ventas (
idventa INT NOT NULL,
vendedor VARCHAR(50), 
cantarticulos INT NOT NULL, 
subtotal INT NOT NULL,
impuesto INT NOT NULL,
total INT NOT NULL,
clientes_idcliente INT NOT NULL
);
ALTER TABLE ventas ADD CONSTRAINT ventas_pk PRIMARY KEY ( idventa ); ALTER TABLE ventas
ADD CONSTRAINT ventas_clientes_fk FOREIGN KEY ( clientes_idcliente ) REFERENCES clientes ( idcliente );
INSERT INTO clientes VALUES (1,'Antonia','Aranda','Calle Los Aromos #123',991111111);
INSERT INTO clientes VALUES (2,'Bernarda','Barros','Pasaje Manuel Balmaceda #456',992222222);
INSERT INTO clientes VALUES (3,'Carlos','Costa','Avenida Simón Bolivar #789',993333333);
INSERT INTO ventas (idventa, vendedor, cantarticulos, subtotal, impuesto, total, clientes_idcliente) VALUES (1,'Andrés Aranda',3,4500,500,5000,1);
INSERT INTO ventas (idventa, cantarticulos, subtotal, impuesto, total, clientes_idcliente) VALUES (2,2,1200,100,1400,1);
INSERT INTO ventas (vendedor, idventa, subtotal, cantarticulos, impuesto, total, clientes_idcliente) VALUES ('Cristina Cortés',3,10480,5,20,10500,2);
INSERT INTO ventas (idventa, vendedor, cantarticulos, subtotal, impuesto, total, clientes_idcliente) VALUES (4,'Daniela Durán',1,5000,2500,7500,2);
INSERT INTO ventas (idventa, cantarticulos, clientes_idcliente, subtotal, impuesto, total) VALUES (5,3,3,3800,100,4000);

-- 1. obtener ventas cuya suma entre el subtotal y el impuesto difieren del total.
SELECT subtotal,impuesto,total FROM ventas WHERE subtotal + impuesto <> total;

-- 2. conocer suma del total de todas las ventas registradas
SELECT SUM(total) FROM ventas;

-- 3. conocer listado de ventas de cliente de nombre “Antonia Aranda”.
SELECT clientes.nombres, ventas.idventa FROM clientes

-- 4. despliegue identificador del cliente, junto con su nombre y apellidos juntos en un solo campo. Debe desplegar solo los clientes que no tienen una dirección registrada.
-- 5. saber, al mismo tiempo, monto de venta mínima y máxima registrada en tabla respectiva.

