CREATE TABLE IF NOT EXISTS `patientaccount`
     (
       `acctnum`             INT(11)   NOT NULL   , 
       `patient_fk`          INT(11)       NULL   , 
       `start_date`          DATETIME      NULL   , 
       `end_date`            DATETIME      NULL   , 
       `type`                CHAR(1)       NULL   , 
       `subtype`             CHAR(1)       NULL   , 
       `facility_fk`         INT(11)       NULL   , 
       `fc`                  CHAR(2)       NULL   , 
       `fin_class`           CHAR(1)       NULL   , 
       `subclass`            CHAR(1)       NULL   , 
       `facility_chrgs`      DOUBLE        NULL   , 
       `professional_chrgs`  DOUBLE        NULL   , 
       `total_charges`       DOUBLE        NULL   , 
       PRIMARY KEY (acctnum) 
     ) ENGINE = MYISAM
;

CREATE INDEX IX_patientaccount_patient_fk USING BTREE
ON     patientaccount(patient_fk) 
;