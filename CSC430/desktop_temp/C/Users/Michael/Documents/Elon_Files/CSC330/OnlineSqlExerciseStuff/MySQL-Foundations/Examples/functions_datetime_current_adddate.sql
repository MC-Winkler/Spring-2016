/* ADDDATE function */
SELECT 
 DATE(now()), 
 ADDDATE(DATE(now()), INTERVAL 1 year),
 ADDDATE(DATE(now()), INTERVAL 1 month),
 ADDDATE(DATE(now()), INTERVAL 1 day)
FROM   healthcare.patientaccount
LIMIT 1 
;