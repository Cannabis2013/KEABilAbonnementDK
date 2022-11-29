DROP DATABASE IF EXISTS bilabonnement;
CREATE DATABASE bilabonnement;
USE bilabonnement;
CREATE TABLE `Car` (
                       `Brand` varchar(255) DEFAULT NULL,
                       `Model` varchar(255) DEFAULT NULL,
                       `VIN` varchar(17) DEFAULT NULL,
                       `Number` varchar(5) NOT NULL,
                       PRIMARY KEY (`Number`)
);

CREATE TABLE `Customer` (
                            `License_Id` varchar(8) NOT NULL,
                            `Name` varchar(255) DEFAULT NULL,
                            `Birthday` date DEFAULT NULL,
                            `Address` varchar(255) DEFAULT NULL,
                            `PhoneNumber` varchar(255) DEFAULT NULL,
                            PRIMARY KEY (`License_Id`)
);

CREATE TABLE `RentalAgreement` (
                                   `StartDate` date DEFAULT NULL,
                                   `ExpirationDate` date DEFAULT NULL,
                                   `DeliveryDate` date DEFAULT NULL,
                                   `Payment` double DEFAULT NULL,
                                   `Id` varchar(36) NOT NULL,
                                   `CarNumber` varchar(36) NOT NULL,
                                   `CustomerLicense_Id` varchar(36) NOT NULL,
                                   PRIMARY KEY (`Id`),
                                   KEY `FKRentalAgre182509` (`CarNumber`),
                                   KEY `FKRentalAgre71306` (`CustomerLicense_Id`),
                                   CONSTRAINT `FKRentalAgre182509` FOREIGN KEY (`CarNumber`) REFERENCES `Car` (`Number`),
                                   CONSTRAINT `FKRentalAgre71306` FOREIGN KEY (`CustomerLicense_Id`) REFERENCES `Customer` (`License_Id`)
);

CREATE TABLE `DamageReport` (
                                `Id` varchar(36) NOT NULL,
                                `Date` date DEFAULT NULL,
                                `RentalAgreementId` varchar(36) NOT NULL,
                                PRIMARY KEY (`Id`),
                                KEY `FKDamageRepo506364` (`RentalAgreementId`),
                                CONSTRAINT `FKDamageRepo506364` FOREIGN KEY (`RentalAgreementId`) REFERENCES `RentalAgreement` (`Id`)
);

CREATE TABLE `Damage` (
                          `Type` varchar(255) DEFAULT NULL,
                          `Description` varchar(255) DEFAULT NULL,
                          `Date` date DEFAULT NULL,
                          `Cost` double DEFAULT NULL,
                          `Id` varchar(36) NOT NULL,
                          `DamageReportId` varchar(36) NOT NULL,
                          PRIMARY KEY (`Id`),
                          KEY `FKDamage191580` (`DamageReportId`),
                          CONSTRAINT `FKDamage191580` FOREIGN KEY (`DamageReportId`) REFERENCES `DamageReport` (`Id`)
);
