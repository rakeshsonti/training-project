-- joins, groups, orders are most commonly used. spend enough time to experiment and learn each throroughly
-- insert into students(first_name,age,roll_number) values ("kirti",24,"1001");
-- insert into student(stu_id,name,pin) values (1,'ram',455118);
-- insert into student(stu_id,name,pin) values (2,'molay',455008);
-- insert into student(stu_id,name,pin) values (3,'prasanth',456010);
-- insert into student(stu_id,name,pin) values (4,'uday',455987);
-- update student set city ='ujjain',pin=123456 where name="ram";
-- update student set city='delhi' ,pin=123456 where name="molay";
-- update student set city= 'muzfanagar',pin=123456 where name="prasanth";
-- update student set city = 'jaipur' ,pin=123456 where name="uday";

-- select * from student where stu_id between 1 and 2;
-- select * from student where name between 'm' and 'p';

-- select * from student where stu_id = 2 or 3 ;
-- why this one is giving me a range

-- insert into students values('raja',34,1);
-- insert into students values('raja',35,1);
-- insert into students values('raja',34,1);
-- insert into students values('kiran',35,2);
-- insert into students values('ajju',36,2);

-- select distinct roll_number from students;
-- select count(distinct roll_number,age
-- ) from students;

-- create table live(
--     coutry char(30),
--     state varchar(25),
--     city varchar(30),
--     pin int
-- )
-- insert into live values("india","mp","indore",455987);
-- insert into live values("india","up","muzfanagar",455099);
-- insert into live values("india","mp","ujjain",894858);
-- insert into live values("india","raj","tikamgad",948595);
-- insert into live values("india","raj","udaypur",837478);
-- alter table live rename column coutry to country;
-- alter table live rename to something;
-- alter table something ADD (stu_gender varchar(23), stu_roll int(24));
-- alter table something change column stu_gender  stu_gen char(20);
-- alter table something change column pin  pin decimal(20,3);
-- alter table something modify country text(200);
-- alter table something drop column stu_gen;
-- alter table something add index my_index (state);
-- alter table something drop index my_index;
-- select * from something where state in ('mp','up') ;
-- select * from something where state="mp" and state="up";
-- select * from something where stu_name is  null;
-- select * from something where pin between 400000 and 500000;

-- select * from something where state like "%p";
-- select * from something where state like "m%p";
-- select * from something where city like "__d%";
-- select * from something where city like "%i%";
-- select * from something where city like "__do__";

-- select * from something where city   like '[a-t]%';


-- select * from something order by state asc;
-- select * from something order by state desc;


