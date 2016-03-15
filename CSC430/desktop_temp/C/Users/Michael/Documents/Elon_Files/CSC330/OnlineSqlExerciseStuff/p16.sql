SELECT 
	tradedate AS "Date",
    symbol AS "Symbol",
    open AS "Open",
    close as "Close",
    ROUND((close-open),2) AS "Diff"
FROM
	financial.securities
WHERE
	DATE(tradedate) >= '2007-01-01' AND DATE(tradedate) <= '2007-12-31'
ORDER BY
	tradedate DESC
;