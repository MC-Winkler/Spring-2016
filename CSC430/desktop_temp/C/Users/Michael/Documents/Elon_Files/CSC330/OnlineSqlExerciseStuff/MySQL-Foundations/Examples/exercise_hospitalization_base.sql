SELECT  
       patient_fk             , 
       admit_date             , 
       discharge_date         ,  
       facility_fk            , 
       ns                     , 
       bed                    
FROM   hospitalization
WHERE DATE(admit_date) >= '2003-01-01' AND 
      DATE(admit_date) < '2003-04-01'
;