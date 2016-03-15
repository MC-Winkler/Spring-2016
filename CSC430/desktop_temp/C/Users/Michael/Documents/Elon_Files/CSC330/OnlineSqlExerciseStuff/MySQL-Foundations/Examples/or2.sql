SELECT 
    *
FROM
    healthcare.medicalconcept
WHERE
    type = 'FINDNG' 
  AND
	(subtype = 'VS' OR
    subtype = 'LAB' OR
    subtype = 'CARDIO' OR
    subtype = 'MICRO') 
;