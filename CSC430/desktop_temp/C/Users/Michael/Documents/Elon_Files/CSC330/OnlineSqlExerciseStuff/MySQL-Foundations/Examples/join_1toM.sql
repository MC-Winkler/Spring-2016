SELECT 
  CONCAT(patient.lastname,", ",patient.firstname) AS "Patient",
  patient.patient_pk,
  patientaccount.patient_fk,
  patientaccount.total_charges
FROM healthcare.patient
JOIN healthcare.patientaccount ON patientaccount.patient_fk = patient.patient_pk
WHERE 
  patient.patient_pk = 117 AND
  patientaccount.total_charges > 0
;