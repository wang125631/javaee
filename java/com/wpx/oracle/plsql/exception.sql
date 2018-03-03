/*
plsql中列外的情况
*/
set serveroutput on;
declare 
  cursor cemp  is select ename from emp where deptno=50;
  pename emp.ename%type;
  
  --定义一个exception
  no_emp_found exception;
begin
  open cemp;
  
  --获取变量信息
  fetch cemp into pename;
  if cemp%notfound then
    --抛出对应的exception
    raise no_emp_found;
  end if;
  
  
  close cemp;

exception
  when no_emp_found then dbms_output.put_line('查找的员工不能存在');
  when others then dbms_output.put_line('网络异常');
end;
/
