/* CONCAT function */
SELECT 
       name ,
       SUBSTRING(name,1,1),
       CONCAT(SUBSTRING(name,1,1),LOWER(SUBSTRING(name,2))),
       CONCAT(SUBSTRING(SUBSTRING_INDEX(name," ",1),1,1),LOWER(SUBSTRING(SUBSTRING_INDEX(name," ",1),2))) AS "First Word",
       CONCAT(SUBSTRING(SUBSTRING_INDEX(name," ",-1),1,1),LOWER(SUBSTRING(SUBSTRING_INDEX(name," ",-1),2))) AS "Second Word",  
       CONCAT(CONCAT(SUBSTRING(SUBSTRING_INDEX(name," ",1),1,1),LOWER(SUBSTRING(SUBSTRING_INDEX(name," ",1),2)))," ",CONCAT(SUBSTRING(SUBSTRING_INDEX(name," ",-1),1,1),LOWER(SUBSTRING(SUBSTRING_INDEX(name," ",-1),2)))) AS "Complex Nested Functions"       
FROM   department
LIMIT 10
;
