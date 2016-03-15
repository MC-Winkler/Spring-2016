SELECT 
	symbol,
    tradedate,
    volume,
    CASE
		WHEN volume <= 4000000 THEN 'Light Volume'
        WHEN volume >= 4000000 AND volume < 8000000 THEN 'Medium Volume'
        WHEN volume >= 8000000 THEN 'Heavy Volume'
        END
	AS "Volume Type"
FROM 
	financial.securities;