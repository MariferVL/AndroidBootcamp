CREATE SCHEMA IF NOT EXISTS `sprint`;
USE `sprint`;

CREATE TABLE IF NOT EXISTS `sprint`.`usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `NombresUsuario` VARCHAR(30) NOT NULL,
  `ApellidosUsuario` VARCHAR(50) NOT NULL,
  `FechaNacimientoUsuario` DATE NOT NULL,
  `RunUsuario` INT  NOT NULL,
  PRIMARY KEY (`idUsuario`));


CREATE TABLE IF NOT EXISTS `sprint`.`cliente` (
  `idCliente` INT NOT NULL,
  `TelefonoCliente` VARCHAR(20) NOT NULL,
  `AFPCliente` VARCHAR(30) NULL,
  `SistemaSaludCliente` INT NULL,
  `DireccionCliente` VARCHAR(100) NOT NULL,
  `ComunaCliente` VARCHAR(50) NOT NULL,
  `EdadCliente` INT NOT NULL,
  `UsuarioFK` INT NOT NULL,
  PRIMARY KEY (`idCliente`),
  INDEX `Usuario_FK_idx` (`UsuarioFK` ASC) VISIBLE,
  CONSTRAINT `UsuarioFK`
    FOREIGN KEY (`UsuarioFK`)
    REFERENCES `sprint`.`usuario` (`idUsuario`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);


CREATE TABLE IF NOT EXISTS `sprint`.`accidente` (
  `idAccidente` INT NOT NULL,
  `FechaAccidente` DATE NOT NULL,
  `HoraAccidente` TIME NOT NULL,
  `LugarAccidente` VARCHAR(150) NOT NULL,
  `OrigenAccidente` VARCHAR(100) NOT NULL,
  `ConsecuenciaAccidente` VARCHAR(100) NULL,
  `IDCliente_FK` INT NOT NULL,
  PRIMARY KEY (`idAccidente`),
  INDEX `IDCliente_FK_idx` (`IDCliente_FK` ASC) VISIBLE,
  CONSTRAINT `IDCliente_FK`
    FOREIGN KEY (`IDCliente_FK`)
    REFERENCES `sprint`.`cliente` (`idCliente`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE IF NOT EXISTS `sprint`.`administrativos` (
  `IdAdmin` INT NOT NULL AUTO_INCREMENT,
  `EmailAdmin` VARCHAR(70) NULL,
  `AreaAdmin` VARCHAR(100) NULL,
  `ID_Usuario_FK` INT NOT NULL,
  PRIMARY KEY (`IdAdmin`),
  INDEX `ID_Usuario_FK_idx` (`ID_Usuario_FK` ASC) VISIBLE,
  CONSTRAINT `ID_Usuario_FK`
    FOREIGN KEY (`ID_Usuario_FK`)
    REFERENCES `sprint`.`usuario` (`idUsuario`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);



CREATE TABLE IF NOT EXISTS `sprint`.`capacitacion` (
  `idCapacitacion` INT NOT NULL,
  `FechaCapacitacion` DATE NOT NULL,
  `HoraCapacitacion` TIME NULL,
  `LugarCapacitacion` VARCHAR(100) NOT NULL,
  `DuracionCapacitacion` INT NULL,
  `FK_Cliente` INT NOT NULL,
  PRIMARY KEY (`idCapacitacion`),
  INDEX `FK_Cliente_idx` (`FK_Cliente` ASC) VISIBLE,
  CONSTRAINT `FK_Cliente`
    FOREIGN KEY (`FK_Cliente`)
    REFERENCES `sprint`.`cliente` (`idCliente`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
    
CREATE TABLE IF NOT EXISTS `sprint`.`asistentes` (
  `idAsistentes` INT NOT NULL,
  `NombreCompletoAsist` VARCHAR(100) NOT NULL,
  `EdadAsist` INT NOT NULL,
  `EmailAsist` VARCHAR(70) NULL,
  `TelefonoAsist` VARCHAR(20) NULL,
  `FK_Capacitacion` INT NOT NULL,
  PRIMARY KEY (`idAsistentes`),
  INDEX `FK_Capacitacion_idx` (`FK_Capacitacion` ASC) VISIBLE,
  CONSTRAINT `FK_Capacitacion`
    FOREIGN KEY (`FK_Capacitacion`)
    REFERENCES `sprint`.`capacitacion` (`idCapacitacion`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
    
CREATE TABLE IF NOT EXISTS `sprint`.`visita` (
  `idVisita` INT NOT NULL,
  `FechaVisita` DATE NOT NULL,
  `HoraVisita` TIME NULL,
  `LugarVisita` VARCHAR(50) NOT NULL,
  `ComentariosVisita` VARCHAR(250) NOT NULL,
  `Cliente_fk` INT NOT NULL,
  PRIMARY KEY (`idVisita`),
  INDEX `Cliente_fk_idx` (`Cliente_fk` ASC) VISIBLE,
  CONSTRAINT `Cliente_fk`
    FOREIGN KEY (`Cliente_fk`)
    REFERENCES `sprint`.`cliente` (`idCliente`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
CREATE TABLE IF NOT EXISTS `sprint`.`chequeo` (
  `idChequeo` INT NOT NULL,
  `NombreChequeo` VARCHAR(70) NULL,
  `CumplimientoChequeo` TINYINT(1) NULL,
  `ObservacionesChequeo` VARCHAR(250) NULL,
  `FK_visita` INT NOT NULL,
  PRIMARY KEY (`idChequeo`),
  INDEX `FK_visita_idx` (`FK_visita` ASC) VISIBLE,
  CONSTRAINT `FK_visita`
    FOREIGN KEY (`FK_visita`)
    REFERENCES `sprint`.`visita` (`idVisita`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
    
CREATE TABLE IF NOT EXISTS `sprint`.`profesionales` (
  `idProfesionales` INT NOT NULL,
  `TelefonoProfesionales` VARCHAR(20) NULL,
  `TituloProfesionales` VARCHAR(30) NULL,
  `ProyectoProfesionales` VARCHAR(30) NULL,
  `ID_UsuarioFK` INT NOT NULL,
  PRIMARY KEY (`idProfesionales`),
  INDEX `ID_Usuario_FK_idx` (`ID_UsuarioFK` ASC) VISIBLE,
  CONSTRAINT `ID_UsuarioFK`
    FOREIGN KEY (`ID_UsuarioFK`)
    REFERENCES `sprint`.`usuario` (`idUsuario`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
    CREATE TABLE `sprint`.`pagos` (
  `idPagos` INT NOT NULL AUTO_INCREMENT,
  `Fecha_Pago` DATE NOT NULL,
  `Monto_Pago` INT NOT NULL,
  `Mes_pago` VARCHAR(15) NULL,
  `Año_pago` INT NULL,
  `ClienteFK` INT NULL,
  PRIMARY KEY (`idPagos`),
  INDEX `ClienteFK_idx` (`ClienteFK` ASC) VISIBLE,
  CONSTRAINT `ClienteFK`
    FOREIGN KEY (`ClienteFK`)
    REFERENCES `sprint`.`cliente` (`idCliente`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);


CREATE TABLE `sprint`.`asesoria` (
  `idAsesoria` INT NOT NULL AUTO_INCREMENT,
  `FechaAsesoria` DATE NOT NULL,
  `MotivoAsesoria` VARCHAR(250) NULL,
  `Profesional_fk` INT NOT NULL,
  `Id_Cliente_FK` INT NOT NULL,
  PRIMARY KEY (`idAsesoria`),
  UNIQUE INDEX `idAsesoria_UNIQUE` (`idAsesoria` ASC) VISIBLE,
  INDEX `profesional_fk_idx` (`profesional_fk` ASC) VISIBLE,
  INDEX `id_cliente_FK_idx` (`id_cliente_FK` ASC) VISIBLE,
  CONSTRAINT `Profesional_fk`
    FOREIGN KEY (`Profesional_fk`)
    REFERENCES `sprint`.`profesionales` (`idProfesionales`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `Id_Cliente_FK`
    FOREIGN KEY (`Id_Cliente_FK`)
    REFERENCES `sprint`.`cliente` (`idCliente`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `sprint`.`actividades_mejoras` (
  `idActividadesMejoras` INT NOT NULL AUTO_INCREMENT,
  `TituloMejoras` VARCHAR(70) NOT NULL,
  `DescripcionMejora` VARCHAR(250) NULL,
  `PlazoMejoras` INT NOT NULL,
  `idAsesoria_fk` INT NOT NULL,
  PRIMARY KEY (`idActividadesMejoras`),
  UNIQUE INDEX `idActividadesMejoras_UNIQUE` (`idActividadesMejoras` ASC) VISIBLE,
  INDEX `idAsesoria_fk_idx` (`idAsesoria_fk` ASC) VISIBLE,
  CONSTRAINT `idAsesoria_fk`
    FOREIGN KEY (`idAsesoria_fk`)
    REFERENCES `sprint`.`asesoria` (`idAsesoria`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

    -- usuario table data
INSERT INTO `sprint`.`usuario` (`NombresUsuario`, `ApellidosUsuario`, `FechaNacimientoUsuario`, `RunUsuario`) VALUES 
('Juan', 'Perez', '1990-05-20', 12345678),
('Pedro', 'González', '1985-02-14', 87654321),
('María', 'López', '1995-11-30', 11111111);

-- cliente table data
INSERT INTO `sprint`.`cliente` (`idCliente`, `TelefonoCliente`, `AFPCliente`, `SistemaSaludCliente`, `DireccionCliente`, `ComunaCliente`, `EdadCliente`, `UsuarioFK`) VALUES 
(1, '+56 9 12345678', 'Provida', 2, 'Av. Providencia 123', 'Providencia', 30, 1),
(2, '+56 9 87654321', 'Modelo', 1, 'Av. Las Condes 456', 'Las Condes', 36, 2),
(3, '+56 9 11111111', 'Habitat', 1, 'Av. Nueva Providencia 789', 'Providencia', 26, 3);

-- accidente table data
INSERT INTO `sprint`.`accidente` (idAccidente,FechaAccidente,HoraAccidente,LugarAccidente,OrigenAccidente,ConsecuenciaAccidente,IDCliente_FK) VALUES 
(1, '2022-01-10', '10:00:00', 'Av. Providencia 123', 'Resbalón en piso mojado', 'Fractura de brazo', 1),
(2, '2022-02-20', '14:30:00', 'Av. Las Condes 456', 'Golpe en la cabeza', 'Conmoción cerebral', 2),
(3, '2022-03-30', '16:45:00', 'Av. Nueva Providencia 789', 'Tropiezo en escaleras', 'Lesión de rodilla', 3);

-- administrativos table data
INSERT INTO `sprint`.`administrativos` (EmailAdmin,AreaAdmin,ID_Usuario_FK) VALUES 
('juan.perez@gmail.com', 'Recursos Humanos', 1),
('pedro.gonzalez@gmail.com', 'Contabilidad', 2),
('maria.lopez@gmail.com', 'Ventas', 3);

-- capacitacion table data
INSERT INTO capacitacion (idCapacitacion,FechaCapacitacion,HoraCapacitacion,LugarCapacitacion,DuracionCapacitacion,FK_Cliente) VALUES 
(1, '2022-04-05', '09:00:00', 'Av. Providencia 123', 2, 1),
(2, '2022-04-10', '15:00:00', 'Av. Las Condes 456', 3, 2),
(3, '2022-04-15', '10:00:00', 'Av. Nueva Providencia 789', 4, 3);

-- asistentes table data
INSERT INTO asistentes (idAsistentes, NombreCompletoAsist,EdadAsist,EmailAsist,TelefonoAsist,FK_Capacitacion) 
VALUES (1111,'Juan Perez', 23, 'juan.perez@example.com', '5695551234', 2),
       (1112,'Maria Gonzalez', 45, 'maria.gonzalez@example.com', '5695555678', 1),
       (1113,'Pedro Gomez',34,  'pedro.gomez@example.com', '5695550012', 3);
       
-- visita table data       
INSERT INTO visita (idVisita,FechaVisita,HoraVisita,LugarVisita,ComentariosVisita,Cliente_fk) 
VALUES (1,'2022-01-01', '10:00:00', '12:00:00', 'Presentación de nuevos procedimientos', 1),
       (2,'2022-02-01', '14:00:00', '16:00:00', 'Reunión de seguimiento', 2),
       (3,'2022-03-01', '9:00:00', '11:00:00', 'Negociación de contrato', 3);

-- chequeo table data
INSERT INTO chequeo (idChequeo,NombreChequeo,CumplimientoChequeo,ObservacionesChequeo,FK_visita)
VALUES (11111,'Evaluación de riesgos laborales',1,"",  2),
(11112,'Chequeo de medidas preventivas en equipos',0,"", 1),
(11113,'Revisión del plan de emergencias',1, "",3);


-- profesionales table data

INSERT INTO profesionales (idProfesionales,TelefonoProfesionales,TituloProfesionales,ProyectoProfesionales,ID_UsuarioFK) 
VALUES (1,'978554362', 'Ergonomia', 'Trabajo Remoto en D.Web',2),
       (2,'964337654', 'Seguridad laboral', 'Jornadas noturnas en Mineras' ,1),
       (3,'976554363', 'Higiene industrial', 'Protección Trabajadores',3);
       

-- pagos table data

INSERT INTO pagos (Fecha_Pago,Monto_Pago,ClienteFK) 
VALUES ('2022-01-05', 150000, 1),
       ('2022-02-05',  200000, 2),
       ('2022-03-05',  100000, 3);

-- asesoria table data

INSERT INTO asesoria (FechaAsesoria,MotivoAsesoria,Profesional_fk,Id_Cliente_FK) 
VALUES ('2022-01-10', 'Asesoría sobre dieta y ejercicio', 1, 1),
       ('2022-02-10', 'Asesoría sobre tratamiento oncológico', 2, 2),
       ('2022-03-10', 'Asesoría sobre enfermedades laborales', 3, 3);
       
 -- actividades de mejora table data
 
INSERT INTO actividades_mejoras (TituloMejoras,DescripcionMejora,PlazoMejoras,idAsesoria_fk)
VALUES 
('Capacitación en uso de equipos de protección personal', 'Capacitación para el personal en el uso correcto de los equipos de protección personal.', 20,2),
('Mantenimiento y revisión de extintores', 'Mantenimiento y revisión periódica de los extintores.', 30,3),
('Implementación de medidas de seguridad eléctrica', 'Instalación de medidas de seguridad eléctrica.', 15, 1);


/*a) Realice una consulta que permita listar todas las capacitaciones de un cliente en particular, 
indicando el nombre completo, la edad y el correo electrónico de los asistentes.*/

select NombrecompletoAsist,EdadAsist,EmailAsist,FK_Capacitacion from asistentes where idAsistentes=1;

/*b) Realice una consulta que permita desplegar todas las visitas en terreno realizadas a los clientes 
que sean de la comuna de Valparaíso. Por cada visita debe indicar todos los chequeos que se hicieron en ella, 
junto con el estado de cumplimiento de cada uno.*/

select LugarVisita, chequeo.NombreChequeo,chequeo.CumplimientoChequeo,chequeo.ObservacionesChequeo
from visita 
INNER JOIN chequeo
ON  FK_visita = idVisita
where LugarVisita = "Valparaiso";

/*c) Realice una consulta que despliegue los accidentes registrados para todos los clientes,
indicando los datos de detalle del accidente, y el nombre, apellido, RUT y teléfono del cliente
al que se asocia dicha situación.*/	

select accidente.FechaAccidente,accidente.HoraAccidente,accidente.LugarAccidente,
		accidente.OrigenAccidente,accidente.ConsecuenciaAccidente,NombresUsuario,ApellidosUsuario,RunUsuario,TelefonoCliente
from accidente
JOIN cliente
  ON IDCliente_FK = cliente.idCliente
JOIN usuario
  ON UsuarioFK = idUsuario;

-- Data Dictionary
DESCRIBE  accidente;
DESCRIBE  actividades_mejoras;
DESCRIBE  administrativos;
DESCRIBE  asesoria;
DESCRIBE  asistentes;
DESCRIBE  capacitacion;
DESCRIBE  chequeo;
DESCRIBE  cliente;
DESCRIBE  pagos;
DESCRIBE  profesionales;
DESCRIBE  usuario;
DESCRIBE  visita;


