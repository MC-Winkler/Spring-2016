-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema springtutorial
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema springtutorial
-- -----------------------------------------------------
drop SCHEMA springtutorial;

CREATE SCHEMA IF NOT EXISTS `springtutorial` DEFAULT CHARACTER SET utf8 ;
USE `springtutorial` ;

-- -----------------------------------------------------
-- Table `springtutorial`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `springtutorial`.`users` (
  `username` VARCHAR(60) NOT NULL,
  `password` VARCHAR(80) NULL DEFAULT NULL,
  `enabled` TINYINT(1) NULL DEFAULT '1',
  `email` VARCHAR(60) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `authority` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`username`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `springtutorial`.`offers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `springtutorial`.`offers` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `text` TEXT NOT NULL,
  `username` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_offers_users_idx` (`username` ASC),
  CONSTRAINT `fk_offers_users`
    FOREIGN KEY (`username`)
    REFERENCES `springtutorial`.`users` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 17
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `springtutorial`.`rentallocations`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `springtutorial`.`rentallocations` (
  `address1` VARCHAR(75) NULL DEFAULT NULL,
  `address2` VARCHAR(75) NULL DEFAULT NULL,
  `city` VARCHAR(30) NULL DEFAULT NULL,
  `name` VARCHAR(30) NULL DEFAULT NULL,
  `rentalLocationId` INT(11) NOT NULL AUTO_INCREMENT,
  `state` VARCHAR(25) NULL DEFAULT NULL,
  `postalcode` VARCHAR(10) NULL DEFAULT NULL,
  PRIMARY KEY (`rentalLocationId`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `springtutorial`.`messages`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `springtutorial`.`messages` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `subject` VARCHAR(100) NOT NULL,
  `content` VARCHAR(1000) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `email` VARCHAR(60) NOT NULL,
  `username` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_messages_users1_idx` (`username` ASC),
  CONSTRAINT `fk_messages_users1`
    FOREIGN KEY (`username`)
    REFERENCES `springtutorial`.`users` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '					';


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
