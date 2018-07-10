/*
变量定义说明
  
  变量(char,varchar2,date,number,boolean,long)
  
  var char(15); --说明变量名为var的数据类型为char(15);
  married boolean :=true; 对boolean进行赋值
  psal number(7,2);
  my_name emp.ename%type; my_name将引用emp中的ename列的诗句类型
  
*/
set serveroutput on;
declare 
  myname emp.ename%type;
begin
  --从emp表中,找到empno=7654的员工,并将该员工的姓名通过into 赋值给上方定义的myname
  select t.ename into myname from emp t where t.empno = 7654;
  dbms_output.put_line(myname);
end;
/
