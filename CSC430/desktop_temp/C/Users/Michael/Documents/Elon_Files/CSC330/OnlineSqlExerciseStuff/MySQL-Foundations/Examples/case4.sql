/* CASE - to conditionally display different columns in a single column */
SELECT  
       id      , 
       name    ,
       CASE
        WHEN type_cde = 'B' then id 
        ELSE name 
       END as "Department"        
FROM   healthcare.department
LIMIT 20
;