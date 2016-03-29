CREATE TABLE IF NOT EXISTS `facility`
     (
       `facility_pk`         INT(11)      NOT NULL   , 
       `id`                  CHAR(6)          NULL   , 
       `inactive_timestamp`  DATETIME         NULL   , 
       `type_cde`            CHAR(6)          NULL   , 
       `name`                VARCHAR(30)      NULL   , 
       `phone`               CHAR(15)         NULL   , 
       `street_ln`           VARCHAR(26)      NULL   , 
       `city_nm`             VARCHAR(20)      NULL   , 
       `state_abbrev`        CHAR(2)          NULL   , 
       `postal_cde`          CHAR(9)          NULL   , 
       PRIMARY KEY (facility_pk) 
     ) ENGINE = MYISAM
;
