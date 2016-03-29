SELECT acctnum               , 
       patient_fk            , 
       admit_date            ,  
       admitting.lastname AS "Admitting", 
       attending.lastname AS "Attending", 
       md1_fk               
FROM   hospitalization
JOIN provider admitting ON hospitalization.admitting_md_fk = admitting.provider_pk
JOIN provider attending ON hospitalization.attending_fk = attending.provider_pk
;

