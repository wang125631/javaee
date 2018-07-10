/*
数据确认
薪水涨后不能少于涨前
*/
create or replace trigger checksalary
before update
on emp
for each row
begin
  --if 涨前的薪水< 涨后的工资 then 
  if :new.sal < :old.sal then
    raise_application_error(-20002,'涨后的工资不能低于涨前');
  end if;
end checksalary;
/