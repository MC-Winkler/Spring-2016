SELECT 
	acctnum,
    DATE(start_date) AS "start_date",
    DATE(end_date) AS "end_date",
    facility_chrgs
FROM
    healthcare.patientaccount
WHERE
    DATE(start_date) >= '2007-03-01' AND DATE(start_date) <= '2007-03-31'
AND (facility_chrgs > 0)
ORDER BY 
    start_date ASC
;