CREATE TABLE `abpro6`.`Accidente` (
  `idAccidente` INT NOT NULL,
  `FechaAccidente` DATE NOT NULL,
  `HoraAccidente` DATE,
  `LugarAccidente` VARCHAR(150) NOT NULL, 
  `OrigenAccidente` VARCHAR(100) NOT NULL, 
  `ConsecuenciaAccidente` VARCHAR(100) NOT NULL,
  `IDCliente_FK` INT NOT NULL,
  PRIMARY KEY (`idAccidente`),
  INDEX `IDCliente_FK_idx` (`IDCliente_FK` ASC) VISIBLE,
  CONSTRAINT `IDCliente_FK`
  FOREIGN KEY (`IDCliente_FK`)
    REFERENCES `abpro6`.`cliente` (`IdCliente`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
    CREATE TABLE `abpro6`.`Chequeo` (
  `idChequeo` INT NOT NULL,
  `CumplimientoChequeo` Boolean, 
  `ObservacionesChequeo` VARCHAR(250), 
  `FK_visita` INT NOT NULL,
  PRIMARY KEY (`idChequeo`),
  INDEX `FK_visita_idx` (`FK_visita` ASC) VISIBLE,
  CONSTRAINT `FK_visita`
  FOREIGN KEY (`FK_visita`)
    REFERENCES `abpro6`.`visita` (`idVisita`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);