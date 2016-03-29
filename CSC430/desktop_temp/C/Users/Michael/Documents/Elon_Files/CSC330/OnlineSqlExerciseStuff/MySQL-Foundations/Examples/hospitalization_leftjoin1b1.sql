SELECT 
       hospitalization.acctnum, 
       hospitalization.md1_fk                
FROM   healthcare.hospitalization
JOIN   healthcare.provider ON provider.provider_pk = hospitalization.md1_fk
;