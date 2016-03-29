SELECT 
  yearID, 
  teamID,
  playerID,
  W,
  L
FROM   trainwarehouse.bb_pitching
WHERE yearID = 1961
ORDER BY teamID
;