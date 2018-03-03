/*
	统计各个年份入职的员工总数
*/
set serveroutput on;
declare
  cursor cemp is select to_char(hiredate,'yyyy') from emp;
  phiredate varchar2(4);
  count80 number := 0;
  count81 number := 0;
  count82 number := 0;
  count87 number := 0;
begin
  open cemp;
  loop
    fetch cemp into phiredate ;
    exit when cemp%notfound;
    
    if phiredate ='1980' then
      count80:=count80 + 1;
    elsif phiredate='1981' then
      count81:=count81 + 1;
    elsif phiredate='1982' then
      count82:=count82 + 1;
    else
      count87:=count87 + 1;
    end if;
  end loop;
  close cemp;
  
  dbms_output.put_line('Total: '||(count80+count81+count82+count87));
  dbms_output.put_line('1980: '||count80);
  dbms_output.put_line('1981: '||count81);
  dbms_output.put_line('1982: '||count82);
  dbms_output.put_line('1987: '||count87);
end;
/