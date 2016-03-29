CREATE TABLE IF NOT EXISTS `teams`
     (
       `name`    VARCHAR(75)  NOT NULL   , 
       `teamID`  CHAR(3)      NOT NULL   , 
       PRIMARY KEY (teamID) 
     ) ENGINE = MYISAM
;