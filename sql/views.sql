CREATE VIEW ActiveRevenue AS
SELECT SUM(Payment) AS Revenue FROM bilabonnement.RentalAgreement ra;

CREATE VIEW AvailableCars AS
SELECT c.Brand, c.Year, c.Model, c.VIN, c.Number FROM Car c
LEFT JOIN RentalAgreement ra on ra.CarNumber = c.Number
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
SELECT COUNT(*) 'Unavailable' FROM Car c
LEFT JOIN RentalAgreement ra on ra.CarNumber = c.Number
WHERE CarNumber != "";