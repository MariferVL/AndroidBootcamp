CREATE SCHEMA `abp4` ;
CREATE TABLE `abp4`.`clientes` (
  `idclientes` INT NOT NULL AUTO_INCREMENT,
  `nombres` VARCHAR(50) NOT NULL,
  `apellidos` VARCHAR(50) NOT NULL,
  `direccion` VARCHAR(70) NULL,
  `telefono` INT NULL,
  PRIMARY KEY (`idclientes`));
  
 CREATE TABLE `abp4`.`ventas` (
  `idventa` INT NOT NULL AUTO_INCREMENT,
  `vendedor` VARCHAR(50) NULL,
  `cantidad_articulos` INT NOT NULL,
  `subtotal` INT NOT NULL,
  `impuesto` INT NOT NULL,
  `total` INT NOT NULL,
  `clientes_idclientes` INT NOT NULL,
  PRIMARY KEY (`idventa`),
  INDEX `clientes_idclientes_idx` (`clientes_idclientes` ASC) VISIBLE,
  CONSTRAINT `clientes_idclientes`
    FOREIGN KEY (`clientes_idclientes`)
    REFERENCES `abp4`.`clientes` (`idclientes`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    

ALTER TABLE clientes AUTO_INCREMENT=111110; 
INSERT INTO `abp4`.`clientes` (`nombres`, `apellidos`, `direccion`, `telefono`) VALUES ('Javiera', 'Gonzalez', 'Santa Ines', '974336727');
INSERT INTO `abp4`.`clientes` (`nombres`, `apellidos`, `direccion`, `telefono`) VALUES ('Pedro', 'de la Rosa', 'Con Con', '963225537');
INSERT INTO `abp4`.`clientes` (`nombres`, `apellidos`) VALUES ('Lucía', 'Jara');

DELETE FROM `abp4`.`clientes` WHERE (`idclientes` = '3');



