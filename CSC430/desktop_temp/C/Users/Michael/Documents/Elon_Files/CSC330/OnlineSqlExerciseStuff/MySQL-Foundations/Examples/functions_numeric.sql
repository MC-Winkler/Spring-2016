/* Numeric functions */
SELECT symbol  , 
       high    ,
       ROUND(high) AS "Round To Whole",
       high * 1.376 AS "New Num",
       ROUND((high * 1.376),2) AS "Round Decimal",     
       TRUNCATE((high * 1.376),2) AS "Truncate Decimal"
FROM   financial.securities
LIMIT 100 
;