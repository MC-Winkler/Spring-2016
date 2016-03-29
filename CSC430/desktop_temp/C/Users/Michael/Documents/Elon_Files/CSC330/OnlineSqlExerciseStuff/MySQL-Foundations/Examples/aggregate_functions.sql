SELECT name,  
       SUM(HR) AS "SUM",
       ROUND(AVG(HR),1) AS "AVG",     
       MAX(HR) AS "MAX",
       STD(HR) AS "Standard Deviation"
FROM   trainwarehouse.bb_batting
JOIN trainwarehouse.teams ON teams.teamID = bb_batting.teamID
WHERE bb_batting.yearID = 1927 
GROUP BY bb_batting.teamID
ORDER BY SUM(HR) DESC
;