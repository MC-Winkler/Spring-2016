/* Length function */
SELECT 
       lastname,
       LENGTH(lastname)        
FROM   healthcare.patient
LIMIT 10
;