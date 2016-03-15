SELECT 
  yearID, 
  teamID,
  SUM(W) AS "Wins", 
  SUM(L) AS "Losses"      
FROM   trainwarehouse.bb_pitching
WHERE yearID > 1899 
/* improper use of where. must use having */
/*  AND    SUM(W) >= 100  */
GROUP BY yearID, teamID
ORDER BY SUM(W) DESC
;