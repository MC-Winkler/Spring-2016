SELECT 
    playerID,
    yearID AS "Year",
    AB AS "At Bats",
    H AS "Hits",
    HR AS "Homeruns"
FROM
    trainwarehouse.bb_batting
LIMIT 1000
;