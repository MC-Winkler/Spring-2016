CREATE TABLE IF NOT EXISTS `hospitalization`
     (
       `acctnum`                INT(11)      NOT NULL   , 
       `patient_fk`             INT(11)          NULL   , 
       `admit_date`             DATETIME         NULL   , 
       `admit_time`             CHAR(4)          NULL   , 
       `admission_facility_fk`  INT(11)          NULL   , 
       `admission_source`       CHAR(3)          NULL   , 
       `arrival_mode`           CHAR(2)          NULL   , 
       `admitting_md_fk`        INT(11)          NULL   , 
       `nursing_unit`           CHAR(4)          NULL   , 
       `admission_reason`       VARCHAR(40)      NULL   , 
       `discharge_date`         DATETIME         NULL   , 
       `discharge_time`         CHAR(4)          NULL   , 
       `facility_fk`            INT(11)          NULL   , 
       `ns`                     CHAR(4)          NULL   , 
       `room`                   CHAR(4)          NULL   , 
       `bed`                    CHAR(8)          NULL   , 
       `nrb_flag`               CHAR(1)          NULL   , 
       `attending_fk`           INT(11)          NULL   , 
       `md1_fk`                 INT(11)          NULL   , 
       PRIMARY KEY (acctnum) 
     ) ENGINE = MYISAM
;

CREATE INDEX IX_hospitalization_admit_date USING BTREE
ON     hospitalization(admit_date) 
;