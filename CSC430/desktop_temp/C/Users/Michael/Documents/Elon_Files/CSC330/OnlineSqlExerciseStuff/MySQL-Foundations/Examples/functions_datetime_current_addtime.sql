/* ADDTIME function */
SELECT 
 TIME(now()), 
 ADDTIME(TIME(now()), '1:0:0') AS "Add Hours",
 ADDTIME(TIME(now()), '0:10:0') AS "Add Minutes",
 ADDTIME(TIME(now()), '0:0:30') AS "Add Seconds"
FROM   healthcare.patientaccount
LIMIT 1 
;