/*
查询并打印员工的姓名和薪水
光标的属性: %isopen %rowcount(影响的行数)
           %found  %notfound
*/
set serveroutput on;
declare
  --定义光标
  cursor cemp is select ename,sal from emp;
  pname emp.ename%type;
  psal emp.sal%type;
begin
  --打开光标
  open cemp;
  
  loop
    --获取当前记录
    fetch cemp into pname,psal;
    --没有取到数据退出
    exit when cemp%notfound;
    
    dbms_output.put_line(pname||' 的薪水是 '||psal);
  
  end loop;
  --关光标
  close cemp;
end;
/