SELECT 
  patient.patient_pk,
  patient.facility_fk,
  facility.facility_pk
FROM healthcare.patient
JOIN healthcare.facility ON facility.facility_pk = patient.facility_fk
LIMIT 100
;