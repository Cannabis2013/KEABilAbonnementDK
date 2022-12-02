CREATE VIEW ActiveRevenue
AS
SELECT SUM(Payment) AS Revenue  FROM bilabonnement.RentalAgreement ra;

CREATE VIEW ActiveSubscriptions
AS
SELECT COUNT(*) AS 'Active' FROM RentalAgreement ra
WHERE ra.StartDate <= NOW() AND ra.ExpirationDate >= NOW();

CREATE VIEW InActiveSubscriptions
AS
SELECT COUNT(*) as 'Inactive' FROM RentalAgreement ra
WHERE ra.StartDate >= NOW() AND ra.ExpirationDate >= NOW()
OR ra.StartDate <= NOW() AND ra.ExpirationDate <= NOW();