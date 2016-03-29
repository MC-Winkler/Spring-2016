SELECT 
   DATE(hospitalization.discharge_date) AS "disch_date",
   facility.name AS "Facility",
   patient.lastname AS "Patient",
   DATE(patient.dob) AS "DOB",
   attending.lastname AS "Attending",
   surgeon.lastname AS "Surgeon"
FROM healthcare.hospitalization
JOIN healthcare.facility ON facility.facility_pk = hospitalization.facility_fk
LEFT JOIN healthcare.patient ON patient.patient_pk = hospitalization.patient_fk
JOIN healthcare.provider attending ON attending.provider_pk = hospitalization.attending_fk
LEFT JOIN healthcare.provider surgeon ON surgeon.provider_pk = hospitalization.md1_fk
WHERE DATE(hospitalization.discharge_date) >= '2003-09-01' AND 
      DATE(hospitalization.discharge_date) <= '2003-12-31' AND
      hospitalization.discharge_date IS NOT NULL
;