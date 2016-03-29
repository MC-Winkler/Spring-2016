SELECT 
patient_fk  ,         
       data_create_timestamp     , 
       service_create_timestamp  , 
       finding_timestamp   
FROM
    healthcare.findings
WHERE
    TIME(finding_timestamp) = '14:45:00'
;
