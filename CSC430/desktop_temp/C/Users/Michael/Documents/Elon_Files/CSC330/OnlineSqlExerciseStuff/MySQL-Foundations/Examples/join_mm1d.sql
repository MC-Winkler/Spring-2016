SELECT 
       courses.course_name,
       classes.class_start_date,
       classregistration.seat_num,        
       students.firstname,
       students.lastname
FROM   tngmgr.classregistration
JOIN tngmgr.students ON students.student_id = classregistration.student_id_fk
JOIN tngmgr.classes ON classes.classes_num = classregistration.classes_num
JOIN tngmgr.courses ON courses.course_designater = classes.course_designater_fk
