CREATE TABLE `san_patras`.`paciente` (
  `idPaciente` INT NOT NULL AUTO_INCREMENT,
  `NombrePaciente` VARCHAR(45) NOT NULL,
  `ApellidoPaciente` VARCHAR(45) NOT NULL,
  `DireccionPaciente` VARCHAR(45) NOT NULL,
  `PoblacionPaciente` VARCHAR(45) NOT NULL,
  `ProvinciaPaciente` VARCHAR(45) NOT NULL,
  `CodigoPostalPaciente` VARCHAR(45) NULL,
  `TelefonoPaciente` VARCHAR(20) NOT NULL,
  `FechaNacPAciente` DATETIME NOT NULL,
  PRIMARY KEY (`idPaciente`),
  UNIQUE INDEX `idPaciente_UNIQUE` (`idPaciente` ASC) VISIBLE);
  
  CREATE TABLE `san_patras`.`medicos` (
  `idmedicos` INT NOT NULL AUTO_INCREMENT,
  `NombreMedico` VARCHAR(45) NOT NULL,
  `ApellidoMedico` VARCHAR(45) NOT NULL,
  `TelefonoMedico` VARCHAR(45) NOT NULL,
  `EspecialidadMedico` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idmedicos`));
  
  CREATE TABLE `san_patras`.`ingreso` (
  `idIngreso` INT NOT NULL AUTO_INCREMENT,
  `HabitacionPaciente` VARCHAR(11) NOT NULL,
  `CamaPaciente` VARCHAR(11) NOT NULL,
  `FechaIngreso` DATETIME NOT NULL,
  `IDMedico_FK` INT NULL,
  `IDPaciente_PK` INT NULL,
  PRIMARY KEY (`idIngreso`),
  INDEX `IDMedico_FK_idx` (`IDMedico_FK` ASC) VISIBLE,
  INDEX `IDPaciente_FK_idx` (`IDPaciente_PK` ASC) VISIBLE,
  CONSTRAINT `IDMedico_FK`
    FOREIGN KEY (`IDMedico_FK`)
    REFERENCES `san_patras`.`medicos` (`idmedicos`)
    ON DELETE SET NULL
    ON UPDATE SET NULL,
  CONSTRAINT `IDPaciente_FK`
    FOREIGN KEY (`IDPaciente_PK`)
    REFERENCES `san_patras`.`paciente` (`idPaciente`)
    ON DELETE SET NULL
    ON UPDATE SET NULL);
