SELECT 
    symbol, 
    MONTHNAME(tradedate) AS "Month", 
    MIN(open),
    MIN(high),
    MAX(open),
    MAX(high),
    ROUND(AVG(open),2) AS "Avg Open", 
    ROUND(AVG(high),2) AS "Avg High", 
    ROUND(STD((high - open)),2) AS "Standard Dev"  
FROM  financial.securities
WHERE symbol = 'ABT' 
GROUP BY MONTH(tradedate)
;