/*
创建procedure
*/

create or replace procedure sayhello
as 
  --声明部分
begin
  dbms_output.put_line('Hello World');
end;
/

/*
procedure的调用方式一
*/
exec sayhello();
/*
procedure的调用方式二
*/

begin
  sayhello();
  sayhello();
end;
/