CREATE TABLE IF NOT EXISTS `provider`
     (
       `provider_pk`    INT(11)      NOT NULL   , 
       `type_code`      CHAR(1)          NULL   , 
       `inactv_ts`      DATETIME         NULL   , 
       `facility_fk`    INT(11)          NULL   , 
       `department_fk`  INT(11)          NULL   , 
       `lastname`       VARCHAR(25)      NULL   , 
       `firstname`      VARCHAR(35)      NULL   , 
       PRIMARY KEY (provider_pk) 
     ) ENGINE = MYISAM
;