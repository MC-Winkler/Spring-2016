/* Substring function */
SELECT 
 phone,
 SUBSTRING(phone,1,3) AS "Area Code",
 SUBSTRING(phone,4,3) AS "Exchange",
 SUBSTRING(phone,7,4) AS "Number"
FROM   healthcare.facility
LIMIT 3 
;
