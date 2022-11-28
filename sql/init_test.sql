DROP DATABASE IF EXISTS bilabonnementTEST;
CREATE DATABASE bilabonnementTEST;
USE bilabonnementTEST;
CREATE TABLE `Car` (
                       `Brand` varchar(255) DEFAULT NULL,
                       `Model` varchar(255) DEFAULT NULL,
                       `VIN` varchar(255) DEFAULT NULL,
                       `Number` varchar(36) NOT NULL,
                       PRIMARY KEY (`Number`)
);

CREATE TABLE `Customer` (
                            `License_Id` varchar(36) NOT NULL,
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
                                   `Id` varchar(36) NOT NULL,
                                   `CarNumber` varchar(36) NOT NULL,
                                   `CustomerLicense_Id` varchar(36) NOT NULL,
                                   PRIMARY KEY (`Id`)
);

CREATE TABLE `DamageReport` (
                                `Id` varchar(36) NOT NULL,
                                `Date` date DEFAULT NULL,
                                `RentalAgreementId` varchar(36) NOT NULL,
                                PRIMARY KEY (`Id`)
);

CREATE TABLE `Damage` (
                          `Type` varchar(255) DEFAULT NULL,
                          `Description` varchar(255) DEFAULT NULL,
                          `Date` date DEFAULT NULL,
                          `Cost` double DEFAULT NULL,
                          `Id` varchar(36) NOT NULL,
                          `DamageReportId` varchar(36) NOT NULL,
                          PRIMARY KEY (`Id`)
);
