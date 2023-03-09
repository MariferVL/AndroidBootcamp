CREATE SCHEMA IF NOT EXISTS `Sprint_modulo03`;
USE `Sprint_modulo03`;

CREATE TABLE IF NOT EXISTS `Sprint_modulo03`.`usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `NombresUsuario` VARCHAR(30) NOT NULL,
  `ApellidosUsuario` VARCHAR(50) NOT NULL,
  `FechaNacimientoUsuario` DATE NOT NULL,
  `RunUsuario` INT  NOT NULL,
  PRIMARY KEY (`idUsuario`));


CREATE TABLE IF NOT EXISTS `Sprint_modulo03`.`cliente` (
  `idCliente` INT NOT NULL,
  `TelefonoCli` VARCHAR(20) NOT NULL,
  `AFPCli` VARCHAR(30) NULL,
  `SistemaSaludCli` INT NULL,
  `DireccionCli` VARCHAR(100) NOT NULL,
  `ComunaCli` VARCHAR(50) NOT NULL,
  `EdadCli` INT NOT NULL,
  `UsuarioFK` INT NOT NULL,
  PRIMARY KEY (`idCliente`),
  INDEX `Usuario_FK_idx` (`UsuarioFK` ASC) VISIBLE,
  CONSTRAINT `UsuarioFK`
    FOREIGN KEY (`UsuarioFK`)
    REFERENCES `Sprint_modulo03`.`usuario` (`idUsuario`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);



CREATE TABLE IF NOT EXISTS `Sprint_modulo03`.`accidente` (
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
    REFERENCES `Sprint_modulo03`.`cliente` (`idCliente`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE IF NOT EXISTS `Sprint_modulo03`.`administrativos` (
  `IdAd` INT NOT NULL AUTO_INCREMENT,
  `EmailAd` VARCHAR(70) NULL,
  `AreaAd` VARCHAR(100) NULL,
  `ID_Usuario_FK` INT NOT NULL,
  PRIMARY KEY (`IdAd`),
  INDEX `ID_Usuario_FK_idx` (`ID_Usuario_FK` ASC) VISIBLE,
  CONSTRAINT `ID_Usuario_FK`
    FOREIGN KEY (`ID_Usuario_FK`)
    REFERENCES `Sprint_modulo03`.`usuario` (`idUsuario`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);



CREATE TABLE IF NOT EXISTS `Sprint_modulo03`.`capacitacion` (
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
    REFERENCES `Sprint_modulo03`.`cliente` (`idCliente`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
    
CREATE TABLE IF NOT EXISTS `Sprint_modulo03`.`asistentes` (
  `idAsistentes` INT NOT NULL,
  `NombrecompletoAsistete` VARCHAR(100) NOT NULL,
  `EdadAsistente` INT NOT NULL,
  `EmailAsistente` VARCHAR(70) NULL,
  `telefonoAsistente` VARCHAR(20) NULL,
  `FK_Capacitacion` INT NOT NULL,
  PRIMARY KEY (`idAsistentes`),
  INDEX `FK_Capacitacion_idx` (`FK_Capacitacion` ASC) VISIBLE,
  CONSTRAINT `FK_Capacitacion`
    FOREIGN KEY (`FK_Capacitacion`)
    REFERENCES `Sprint_modulo03`.`capacitacion` (`idCapacitacion`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
    
CREATE TABLE IF NOT EXISTS `Sprint_modulo03`.`visita` (
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
    REFERENCES `Sprint_modulo03`.`cliente` (`idCliente`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
CREATE TABLE IF NOT EXISTS `Sprint_modulo03`.`chequeo` (
  `idChequeo` INT NOT NULL,
  `NombreChequeo` VARCHAR(70) NULL,
  `CumplimientoChequeo` TINYINT(1) NULL,
  `ObservacionesChequeo` VARCHAR(250) NULL,
  `FK_visita` INT NOT NULL,
  PRIMARY KEY (`idChequeo`),
  INDEX `FK_visita_idx` (`FK_visita` ASC) VISIBLE,
  CONSTRAINT `FK_visita`
    FOREIGN KEY (`FK_visita`)
    REFERENCES `Sprint_modulo03`.`visita` (`idVisita`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
    
CREATE TABLE IF NOT EXISTS `Sprint_modulo03`.`profesionales` (
  `idProfesionales` INT NOT NULL,
  `TelefonoProfesionales` VARCHAR(20) NULL,
  `TituloProfesionales` VARCHAR(30) NULL,
  `ProyectoProfesionales` VARCHAR(30) NULL,
  `ID_UsuarioFK` INT NOT NULL,
  PRIMARY KEY (`idProfesionales`),
  INDEX `ID_Usuario_FK_idx` (`ID_UsuarioFK` ASC) VISIBLE,
  CONSTRAINT `ID_UsuarioFK`
    FOREIGN KEY (`ID_UsuarioFK`)
    REFERENCES `Sprint_modulo03`.`usuario` (`idUsuario`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
    CREATE TABLE `sprint_modulo03`.`pagos` (
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
    REFERENCES `sprint_modulo03`.`cliente` (`idCliente`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);


CREATE TABLE `sprint_modulo03`.`asesoria` (
  `id_asesoria` INT NOT NULL AUTO_INCREMENT,
  `fecha_asesoria` DATE NOT NULL,
  `motivo_asesoria` VARCHAR(250) NULL,
  `profesional_fk` INT NOT NULL,
  `id_cliente_FK` INT NOT NULL,
  PRIMARY KEY (`id_asesoria`),
  UNIQUE INDEX `id_asesoria_UNIQUE` (`id_asesoria` ASC) VISIBLE,
  INDEX `profesional_fk_idx` (`profesional_fk` ASC) VISIBLE,
  INDEX `id_cliente_FK_idx` (`id_cliente_FK` ASC) VISIBLE,
  CONSTRAINT `profesional_fk`
    FOREIGN KEY (`profesional_fk`)
    REFERENCES `sprint_modulo03`.`profesionales` (`idProfesionales`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `id_cliente_FK`
    FOREIGN KEY (`id_cliente_FK`)
    REFERENCES `sprint_modulo03`.`cliente` (`idCliente`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `sprint_modulo03`.`actividades_mejoras` (
  `idactividades_mejoras` INT NOT NULL AUTO_INCREMENT,
  `titulo_mejoras` VARCHAR(70) NOT NULL,
  `descripcion_mejora` VARCHAR(250) NULL,
  `plazo_dias_mejoras` INT NOT NULL,
  `idasesoria_fk` INT NOT NULL,
  PRIMARY KEY (`idactividades_mejoras`),
  UNIQUE INDEX `idactividades_mejoras_UNIQUE` (`idactividades_mejoras` ASC) VISIBLE,
  INDEX `idasesoria_fk_idx` (`idasesoria_fk` ASC) VISIBLE,
  CONSTRAINT `idasesoria_fk`
    FOREIGN KEY (`idasesoria_fk`)
    REFERENCES `sprint_modulo03`.`asesoria` (`id_asesoria`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

