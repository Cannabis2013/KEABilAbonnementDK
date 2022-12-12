CREATE VIEW ActiveRevenue AS
SELECT SUM(Payment) AS Revenue FROM bilabonnement.RentalAgreement ra;

CREATE VIEW AvailableCars AS
SELECT c.Brand, c.Year, c.Model, c.VIN, c.Number FROM Car c
LEFT JOIN RentalAgreement ra on ra.CarNumber = c.Number
WHERE CarNumber IS NULL;

CREATE VIEW NumberOfavailableCars AS
SELECT COUNT(*) 'Available' FROM Car c
LEFT JOIN RentalAgreement ra on ra.CarNumber = c.Number
WHERE CarNumber IS NULL;

CREATE VIEW NumberOfUnavailableCars AS
SELECT COUNT(*) 'Unavailable' FROM Car c
LEFT JOIN RentalAgreement ra on ra.CarNumber = c.Number
WHERE CarNumber != "";