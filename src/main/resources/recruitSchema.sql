SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `Recruit` ;
CREATE SCHEMA IF NOT EXISTS `Recruit` DEFAULT CHARACTER SET utf8 ;
USE `Recruit` ;

-- -----------------------------------------------------
-- Table `Recruit`.`Role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Recruit`.`Role` ;

CREATE  TABLE IF NOT EXISTS `Recruit`.`Role` (
  `RoleID` INT(11) NOT NULL ,
  `Name` VARCHAR(45) NULL DEFAULT NULL ,
  `Description` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`RoleID`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


-- -----------------------------------------------------
-- Table `Recruit`.`User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Recruit`.`User` ;

CREATE  TABLE IF NOT EXISTS `Recruit`.`User` (
  `UserID` INT(11) NOT NULL AUTO_INCREMENT ,
  `Name` VARCHAR(50) NOT NULL ,
  `Password` VARCHAR(80) NOT NULL ,
  `LastLoginDate` DATETIME NULL DEFAULT NULL ,
  `RegisterDate` DATETIME NOT NULL ,
  `RoleID` INT(11) NOT NULL ,
  `MarkForDelete` TINYINT(1) NULL DEFAULT false ,
  PRIMARY KEY (`UserID`) ,
  INDEX `fk_User_Role1_idx` (`RoleID` ASC) ,
  CONSTRAINT `fk_User_Role1`
    FOREIGN KEY (`RoleID` )
    REFERENCES `Recruit`.`Role` (`RoleID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


-- -----------------------------------------------------
-- Table `Recruit`.`Department`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Recruit`.`Department` ;

CREATE  TABLE IF NOT EXISTS `Recruit`.`Department` (
  `DepartmentID` INT(11) NOT NULL AUTO_INCREMENT ,
  `Name` VARCHAR(50) NULL DEFAULT NULL ,
  `Type` VARCHAR(100) NULL DEFAULT NULL ,
  `Leader` VARCHAR(45) NULL DEFAULT NULL ,
  `OfficeAddress` VARCHAR(200) NULL DEFAULT NULL ,
  `OfficeTelephone` VARCHAR(45) NULL DEFAULT NULL ,
  `PostalCode` VARCHAR(45) NULL DEFAULT NULL ,
  `PostalAddress` VARCHAR(200) NULL DEFAULT NULL ,
  `Introduction` TEXT NULL DEFAULT NULL ,
  `UserID` INT(11) NOT NULL ,
  `MarkForDelete` TINYINT(1) NULL DEFAULT false ,
  PRIMARY KEY (`DepartmentID`) ,
  INDEX `fk_Department_User1_idx` (`UserID` ASC) ,
  CONSTRAINT `fk_Department_User1`
    FOREIGN KEY (`UserID` )
    REFERENCES `Recruit`.`User` (`UserID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


-- -----------------------------------------------------
-- Table `Recruit`.`Job`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Recruit`.`Job` ;

CREATE  TABLE IF NOT EXISTS `Recruit`.`Job` (
  `JobID` INT(11) NOT NULL AUTO_INCREMENT ,
  `Name` VARCHAR(100) NULL DEFAULT NULL ,
  `Introduce` TEXT NULL DEFAULT NULL ,
  PRIMARY KEY (`JobID`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


-- -----------------------------------------------------
-- Table `Recruit`.`JobRecruit`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Recruit`.`JobRecruit` ;

CREATE  TABLE IF NOT EXISTS `Recruit`.`JobRecruit` (
  `JobRecruitID` INT(11) NOT NULL AUTO_INCREMENT ,
  `StartTime` DATETIME NULL DEFAULT NULL ,
  `ExpireTime` DATETIME NULL DEFAULT NULL ,
  `Person` VARCHAR(45) NULL DEFAULT NULL ,
  `Type` VARCHAR(45) NULL DEFAULT NULL ,
  `DepartmentID` INT(11) NOT NULL ,
  `MarkForDelete` TINYINT(1) NULL DEFAULT false ,
  `JobID` INT(11) NOT NULL ,
  `Approve` TINYINT(1) NULL DEFAULT false ,
  `Timestamp` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
  `City` VARCHAR(45) NULL ,
  PRIMARY KEY (`JobRecruitID`) ,
  INDEX `fk_DepartmentRequirement_Department1_idx` (`DepartmentID` ASC) ,
  INDEX `fk_JobRequirement_Job1_idx` (`JobID` ASC) ,
  CONSTRAINT `fk_DepartmentRequirement_Department1`
    FOREIGN KEY (`DepartmentID` )
    REFERENCES `Recruit`.`Department` (`DepartmentID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_JobRequirement_Job1`
    FOREIGN KEY (`JobID` )
    REFERENCES `Recruit`.`Job` (`JobID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


-- -----------------------------------------------------
-- Table `Recruit`.`Education`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Recruit`.`Education` ;

CREATE  TABLE IF NOT EXISTS `Recruit`.`Education` (
  `EducationID` INT(11) NOT NULL AUTO_INCREMENT ,
  `Degree` VARCHAR(45) NULL ,
  `GraduationDate` VARCHAR(45) NULL ,
  `Major` VARCHAR(45) NULL ,
  `MajorRanking` VARCHAR(45) NULL ,
  `Academy` VARCHAR(45) NULL ,
  `UserID` INT(11) NOT NULL ,
  `MarkForDelete` INT(1) NULL DEFAULT false ,
  `Num` INT(11) NULL ,
  PRIMARY KEY (`EducationID`) ,
  INDEX `fk_Education_User1_idx` (`UserID` ASC) ,
  CONSTRAINT `fk_Education_User1`
    FOREIGN KEY (`UserID` )
    REFERENCES `Recruit`.`User` (`UserID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


-- -----------------------------------------------------
-- Table `Recruit`.`Experience`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Recruit`.`Experience` ;

CREATE  TABLE IF NOT EXISTS `Recruit`.`Experience` (
  `ExperienceID` INT(11) NOT NULL AUTO_INCREMENT ,
  `PracticeExperience` TEXT NULL DEFAULT NULL ,
  `WorkExperience` TEXT NULL DEFAULT NULL ,
  `Achievement` TEXT NULL DEFAULT NULL ,
  `Rewards` TEXT NULL DEFAULT NULL ,
  `Qualification` TEXT NULL DEFAULT NULL ,
  `AboutMe` TEXT NULL DEFAULT NULL ,
  `UserID` INT(11) NOT NULL ,
  `MarkForDelete` TINYINT(1) NULL DEFAULT false ,
  PRIMARY KEY (`ExperienceID`) ,
  INDEX `fk_Experience_User1_idx` (`UserID` ASC) ,
  CONSTRAINT `fk_Experience_User1`
    FOREIGN KEY (`UserID` )
    REFERENCES `Recruit`.`User` (`UserID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


-- -----------------------------------------------------
-- Table `Recruit`.`Status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Recruit`.`Status` ;

CREATE  TABLE IF NOT EXISTS `Recruit`.`Status` (
  `StatusID` INT(11) NOT NULL ,
  `Name` VARCHAR(50) NOT NULL ,
  `DefaultInfomation` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`StatusID`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


-- -----------------------------------------------------
-- Table `Recruit`.`JobRequest`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Recruit`.`JobRequest` ;

CREATE  TABLE IF NOT EXISTS `Recruit`.`JobRequest` (
  `JobRequestID` INT(11) NOT NULL AUTO_INCREMENT ,
  `Remark` TEXT NULL DEFAULT NULL ,
  `StatusChangeTime` DATETIME NULL DEFAULT NULL ,
  `AuditionTime` DATETIME NULL DEFAULT NULL ,
  `AuditionInfo` TEXT NULL DEFAULT NULL ,
  `AuditionRespond` TEXT NULL DEFAULT NULL ,
  `AuditionRespondTime` DATETIME NULL DEFAULT NULL ,
  `AuditionScore` INT(11) NULL DEFAULT NULL ,
  `AuditionRemark` TEXT NULL DEFAULT NULL ,
  `UserID` INT(11) NOT NULL ,
  `StatusID` INT(11) NOT NULL ,
  `MarkForDelete` TINYINT(1) NULL DEFAULT false ,
  `JobRecruitID` INT(11) NOT NULL ,
  `Timestamp` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
  `CreateTime` DATETIME NULL ,
  PRIMARY KEY (`JobRequestID`) ,
  INDEX `fk_JobDemand_User1_idx` (`UserID` ASC) ,
  INDEX `fk_JobDemand_Status1_idx` (`StatusID` ASC) ,
  INDEX `fk_JobRequest_JobRecruit1_idx` (`JobRecruitID` ASC) ,
  CONSTRAINT `fk_JobDemand_User1`
    FOREIGN KEY (`UserID` )
    REFERENCES `Recruit`.`User` (`UserID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_JobDemand_Status1`
    FOREIGN KEY (`StatusID` )
    REFERENCES `Recruit`.`Status` (`StatusID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_JobRequest_JobRecruit1`
    FOREIGN KEY (`JobRecruitID` )
    REFERENCES `Recruit`.`JobRecruit` (`JobRecruitID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Recruit`.`JobRequestHistory`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Recruit`.`JobRequestHistory` ;

CREATE  TABLE IF NOT EXISTS `Recruit`.`JobRequestHistory` (
  `JobRequestHistoryID` INT(11) NOT NULL AUTO_INCREMENT ,
  `Opinion` TEXT NULL DEFAULT NULL ,
  `OperationDate` DATETIME NULL DEFAULT NULL ,
  `OfficerID` INT(11) NULL DEFAULT NULL ,
  `JobRequestID` INT(11) NOT NULL ,
  `StatusID` INT(11) NOT NULL ,
  `OfficerName` VARCHAR(45) NULL ,
  `Timestamp` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
  PRIMARY KEY (`JobRequestHistoryID`) ,
  INDEX `fk_JobDemandHistory_JobDemand1_idx` (`JobRequestID` ASC) ,
  INDEX `fk_JobDemandHistory_Status1_idx` (`StatusID` ASC) ,
  CONSTRAINT `fk_JobDemandHistory_JobDemand1`
    FOREIGN KEY (`JobRequestID` )
    REFERENCES `Recruit`.`JobRequest` (`JobRequestID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_JobDemandHistory_Status1`
    FOREIGN KEY (`StatusID` )
    REFERENCES `Recruit`.`Status` (`StatusID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


-- -----------------------------------------------------
-- Table `Recruit`.`JobRequire`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Recruit`.`JobRequire` ;

CREATE  TABLE IF NOT EXISTS `Recruit`.`JobRequire` (
  `JobRequireID` INT(11) NOT NULL AUTO_INCREMENT ,
  `Description` TEXT NULL DEFAULT NULL ,
  `JobRecruitID` INT(11) NOT NULL ,
  `MarkForDelete` TINYINT(1) NULL DEFAULT false ,
  `Num` BIGINT(20) NULL ,
  PRIMARY KEY (`JobRequireID`) ,
  INDEX `fk_JobRequire_DepartmentRequirement1_idx` (`JobRecruitID` ASC) ,
  CONSTRAINT `fk_JobRequire_DepartmentRequirement1`
    FOREIGN KEY (`JobRecruitID` )
    REFERENCES `Recruit`.`JobRecruit` (`JobRecruitID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


-- -----------------------------------------------------
-- Table `Recruit`.`JobResponsibility`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Recruit`.`JobResponsibility` ;

CREATE  TABLE IF NOT EXISTS `Recruit`.`JobResponsibility` (
  `JobResponsibilityID` INT(11) NOT NULL AUTO_INCREMENT ,
  `Description` TEXT NULL DEFAULT NULL ,
  `JobRecruitID` INT(11) NOT NULL ,
  `MarkForDelete` TINYINT(1) NULL DEFAULT false ,
  `Num` BIGINT(20) NULL ,
  PRIMARY KEY (`JobResponsibilityID`) ,
  INDEX `fk_JobResponsibility_DepartmentRequirement1_idx` (`JobRecruitID` ASC) ,
  CONSTRAINT `fk_JobResponsibility_DepartmentRequirement1`
    FOREIGN KEY (`JobRecruitID` )
    REFERENCES `Recruit`.`JobRecruit` (`JobRecruitID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


-- -----------------------------------------------------
-- Table `Recruit`.`System`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Recruit`.`System` ;

CREATE  TABLE IF NOT EXISTS `Recruit`.`System` (
  `SystemID` INT(11) NOT NULL ,
  `Name` VARCHAR(50) NULL DEFAULT NULL ,
  `Type` VARCHAR(100) NULL DEFAULT NULL ,
  `LegalPerson` VARCHAR(45) NULL DEFAULT NULL ,
  `RegisterFund` VARCHAR(45) NULL DEFAULT NULL ,
  `RegisterTime` DATETIME NULL DEFAULT NULL ,
  `TotalPeople` VARCHAR(45) NULL DEFAULT NULL ,
  `Address` VARCHAR(100) NULL DEFAULT NULL ,
  `Telephone` VARCHAR(45) NULL DEFAULT NULL ,
  `Email` VARCHAR(45) NULL DEFAULT NULL ,
  `Web` VARCHAR(200) NULL DEFAULT NULL ,
  PRIMARY KEY (`SystemID`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


-- -----------------------------------------------------
-- Table `Recruit`.`UserInfo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Recruit`.`UserInfo` ;

CREATE  TABLE IF NOT EXISTS `Recruit`.`UserInfo` (
  `UserInfoID` INT(11) NOT NULL AUTO_INCREMENT ,
  `RealName` VARCHAR(45) NOT NULL ,
  `CardID` VARCHAR(45) NULL DEFAULT NULL ,
  `Gender` VARCHAR(45) NULL DEFAULT NULL ,
  `Nation` VARCHAR(45) NULL DEFAULT NULL ,
  `Politics` VARCHAR(45) NULL DEFAULT NULL ,
  `Hometown` VARCHAR(45) NULL DEFAULT NULL ,
  `PostalAddress` VARCHAR(200) NULL DEFAULT NULL ,
  `PostalCode` VARCHAR(45) NULL DEFAULT NULL ,
  `Photo` VARCHAR(45) NULL DEFAULT NULL ,
  `PhotoID` VARCHAR(45) NULL DEFAULT NULL ,
  `Marrige` INT(1) NULL DEFAULT NULL ,
  `Phone` VARCHAR(45) NULL DEFAULT NULL ,
  `ForeignLanguage` VARCHAR(45) NULL DEFAULT NULL ,
  `ComputerLevel` VARCHAR(45) NULL DEFAULT NULL ,
  `UserID` INT(11) NOT NULL ,
  PRIMARY KEY (`UserInfoID`) ,
  INDEX `fk_UserInfo_User1_idx` (`UserID` ASC) ,
  CONSTRAINT `fk_UserInfo_User1`
    FOREIGN KEY (`UserID` )
    REFERENCES `Recruit`.`User` (`UserID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

USE `Recruit` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
