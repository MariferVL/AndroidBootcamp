CREATE TABLE `m3abp11`.`empresa` (
  `idEmpresa` INT NOT NULL AUTO_INCREMENT,
  `NombreEmpresa` VARCHAR(45) NOT NULL,
  `RUTEmpresa` INT NOT NULL,
  `DireccionEmpresa` VARCHAR(150) NOT NULL,
  `TeléfonoEmpresa` VARCHAR(20) NOT NULL,
  `CiudadEmpresa` VARCHAR(45) NOT NULL,
  `PaisEmpresa` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idEmpresa`));

CREATE TABLE `m3abp11`.`cliente` (
  `idCliente` INT NOT NULL AUTO_INCREMENT,
  `NombreCliente` VARCHAR(45) NOT NULL,
  `ApellidoCliente` VARCHAR(45) NOT NULL,
  `RUTCliente` INT NOT NULL,
  `Direccion` VARCHAR(45) NOT NULL,
  `Ciudad` VARCHAR(45) NOT NULL,
  `Telefono` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idCliente`));
  
  CREATE TABLE `m3abp11`.`producto` (
  `idProducto` INT NOT NULL AUTO_INCREMENT,
  `CodProducto` VARCHAR(45) NOT NULL,
  `Descripción` VARCHAR(45) NOT NULL,
  `Canitad` INT NOT NULL,
  `PrecioUnitario` INT NOT NULL,
  PRIMARY KEY (`idProducto`));
  
  CREATE TABLE `m3abp11`.`factura` (
  `NroFactura` INT NOT NULL AUTO_INCREMENT,
  `FechaFactura` DATETIME NOT NULL,
  `IDEmpresa_FK` INT NULL,
  `IDCliente_FK` INT NULL,
  `IDProducto_FK` INT NULL,
  PRIMARY KEY (`NroFactura`),
  INDEX `IDEmpresa_FK_idx` (`IDEmpresa_FK` ASC) VISIBLE,
  INDEX `IDCliente_FK_idx` (`IDCliente_FK` ASC) VISIBLE,
  INDEX `IDProducto_FK_idx` (`IDProducto_FK` ASC) VISIBLE,
  CONSTRAINT `IDEmpresa_FK`
    FOREIGN KEY (`IDEmpresa_FK`)
    REFERENCES `m3abp11`.`empresa` (`idEmpresa`)
    ON DELETE SET NULL
    ON UPDATE SET NULL,
  CONSTRAINT `IDCliente_FK`
    FOREIGN KEY (`IDCliente_FK`)
    REFERENCES `m3abp11`.`cliente` (`idCliente`)
    ON DELETE SET NULL
    ON UPDATE SET NULL,
  CONSTRAINT `IDProducto_FK`
    FOREIGN KEY (`IDProducto_FK`)
    REFERENCES `m3abp11`.`producto` (`idProducto`)
    ON DELETE SET NULL
    ON UPDATE SET NULL);

USE m3abp11;
ALTER TABLE cliente AUTO_INCREMENT=10000; 

ALTER TABLE factura AUTO_INCREMENT=4; 


