EXPLAIN EXTENDED SELECT 
 symbol,
 tradedate
FROM financial.securities
WHERE tradedate = '2006-01-11' AND
symbol IN ('ABT','LNCE','AEP','JNJ')
;