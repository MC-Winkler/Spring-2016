SELECT 
       classregistration.classes_num,
       classregistration.seat_num,        
       students.firstname,
       students.lastname
FROM   tngmgr.classregistration
JOIN tngmgr.students ON students.student_id = classregistration.student_id_fk


