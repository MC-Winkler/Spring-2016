CREATE TABLE IF NOT EXISTS `bb_pitching`
     (
       `playerID`  CHAR(15)  NOT NULL   , 
       `yearID`    INT(11)   NOT NULL   , 
       `stint`     INT(11)   NOT NULL   , 
       `teamID`    CHAR(3)   NOT NULL   , 
       `lgID`      CHAR(2)       NULL   , 
       `W`         INT(11)       NULL   , 
       `L`         INT(11)       NULL   , 
       `G`         INT(11)       NULL   , 
       `GS`        INT(11)       NULL   , 
       `CG`        INT(11)       NULL   , 
       `SHO`       INT(11)       NULL   , 
       `SV`        INT(11)       NULL   , 
       `IPouts`    INT(11)       NULL   , 
       `H`         INT(11)       NULL   , 
       `ER`        INT(11)       NULL   , 
       `HR`        INT(11)       NULL   , 
       `BB`        INT(11)       NULL   , 
       `SO`        INT(11)       NULL   , 
       `BAOpp`     FLOAT         NULL   , 
       `ERA`       FLOAT         NULL   , 
       `IBB`       INT(11)       NULL   , 
       `WP`        INT(11)       NULL   , 
       `HBP`       INT(11)       NULL   , 
       `BK`        INT(11)       NULL   , 
       `BFP`       INT(11)       NULL   , 
       `GF`        INT(11)       NULL   , 
       `R`         INT(11)       NULL   , 
       PRIMARY KEY (playerID, yearID, stint, teamID) 
     ) ENGINE = MYISAM
;

CREATE INDEX IX_bb_pitching_teamID USING BTREE
ON     bb_pitching(teamID) 
;