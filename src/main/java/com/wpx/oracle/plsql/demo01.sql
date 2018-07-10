/*
给员工涨工资,总裁1000,经理800,其他400
*/

set serveroutput on;
declare
  cursor cemp is select empno,job from emp;
  pempno emp.empno%type;
  pjob emp.job%type;
begin
  rollback;
  
  open cemp;
  loop
    fetch cemp into pempno,pjob;
    exit when cemp%notfound;
    
    if pjob= 'PRESIDENT' then
      update emp set sal = sal+1000 where empno = pempno;
    elsif pjob ='MANAGER' then
      update emp set sal =sal+800 where empno = pempno ;
    else
      update emp set sal =sal+400 where empno =pempno;
    end if;
  end loop;
  close cemp;
  
  commit;
  dbms_output.put_line('完成');
end;
/
