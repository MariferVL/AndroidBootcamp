CREATE SCHEMA modulo3;
USE modulo3;
CREATE TABLE `capacitacion` (
  `idCapacitacion` int NOT NULL AUTO_INCREMENT,
  `RUTCliente` varchar(15) NOT NULL,
  `FechaCapacitacion` varchar(15) NULL,
  `HoraCapacitacion` time NULL,
  `LugarCapacitacion` varchar(50) NOT NULL,
  `DuracionCapacitacion` int NOT NULL,
  `CantidadAsistentes` int NULL,
  PRIMARY KEY (`idCapacitacion`)
  );

ALTER TABLE `modulo3`.`capacitacion` AUTO_INCREMENT=110;

INSERT INTO `modulo3`.`capacitacion` (`RUTCliente`, `FechaCapacitacion`, `HoraCapacitacion`, `LugarCapacitacion`, `DuracionCapacitacion`, `CantidadAsistentes`) VALUES ('15676262-2', 'Lunes', '12:30:00', 'Sede Central', '120', '33');
INSERT INTO `modulo3`.`capacitacion` (`RUTCliente`, `FechaCapacitacion`, `HoraCapacitacion`, `LugarCapacitacion`, `DuracionCapacitacion`, `CantidadAsistentes`) VALUES ('16464525-2', 'Martes', '09:00', 'Sede Viña', '60', '11');
INSERT INTO `modulo3`.`capacitacion` (`RUTCliente`, `FechaCapacitacion`, `HoraCapacitacion`, `LugarCapacitacion`, `DuracionCapacitacion`, `CantidadAsistentes`) VALUES ('15836847-3', 'Jueves', '15:30:00', 'Sede Central', '120', '22');
INSERT INTO `modulo3`.`capacitacion` (`RUTCliente`, `FechaCapacitacion`, `HoraCapacitacion`, `LugarCapacitacion`, `DuracionCapacitacion`, `CantidadAsistentes`) VALUES ('9764727-9', 'Viernes', '12:30:00', 'Sede Viña', '60', '44');
INSERT INTO `modulo3`.`capacitacion` (`RUTCliente`, `FechaCapacitacion`, `HoraCapacitacion`, `LugarCapacitacion`, `DuracionCapacitacion`, `CantidadAsistentes`) VALUES ('7565686-9', 'Lunes', '09:00', 'Sede Central', '90', '55');
INSERT INTO `modulo3`.`capacitacion` (`RUTCliente`, `FechaCapacitacion`, `HoraCapacitacion`, `LugarCapacitacion`, `DuracionCapacitacion`, `CantidadAsistentes`) VALUES ('5763828-k', 'Viernes', '15:00:00', 'Sede Santiago', '120', '33');
INSERT INTO `modulo3`.`capacitacion` (`RUTCliente`, `FechaCapacitacion`, `HoraCapacitacion`, `LugarCapacitacion`, `DuracionCapacitacion`, `CantidadAsistentes`) VALUES ('18292282-1', 'Lunes', '15:30:00', 'Sede Central', '60', '12');
INSERT INTO `modulo3`.`capacitacion` (`RUTCliente`, `FechaCapacitacion`, `HoraCapacitacion`, `LugarCapacitacion`, `DuracionCapacitacion`, `CantidadAsistentes`) VALUES ('18293583-2', 'Lunes', '10:00:00', 'Sede Viña', '42', '122');
INSERT INTO `modulo3`.`capacitacion` (`RUTCliente`, `FechaCapacitacion`, `HoraCapacitacion`, `LugarCapacitacion`, `DuracionCapacitacion`, `CantidadAsistentes`) VALUES ('18292475-3', 'Viernes', '11:20:00', 'Sede Central', '64', '200');
INSERT INTO `modulo3`.`capacitacion` (`RUTCliente`, `FechaCapacitacion`, `HoraCapacitacion`, `LugarCapacitacion`, `DuracionCapacitacion`, `CantidadAsistentes`) VALUES ('18292304-4', 'Lunes', '11:20:00', 'Sede Viña', '120', '31');
INSERT INTO `modulo3`.`capacitacion` (`RUTCliente`, `FechaCapacitacion`, `HoraCapacitacion`, `LugarCapacitacion`, `DuracionCapacitacion`, `CantidadAsistentes`) VALUES ('21296734-5', 'Viernes', '10:00:00', 'Sede Central', '52', '23');

-- 1. Registros de tabla sin filtro alguno, mostrando las columnas identificador, hora, dia y rut de cliente (en ese orden).
SELECT idCapacitacion,HoraCapacitacion,FechaCapacitacion,RUTCliente FROM capacitacion;

-- 2. Obtenga todas las capacitaciones que duran una hora, y que tuvieron más de 30 asistentes. Debe desplegar todas las columnas sin un orden solicitado.
SELECT * FROM capacitacion WHERE DuracionCapacitacion = 60 AND CantidadAsistentes > 30;

-- 3. Obtenga capacitaciones realizadas por el cliente de RUT 1-9 o 2-7,
--  y que el lugar es “La Florida”.
-- Despliegue todas las columnas en el orden contrario a su definición original.
SELECT CantidadAsistentes,DuracionCapacitacion,LugarCapacitacion,HoraCapacitacion,FechaCapacitacion,RUTCliente,idCapacitacion FROM capacitacion WHERE RUTCliente LIKE "1-9" OR RUTCliente LIKE "2-7" AND LugarCapacitacion = 'La Florida';

-- 4. Obtenga todas las capacitaciones que han durado más de media hora, 
-- pero menos de una hora y media, o bien que sus asistentes es menos que 10 personas. 
-- Se pide mostrar el identificador de una tabla, y los campos indicados en la consulta.
SELECT idCapacitacion,DuracionCapacitacion,CantidadAsistentes FROM capacitacion WHERE DuracionCapacitacion > 30 AND DuracionCapacitacion < 90 OR CantidadAsistentes < 10;


-- 5. Obtenga capacitaciones de los lunes, miércoles y viernes, que tengan más de 50 asistentes
-- y que hayan durado menos de media hora. Debe desplegar los campos que estime.

SELECT * FROM capacitacion WHERE FechaCapacitacion ='Lunes' AND FechaCapacitacion ='Miercoles' AND FechaCapacitacion ='Viernes' AND CantidadAsistentes > 50 AND DuracionCapacitacion < 30;
