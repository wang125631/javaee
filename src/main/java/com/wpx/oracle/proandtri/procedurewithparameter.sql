/*
查询某个员工的姓名,薪水和职位
*/
create or replace procedure query_emp_infomation_procedure(
                                                            eno in number,
                                                            pname out varchar2,
                                                            psal out number,
                                                            pjob out varchar2)
is
begin
  select ename,sal,job into pname,psal,pjob from emp where empno = eno;
end query_emp_infomation_procedure;
/
/*
调用procedure
*/
set serveroutput on;
declare
  pname emp.ename%type;
  psal emp.sal%type;
  pjob emp.job%type;
begin
  query_emp_infomation_procedure(7654,pname,psal,pjob);
  dbms_output.put_line('姓名为: '||pname||' 薪水: '||psal||' 职位: '||pjob);
end;
/
