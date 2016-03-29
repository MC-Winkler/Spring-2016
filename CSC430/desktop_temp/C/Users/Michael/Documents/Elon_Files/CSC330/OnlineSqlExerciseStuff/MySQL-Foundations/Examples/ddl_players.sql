CREATE TABLE IF NOT EXISTS `bb_players`
     (
       `lahmanID`      INT(11)      NOT NULL   , 
       `playerID`      CHAR(15)         NULL   , 
       `managerID`     CHAR(15)         NULL   , 
       `birthYear`     INT(11)          NULL   , 
       `birthMonth`    INT(11)          NULL   , 
       `birthDay`      INT(11)          NULL   , 
       `birthCountry`  VARCHAR(30)      NULL   , 
       `birthState`    VARCHAR(15)      NULL   , 
       `birthCity`     VARCHAR(35)      NULL   , 
       `deathYear`     INT(11)          NULL   , 
       `deathMonth`    INT(11)          NULL   , 
       `deathDay`      INT(11)          NULL   , 
       `deathCountry`  VARCHAR(30)      NULL   , 
       `deathState`    VARCHAR(15)      NULL   , 
       `deathCity`     VARCHAR(35)      NULL   , 
       `Firstname`     VARCHAR(35)      NULL   , 
       `Lastname`      VARCHAR(35)      NULL   , 
       `weight`        INT(11)          NULL   , 
       `height`        FLOAT            NULL   , 
       `bats`          CHAR(1)          NULL   , 
       `throws`        CHAR(1)          NULL   , 
       `college`       VARCHAR(75)      NULL   , 
       PRIMARY KEY (lahmanID) 
     ) ENGINE = MYISAM
;

CREATE UNIQUE INDEX IX_bb_players_playerID USING BTREE
ON     bb_players(playerID) 
;

CREATE UNIQUE INDEX IX_bb_players_managerID USING BTREE
ON     bb_players(managerID) 
;