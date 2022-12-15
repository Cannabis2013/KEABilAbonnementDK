DROP DATABASE IF EXISTS bilabonnement;
CREATE DATABASE bilabonnement;
USE bilabonnement;
CREATE TABLE `Car` (
                       `Brand` varchar(255) DEFAULT NULL,
                       `Year` int DEFAULT NULL,
                       `Model` varchar(255) DEFAULT NULL,
                       `VIN` varchar(17) DEFAULT NULL,
                       `Number` varchar(5) NOT NULL,
                       PRIMARY KEY (`Number`)
);

CREATE TABLE `Customer` (
                            `License_Id` varchar(8) NOT NULL,
                            `Name` varchar(255) DEFAULT NULL,
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

CREATE VIEW ActiveRevenue AS
SELECT SUM(Payment) AS Revenue FROM bilabonnement.RentalAgreement ra;

CREATE VIEW AvailableCars AS
SELECT c.Brand, c.Year, c.Model, c.VIN, c.Number FROM Car c
LEFT JOIN (
	select * from rentalagreement ra1
	where ra1.StartDate < now() and ra1.ExpirationDate > now()
) ra on ra.CarNumber = c.Number
WHERE CarNumber IS NULL;

CREATE VIEW ActiveAgreements
AS
SELECT * FROM RentalAgreement
WHERE StartDate < now() AND ExpirationDate > now();

CREATE VIEW NumberOfavailableCars AS
SELECT COUNT(*) 'Available' FROM Car c
LEFT JOIN ActiveAgreements ra on ra.CarNumber = c.Number
WHERE CarNumber IS null;

CREATE VIEW NumberOfUnavailableCars AS
SELECT count(*) 'UnAvailable' FROM Car c
LEFT JOIN (
	select * from rentalagreement ra1
	where ra1.StartDate < now() and ra1.ExpirationDate > now()
) ra on ra.CarNumber = c.Number
WHERE CarNumber != "";

insert into Car (Brand, Model,Year,VIN,Number)
values
    ("Opel","Kadet",1992,"ABCJW12WFSD2442WW","TS440"),
    ("Nissan","Shitbox",1983,"GFDAW6HGF3842FFA1","TS316"),
    ("Fiat","Duna 70", 1989,"GPARKENFCK1992S12","TS116"),
    ("BMW","335i",2018,"JENSWRVILDMEDDANS","TS466"),
    ("Lada","500 CLASSIC",1987,"GLSPOSTNORD44ABC","TS112"),
    ("DC","Batmobil",2012,"GOTHAMNEEDSYOUNOW","TS102"),
    ("Ford","Mondeo",2019,"FORDCLASSICGM1912","TS318"),
    ("Nissan","Skyline GTR",2006,"2013PAULWALKERRIP","TS119");

insert into Customer (License_Id, Name, Address, PhoneNumber)
values
    ("12345678","Jens Kværner","Kværnergade 22, 2200 København DK","12121212"),
    ("98765432","Martin Hansen","Hyben Alle 56 1.MF, Kastrup, DK","31165870"),
    ("35123342","Elon Musk","Twitter Street 1, Los Angeles, US","24432123"),
    ("64321345","Jason Watt","Tømmerupvej 105, 2770 Kastrup, DK","32519881"),
    ("45382345","Muraat Kaan","Galatasary Alle 22, 3060 Espergærde, DK","32519881");

insert into RentalAgreement (StartDate, ExpirationDate, DeliveryDate, Payment, Id, CarNumber, CustomerLicense_Id)
values
    ("2022-11-29","2023-01-15","2022-11-29",2999,"ee7659e7-f3a1-4b96-a863-75e6694a0c1a","TS116","12345678"),
    ("2022-05-02","2023-02-05","2022-05-02",3899,"08a6940d-f536-4c2f-91f3-9cce6dbaa319","TS112","64321345"),
    ("2022-12-01","2023-04-06","2022-12-01",5999,"7324eaf4-dca6-4a33-b694-b0431ec3ddc9","TS102","35123342"),
    ("2022-10-15","2023-06-03","2022-12-01",2499,"11d98be7-2d07-4d31-8c04-86429bf8ef93","TS318","98765432");

insert into DamageReport (Id, Date, RentalAgreementId)
values ("acce7faa-a9f5-42e2-a33f-63410bcf2cee","2023-01-24","ee7659e7-f3a1-4b96-a863-75e6694a0c1a");

insert into Damage (Type, Description, Date, Cost, Id, DamageReportId)
values ("Bule","Bule registreret på kofanger samt heftig blodstænk","2023-01-24",3500,"1d258cbc-00be-494a-9035-272bfff1513c","acce7faa-a9f5-42e2-a33f-63410bcf2cee");
