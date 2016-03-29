/* CONCAT function */
SELECT 
  lastname        , 
  firstname       ,  
  CONCAT(firstname," ",lastname)      
FROM   healthcare.patient
LIMIT 10
;

SELECT  
       lastname  , 
       dob       , 
       id        ,
       CONCAT(lastname,"|",id,"|",CAST(DATE(dob) AS CHAR))       
FROM   healthcare.patient
LIMIT 10
;
