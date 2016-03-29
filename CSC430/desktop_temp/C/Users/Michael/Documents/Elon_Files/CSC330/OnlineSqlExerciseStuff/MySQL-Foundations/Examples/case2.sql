/* CASE - for column formatting */
SELECT 
  CASE phone
    WHEN '0000000000' THEN "No Phone Number on Record"
    ELSE CONCAT(SUBSTRING(phone,1,3),".",SUBSTRING(phone,4,3),".",SUBSTRING(phone,7,4))
  END AS "Phone",
  phone AS "Actual Phone Number Stored"
FROM   healthcare.facility
LIMIT 10
;