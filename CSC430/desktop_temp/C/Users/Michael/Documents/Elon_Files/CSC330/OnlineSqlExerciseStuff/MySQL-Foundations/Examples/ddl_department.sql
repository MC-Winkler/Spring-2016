CREATE TABLE IF NOT EXISTS `department`
     (
       `department_pk`       INT(11)      NOT NULL   , 
       `id`                  CHAR(6)          NULL   , 
       `inactive_timestamp`  DATETIME         NULL   , 
       `type_cde`            CHAR(1)          NULL   , 
       `name`                VARCHAR(30)      NULL   , 
       PRIMARY KEY (department_pk) 
     ) ENGINE = MYISAM
;
