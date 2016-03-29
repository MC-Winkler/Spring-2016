SELECT 
  yearID, 
  teamID,
  SUM(W) AS "Wins", 
  SUM(L) AS "Losses"      
FROM   trainwarehouse.bb_pitching
WHERE yearID = 1961
GROUP BY teamID
ORDER BY SUM(W) DESC
;