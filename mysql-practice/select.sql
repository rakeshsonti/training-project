-- select * from students;
-- insert into students(first_name,age,roll_number) values ('suresh\'s',89,"1011"),
-- ('shruti',34,1006);
-- delete from students where roll_number=1011;
select first_name,age from students skip 3 , limit 2;