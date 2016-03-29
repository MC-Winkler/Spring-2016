SELECT 
    course_designater,
    course_name,
    education_delivery_method
FROM
    tngmgr.courses
WHERE
   education_delivery_method = 'Classroom' AND 
   education_delivery_method = 'Distance Educ'     
   OR 	course_name LIKE 'Intro%'
