INSERT INTO Course (ID, NAME) VALUES(10001,  'Spring Cloud');
INSERT INTO Course (ID, NAME) VALUES(10002,  'Spring Boot');
INSERT INTO Course (ID, NAME) VALUES(10003,  'Spring JPA');
/*
INSERT INTO Passport (ID, passport_number) VALUES(10000,  'UVSE123X');
INSERT INTO Passport (ID, passport_number) VALUES(10001,  'ABCD8900');
INSERT INTO Passport (ID, passport_number) VALUES(10002,  'MOPKNI89');

INSERT INTO Student (ID, NAME,PASSPORT_ID) VALUES(100,  'Peter',10000);
INSERT INTO Student (ID, NAME,PASSPORT_ID) VALUES(101,  'Vijay',10001);
INSERT INTO Student (ID, NAME,PASSPORT_ID) VALUES(102,  'Arjun',10002);

INSERT INTO student_course (student_id,course_id) VALUES(100,10001);
INSERT INTO student_course (student_id,course_id) VALUES(101,10001);
INSERT INTO student_course (student_id,course_id) VALUES(102,10001);
INSERT INTO student_course (student_id,course_id) VALUES(100,10002);*/


INSERT INTO Reviews (ID, RATINGS, DESCRIPTION,COURSE_ID) VALUES(100,  '1','great',10001);
INSERT INTO Reviews (ID, RATINGS, DESCRIPTION,COURSE_ID) VALUES(200,  '2','good',10001);
INSERT INTO Reviews (ID, RATINGS, DESCRIPTION,COURSE_ID) VALUES(300,  '1','good course',10002);