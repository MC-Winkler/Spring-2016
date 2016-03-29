CREATE TABLE IF NOT EXISTS `patient`
     (
       `patient_pk`      INT(11)      NOT NULL   , 
       `facility_fk`     INT(11)          NULL   , 
       `lastname`        VARCHAR(30)      NULL   , 
       `firstname`       VARCHAR(20)      NULL   , 
       `gender`          CHAR(1)          NULL   , 
       `dob`             DATETIME         NULL   , 
       `marital_status`  CHAR(3)          NULL   , 
       `race`            CHAR(5)          NULL   , 
       `deceased_flag`   CHAR(1)          NULL   , 
       `id`              CHAR(20)         NULL   , 
       PRIMARY KEY (patient_pk) 
     ) ENGINE = MYISAM
;