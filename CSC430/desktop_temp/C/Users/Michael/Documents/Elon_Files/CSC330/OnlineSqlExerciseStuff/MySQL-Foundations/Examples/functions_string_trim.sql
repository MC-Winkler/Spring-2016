/* Trim Function */
SELECT
   '     foo       ' AS "Foo",
   TRIM('     foo ') AS "Foo with trim"
FROM   healthcare.hospitalization
LIMIT 1
;