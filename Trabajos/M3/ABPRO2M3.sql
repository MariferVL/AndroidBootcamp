CREATE SCHEMA `modulo3` ;

CREATE TABLE `modulo3`.`capacitacion` (
  `idcapacitacion` INT NOT NULL AUTO_INCREMENT,
  `rutCliente` VARCHAR(15) NOT NULL,
  `dia` VARCHAR(15) NULL,
  `hora` TIME NULL,
  `lugar` VARCHAR(50) NOT NULL,
  `duracion` INT NOT NULL,
  `cantidadAsistentes` INT NULL,
  PRIMARY KEY (`idcapacitacion`));
  
  CREATE TABLE `modulo3`.`asistentes` (
  `idAsistentes` INT NOT NULL,
  `nombre` VARCHAR(100) NULL DEFAULT NULL,
  `edad` INT NOT NULL,
  `FK_Capacitacion` INT NOT NULL,
  PRIMARY KEY (`idAsistentes`),
  CONSTRAINT `FK_Capacitacion`
    FOREIGN KEY (`FK_Capacitacion`)
    REFERENCES `abpro2`.`capacitacion` (`idCapacitacion`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
    INSERT INTO `modulo3`.`capacitacion` (`rutCliente`, `dia`, `hora`, `lugar`, `duracion`, `cantidadAsistentes`) VALUES ('12345234-1', 'jueves', '18:00', 'unab', '90', '8');
INSERT INTO `modulo3`.`capacitacion` (`rutCliente`, `dia`, `hora`, `lugar`, `duracion`, `cantidadAsistentes`) VALUES ('15123234-2', 'martes', '21:00', 'unab', '60', '10');
INSERT INTO `modulo3`.`capacitacion` (`rutCliente`, `dia`, `hora`, `lugar`, `duracion`, `cantidadAsistentes`) VALUES ('21432432-1', 'lunes', '17:00', 'unab', '40', '6');
INSERT INTO `modulo3`.`capacitacion` (`rutCliente`, `dia`, `hora`, `lugar`, `duracion`, `cantidadAsistentes`) VALUES ('19987876-2', 'viernes', '21:00', 'unab', '70', '9');
INSERT INTO `modulo3`.`capacitacion` (`rutCliente`, `dia`, `hora`, `lugar`, `duracion`, `cantidadAsistentes`) VALUES ('13999777-1', 'sabado', '20:00', 'unab', '90', '12');
INSERT INTO `modulo3`.`capacitacion` (`rutCliente`, `dia`, `hora`, `lugar`, `duracion`, `cantidadAsistentes`) VALUES ('14657888-3', 'miercoles', '14:00', 'unab', '120', '3');

INSERT INTO `modulo3`.`asistentes` (`idAsistentes`, `nombre`, `edad`, `FK_Capacitacion`) VALUES ('1', 'Maria Fernandez', '21', '5');
INSERT INTO `modulo3`.`asistentes` (`idAsistentes`, `nombre`, `edad`, `FK_Capacitacion`) VALUES ('2', 'Paola Mercado', '32', '1');
INSERT INTO `modulo3`.`asistentes` (`idAsistentes`, `nombre`, `edad`, `FK_Capacitacion`) VALUES ('3', 'Jose Mora', '43', '2');
INSERT INTO `modulo3`.`asistentes` (`idAsistentes`, `nombre`, `edad`, `FK_Capacitacion`) VALUES ('4', 'Altair bonnasera', '32', '4');
INSERT INTO `modulo3`.`asistentes` (`idAsistentes`, `nombre`, `edad`, `FK_Capacitacion`) VALUES ('5', 'Ricardo Saez', '26', '3');
INSERT INTO `modulo3`.`asistentes` (`idAsistentes`, `nombre`, `edad`, `FK_Capacitacion`) VALUES ('6', 'Titi Laru', '39', '1');
INSERT INTO `modulo3`.`asistentes` (`idAsistentes`, `nombre`, `edad`, `FK_Capacitacion`) VALUES ('7', 'Andres Niño', '42', '2');
INSERT INTO `modulo3`.`asistentes` (`idAsistentes`, `nombre`, `edad`, `FK_Capacitacion`) VALUES ('8', 'Dolores Frias', '48', '3');
INSERT INTO `modulo3`.`asistentes` (`idAsistentes`, `nombre`, `edad`, `FK_Capacitacion`) VALUES ('9', 'Pedro Perez', '31', '4');
INSERT INTO `modulo3`.`asistentes` (`idAsistentes`, `nombre`, `edad`, `FK_Capacitacion`) VALUES ('10', 'Cain Serrano', '22', '5');

select * from capacitacion where dia = 'lunes' and duracion < 90;

select asistentes.nombre, capacitacion.rutCliente, capacitacion.lugar, capacitacion.duracion
from asistentes INNER JOIN capacitacion ON asistentes.FK_Capacitacion = capacitacion.idcapacitacion;

select rutCliente, dia, hora from capacitacion where cantidadAsistentes <> (SELECT COUNT(*) FROM asistentes);

select lugar, duracion, dia , hora from capacitacion where cantidadAsistentes > 3;




