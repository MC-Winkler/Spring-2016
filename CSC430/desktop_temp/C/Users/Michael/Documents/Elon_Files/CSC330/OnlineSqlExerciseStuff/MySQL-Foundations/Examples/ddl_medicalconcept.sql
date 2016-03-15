CREATE TABLE IF NOT EXISTS `medicalconcept`
     (
       `med_concept_pk`      INT(11)      NOT NULL   , 
       `type`                CHAR(6)          NULL   , 
       `subtype`             CHAR(6)          NULL   , 
       `inactive_timestamp`  CHAR(26)         NULL   , 
       `item`                VARCHAR(80)      NULL   , 
       PRIMARY KEY (med_concept_pk) 
     ) ENGINE = MYISAM
;