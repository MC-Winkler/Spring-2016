SELECT 
  yearID, 
  teamID,
  SUM(W) AS "Wins", 
  SUM(L) AS "Losses"      
FROM   trainwarehouse.bb_pitching
WHERE yearID > 1899
GROUP BY yearID, teamID
HAVING SUM(W) >= 100
ORDER BY SUM(W) DESC
;
