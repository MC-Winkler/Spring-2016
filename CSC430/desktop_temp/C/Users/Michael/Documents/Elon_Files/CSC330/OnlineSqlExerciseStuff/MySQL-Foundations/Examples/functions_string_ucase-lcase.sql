/* Lower and Upper Case Functions */
SELECT  
       lastname, 
       LOWER(lastname),
       UPPER(lastname) 
FROM   healthcare.provider
LIMIT 10
;