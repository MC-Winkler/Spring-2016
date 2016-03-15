/* 
 How many rows are in this table? _____
 How many rows is this query reading? _____
 Is this an efficient query? _____
 tempID is part of the primary_key. Based on the efficiency of this query
 respective to query_efficient2c what can you postulate about using a 
 column that is part of the primary key but not the first column in the
 primary key? ___________________________________________
*/

SELECT 
  * 
FROM 
  trainwarehouse.bb_pitching
WHERE 
  teamID = 'NYA'
;