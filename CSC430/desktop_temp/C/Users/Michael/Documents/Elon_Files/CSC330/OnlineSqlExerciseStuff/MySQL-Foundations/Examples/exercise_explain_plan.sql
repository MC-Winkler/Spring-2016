SELECT acctnum               , 
       patient_fk            , 
       admit_date            ,  
       admitting.lastname AS "Admitting", 
       attending.lastname AS "Attending", 
       surgeon.lastname AS "Surgeon"                
FROM   healthcare.hospitalization
JOIN healthcare.provider admitting ON hospitalization.admitting_md_fk = admitting.provider_pk
JOIN healthcare.provider attending ON hospitalization.attending_fk = attending.provider_pk
LEFT JOIN healthcare.provider surgeon ON hospitalization.md1_fk = surgeon.provider_pk
;

