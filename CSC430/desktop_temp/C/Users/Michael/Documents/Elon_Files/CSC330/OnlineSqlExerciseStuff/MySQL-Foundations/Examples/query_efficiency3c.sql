/* 
 How many rows are in this table? _____
 How many rows is this query reading? _____
 Is this query using an index or the primary key?
 Is this an efficient query? _____
 Can anything be done to improve the efficiency of this query?
 _____________________________________________________________________
 _____________________________________________________________________
*/

SELECT 
  * 
FROM 
  trainwarehouse.bb_pitching
WHERE 
  playerID LIKE 'Cl%'
;