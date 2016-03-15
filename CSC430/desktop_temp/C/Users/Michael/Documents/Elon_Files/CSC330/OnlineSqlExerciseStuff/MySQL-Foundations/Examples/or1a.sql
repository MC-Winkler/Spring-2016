SELECT 
    course_designater,
    course_name,
    education_delivery_method
FROM
    tngmgr.courses
WHERE
 education_delivery_method = 'Classroom' AND course_name LIKE 'Intro%' 
OR     
 education_delivery_method = 'Distance Educ' AND course_name LIKE 'Intro%'
;