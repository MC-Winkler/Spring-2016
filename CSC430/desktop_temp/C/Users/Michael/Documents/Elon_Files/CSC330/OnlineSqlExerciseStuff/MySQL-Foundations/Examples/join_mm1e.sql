SELECT 
       courses.course_name AS "Course",
       DATE(classes.class_start_date) AS "Date",
       classregistration.seat_num AS "Seat#",
       CASE 
         WHEN lastname = 'PLACEHOLDER'
              THEN ""
         ELSE  CONCAT(students.firstname," ",students.lastname)
       END AS "Student"  
FROM   tngmgr.classregistration
JOIN tngmgr.students ON students.student_id = classregistration.student_id_fk
JOIN tngmgr.classes ON classes.classes_num = classregistration.classes_num
JOIN tngmgr.courses ON courses.course_designater = classes.course_designater_fk
