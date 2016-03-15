SELECT 
    patient_fk,
    admit_date,
    discharge_date
FROM
    healthcare.hospitalization
WHERE
    discharge_date = '2004-05-06 00:00:00'
;