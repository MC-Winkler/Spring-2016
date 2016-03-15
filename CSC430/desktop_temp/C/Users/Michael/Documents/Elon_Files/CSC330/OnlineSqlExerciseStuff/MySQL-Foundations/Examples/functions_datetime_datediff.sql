/* DATEDIFF function */
SELECT 
        acctnum            , 
        start_date         , 
        end_date           , 
        DATEDIFF(end_date,start_date) AS "Account Duration in Days"  
FROM   healthcare.patientaccount
LIMIT 100 
;