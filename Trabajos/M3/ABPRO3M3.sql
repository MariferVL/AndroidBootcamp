USE modulo3;


/*1. Haga las consultas necesarias para convertir las llaves primarias de cada tabla en campos
autonuméricos.*/
ALTER TABLE `modulo3`.`capacitacion` 
CHANGE COLUMN `idCapacitacion` `capacitacion` INT NOT NULL AUTO_INCREMENT;
ALTER TABLE `modulo3`.`asistentes` 
CHANGE COLUMN `idAsistentes` `idAsistentes` INT NOT NULL AUTO_INCREMENT;

/*2. Genere 3 consultas que permitan ingresar datos sobre la tabla Capacitación, sin asignar el
campo idcapacitacion en la consulta misma.*/
INSERT INTO `modulo3`.`capacitacion` (`RUTCliente`, `FechaCapacitacion`, `HoraCapacitacion`, `LugarCapacitacion`, `DuracionCapacitacion`, `CantidadAsistentes`) VALUES ('21535625-6', 'Martes', '15:00:00', 'Sede Viña', '60', '33');
INSERT INTO `modulo3`.`capacitacion` (`RUTCliente`, `FechaCapacitacion`, `HoraCapacitacion`, `LugarCapacitacion`, `DuracionCapacitacion`, `CantidadAsistentes`) VALUES ('9643287-3', 'Miercoles', '10:00:00', 'Sede Viña', '90', '88');
INSERT INTO `modulo3`.`capacitacion` (`RUTCliente`, `FechaCapacitacion`, `HoraCapacitacion`, `LugarCapacitacion`, `DuracionCapacitacion`, `CantidadAsistentes`) VALUES ('8565298-3', 'Jueves', '10:00:00', 'Sede Central', '120', '11');


/*3. Genere 5 consultas que permitan ingresar datos sobre la xtabla Asistentes, sin asignar
elcampo idasistente en la consulta misma.*/
INSERT INTO `modulo3`.`asistentes` (`nombre`, `edad`, `FK_Capacitacion`) VALUES ('Titi Laru', '39', '1');
INSERT INTO `modulo3`.`asistentes` (`nombre`, `edad`, `FK_Capacitacion`) VALUES ('Andres Niño', '42', '2');
INSERT INTO `modulo3`.`asistentes` (`nombre`, `edad`, `FK_Capacitacion`) VALUES ('Dolores Frias', '48', '3');
INSERT INTO `modulo3`.`asistentes` (`nombre`, `edad`, `FK_Capacitacion`) VALUES ('Pedro Perez', '31', '4');
INSERT INTO `modulo3`.`asistentes` (`nombre`, `edad`, `FK_Capacitacion`) VALUES ('Cain Serrano', '22', '5');

/*4. Realice una consulta que permita establecer una restricción de tipo única sobre el campo
nombres de la tabla Asistentes.*/
ALTER TABLE capacitacion
ADD UNIQUE INDEX NombresAsistentes_UNIQUE ( NombresAsistentes ASC) VISIBLE;

/*5. Realice una consulta que permita actualizar los campos dia a “01/01/2020” y hora a “00:00”
de la tabla capacitación para todos aquellos registros tales que el día y la hora son igual a
un valor nulo.*/
UPDATE capacitacion SET FechaCapacitacion = '01/01/2020', HoraCapacitacion = '00:00' 
WHERE FechaCapacitacion IS NULL AND HoraCapacitacion IS NULL;

/*6. Realice una consulta que permita eliminar todas aquellas capacitaciones que no tienen
asistentes. Esto es, aquellas capacitaciones con el campo cantidadasistentes igual a 0, y sin
registros relacionados en la tabla.*/
DELETE FROM capacitacion WHERE ( CantidadAsistentes = 0 ) 
AND idCapacitacion NOT IN (SELECT distinct idCapacitacion_fk FROM asistentes );

