/*
trigger支持的类型有 insert update delete
*/
create trigger emp_before_put_trigger
before insert
on emp
declare 
begin
  dbms_output.put_line('before trigger invoke...');
end;
/

create trigger emp_after_put_trigger
after insert
on emp
declare
begin
  dbms_output.put_line('after trigger invoke..');
end;
/

insert into emp(empno,ename,sal) values (1322,'wangpx',800);

select * from emp;





/*
与procedure相比较
*/
create or replace procedure say_hello_procedure
as
begin
  dbms_output.put_line('Hello');
end;
/
/*
procedure的调用方式一
*/
exec say_hello_procedure;
/*
procedure的调用方式二
*/
begin 
  say_hello_procedure();
  say_hello_procedure;
end;
/