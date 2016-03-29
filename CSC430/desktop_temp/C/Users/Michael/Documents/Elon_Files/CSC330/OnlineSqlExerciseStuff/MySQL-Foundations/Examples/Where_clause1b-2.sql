SELECT 
   patient_fk  ,         
   data_create_timestamp     , 
   service_create_timestamp  , 
   finding_timestamp                        
FROM   healthcare.findings
LIMIT 10
;