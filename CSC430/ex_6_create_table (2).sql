-- MySQL Script generated by MySQL Workbench
-- 02/29/16 17:20:44
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema elonbuster
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema elonbuster
-- -----------------------------------------------------
USE `mvc` ;

-- -----------------------------------------------------
-- Table `elonbuster`.`RentalLocation`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rentallocations`;

CREATE TABLE IF NOT EXISTS `rentallocations` (
  `address1` VARCHAR(75) NULL,
  `address2` VARCHAR(75) NULL,
  `city` VARCHAR(30) NULL,
  `name` VARCHAR(30) NULL,
  `rentalLocationId` INT NOT NULL AUTO_INCREMENT,
  `state` VARCHAR(25) NULL,
  `postalcode` VARCHAR(10) NULL,
  PRIMARY KEY (`rentalLocationId`))
ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


insert into rentallocations (address1, city, name, state, postalcode) values
	('14 Old Chapel Rd','Middlebury','Middlebury Rental', 'VT', '05753');
insert into rentallocations (address1, city, name, state, postalcode) values
	('100 Campus Drive','Elon','Elon Rental', 'NC', '27244');
insert into rentallocations (address1, city, name, state, postalcode) values
	('11338 S. 108th E. Pl.','Bixby','Bixby Rental', 'OK', '74008');
insert into rentallocations (address1, city, name, state, postalcode) values
	('3605 S. Gary Ave.','Tulsa','Tulsa Rental', 'OK', '74105');
    