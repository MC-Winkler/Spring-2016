/* CASE - to accomplish string manipulation */
SELECT 
       acctnum    , 
       patient_fk , 
       admit_date , 
       admit_time ,
       CASE
         WHEN LENGTH(admit_time) = 2 THEN CONCAT('00:',admit_time)
         WHEN LENGTH(admit_time) = 3 THEN CONCAT(SUBSTRING(admit_time,1,1),":",SUBSTRING(admit_time,2,2))
         WHEN LENGTH(admit_time) = 4 THEN CONCAT(SUBSTRING(admit_time,1,2),":",SUBSTRING(admit_time,3,2))
       END AS "Admit Time Formatted as Time"                      
FROM   healthcare.hospitalization
LIMIT 10 
;