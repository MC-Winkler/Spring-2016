SELECT courses.course_designater,
       classes.course_designater_fk, 
       courses.course_name,
       courses.education_delivery_method   
FROM   courses
LEFT JOIN classes ON classes.course_designater_fk = courses.course_designater
;