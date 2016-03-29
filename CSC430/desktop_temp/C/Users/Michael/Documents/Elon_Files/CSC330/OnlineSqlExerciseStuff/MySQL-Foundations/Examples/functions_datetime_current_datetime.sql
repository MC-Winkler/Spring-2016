/* Current Datetime Slice and Dice */
SELECT 
 now(), 
 DATE(now()),
 MONTHNAME(now()), 
 DAYNAME(now()),
 YEAR(now()),
 MONTH(now()), 
 DAY(now()),
 TIME(now()),
 HOUR(now()),
 MINUTE(now()),
 SECOND(now())
FROM   healthcare.patientaccount
LIMIT 1 
;