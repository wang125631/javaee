/*
if 语句
  if 条件 then 语句1
    语句2
  end if;

*/
set serveroutput on;
declare 
  pnum number := &number;
begin
  if pnum = 1 then
    dbms_output.put_line('我是1');
  end if;
end;
/
/*
if 条件1 then 
  语句一
else
  语句二
end if;
*/
set serveroutput on;
declare 
  mynum number := &put_your_number;
begin
  if mynum = 1 then
    dbms_output.put_line('您输入的数字是1');
  else
    dbms_output.put_line('您输入的数字不是1');
  end if;
end;
/
/*
if 条件1
  语句一
elsif 条件2
  语句二
elsif 条件3
  语句三
...
else 
 语句else
end if;
*/
set serveroutput on;
declare 
  mynum number := &put_your_number;
begin
  if mynum = 1 then 
    dbms_output.put_line('您输入的数字是一');
  elsif mynum = 2 then  
    dbms_output.put_line('您输入的数字是二');
  elsif mynum = 3 then
    dbms_output.put_line('您输入的数字是三');
  else
    dbms_output.put_line('您输入的数字暂不支持解析');
  end if;
end;
/