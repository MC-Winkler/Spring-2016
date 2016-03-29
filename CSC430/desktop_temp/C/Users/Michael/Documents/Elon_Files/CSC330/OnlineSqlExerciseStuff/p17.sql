SELECT 
	CONCAT("symbol:",symbol) AS "symbol",
    CONCAT("quantity:", quantity) AS "quantity",
    CONCAT("transactionid:", transactionid) AS "transactionid"
FROM 
	financial.security_transactions
WHERE
	symbol IS NOT NULL
;
    