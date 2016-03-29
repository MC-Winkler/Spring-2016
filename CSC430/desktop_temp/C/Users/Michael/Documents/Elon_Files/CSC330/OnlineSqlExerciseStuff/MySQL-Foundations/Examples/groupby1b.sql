SELECT
  CONCAT(bb_players.firstname," ",bb_players.lastname) AS "Player",
  SUM(bb_pitching.W) AS "Wins", 
  SUM(bb_pitching.L) AS "Losses"      
FROM   trainwarehouse.bb_pitching
JOIN trainwarehouse.bb_players ON bb_players.lahmanID = bb_pitching.playerID
WHERE bb_pitching.yearID = 1961
GROUP BY  bb_pitching.yearID 
ORDER BY SUM(bb_pitching.W) DESC
;