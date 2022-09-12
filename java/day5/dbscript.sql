create table
    employees(
        id integer primary key auto_increment,
        firstname varchar(50) not null,
        lastname varchar(50),
        email varchar(150) unique,
        phone varchar(15) unique,
        hire_date date,
        city varchar(50) default 'Bangalore'
    );

-- runscript from '/Users/vinod/Documents/_FROM_DESKTOP_11SEP2022/SONY-SEP-2022/java/day5/dbscript.sql'

insert into employees (firstname) values ('Ramesh');

insert into employees
values (
        null,
        'Kishore',
        'Kumar',
        'kishorekumar@xmpl.com',
        '9988776655',
        '2022-08-12',
        'Mysore'
    );

insert into
    employees (firstname, hire_date, city)
values ('Rohit', '2022-08-12', default);

alter table employees add column salary double;

alter table employees
add
    constraint emp_chk_salary check (salary >= 20000);

insert into employees (firstname, salary) values ('Kiran', 15000);

alter table employees drop primary key;

alter table employees add primary key (id);

alter table employees drop constraint emp_chk_salary;

alter table employees
add
    constraint emp_chk_salary check (salary >= 20000);

alter table employees rename column hire_date to doj;

alter table employees rename column doj to hire_date;

alter table employees modify email varchar(100);

alter table employees modify salary integer;

update employees set salary=35000 where id=1;

update employees
set
    lastname = 'Varma',
    email = 'rohitvarma@xmpl.com',
    salary = 28500
where id = 3;

update employees
set
    lastname = 'Kumar',
    hire_date = sysdate()
where id in (1, 5);

update employees set salary=salary*1.1;

update employees set salary=25000 where salary is null;

create table
    departments(
        id integer primary key auto_increment,
        name varchar(50) not null,
        location varchar(50) default 'Bangalore'
    );

insert into
    departments(name, location)
values ('ADMIN', default), ('ACCOUNTING', 'Mysore'), ('MARKETING', 'Mumbai'), ('PRODUCTION', default);

alter table employees 
add department_id integer;

alter table employees
add constraint emp_dept_fk foreign key (department_id)
references departments (id);

-- invalid department_id
update employees set department_id = 7 where id=1; --error
update employees set department_id = 1 where id=1; -- no error

delete from departments where id = 1; -- error
delete from departments where id = 4; -- no error
