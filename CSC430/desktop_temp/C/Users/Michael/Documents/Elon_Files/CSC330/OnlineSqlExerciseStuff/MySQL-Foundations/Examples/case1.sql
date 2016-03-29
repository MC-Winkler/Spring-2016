/* Case - Conditionally Evaluating Data */
SELECT
   course_designater,
   CASE
     WHEN course_designater LIKE '%100'
          THEN 'Introductory Course'
     WHEN course_designater LIKE '%200'
          THEN 'Intermediate Course'
     WHEN course_designater LIKE '%300'
          THEN 'Advanced Course'
	 ELSE ''
    END AS "Course Level"
FROM
    tngmgr.coursesteacherscanteach
;

