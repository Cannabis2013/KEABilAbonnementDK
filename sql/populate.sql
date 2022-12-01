DELETE FROM Damage;

DELETE FROM DamageReport;

DELETE FROM RentalAgreement;

DELETE FROM Customer;

DELETE FROM Car;

insert into Car (Brand, Model,Year,VIN,Number)
values ("Opel","Kadet",1992,"ABCJW12WFSD2442WW","TS440"),
("Nissan","Shitbox",1983,"GFDAW6HGF3842FFA1","TS316"),
("Fiat","Duna 70", 1989,"GPARKENFCK1992S12","TS116");

insert into Customer (License_Id, Name, Address, PhoneNumber)
values
("12345678","Elon Musk","Twitter Street 4, Los Angeles, US","12121212")
insert into RentalAgreement (StartDate, ExpirationDate, DeliveryDate, Payment, Id, CarNumber, CustomerLicense_Id)
values ("2022-11-29","2023-01-15","2022-11-29",2999,"ee7659e7-f3a1-4b96-a863-75e6694a0c1a","TS116","12345678");

insert into DamageReport (Id, Date, RentalAgreementId)
values ("acce7faa-a9f5-42e2-a33f-63410bcf2cee","2023-01-24","ee7659e7-f3a1-4b96-a863-75e6694a0c1a");

insert into Damage (Type, Description, Date, Cost, Id, DamageReportId)
values ("Bule","Bule registreret på kofanger samt heftig blodstænk","2023-01-24",3500,"1d258cbc-00be-494a-9035-272bfff1513c","acce7faa-a9f5-42e2-a33f-63410bcf2cee");