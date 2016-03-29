SELECT 
    patient_fk,
    admit_date,
    discharge_date
FROM
    healthcare.hospitalization
WHERE
    admit_date = '2003-11-06 00:00:00'
;