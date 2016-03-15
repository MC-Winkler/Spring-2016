SELECT 
       hospitalization.acctnum, 
       hospitalization.md1_fk                
FROM   healthcare.hospitalization
LEFT JOIN   healthcare.provider ON provider.provider_pk = hospitalization.md1_fk
;