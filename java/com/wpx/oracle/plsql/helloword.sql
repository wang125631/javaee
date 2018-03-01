/*
执行以下程序Hello World 不能被正常打印
因为Oracle中默认输出是关闭的
*/
declare
 --说明部分 (变量说明,光标申明,例外说明)
begin
  --程序 (DML语句)
  dbms_output.put_line('Hello World');
--exception 
  --异常处理
end;
/
/*

*/
set serveroutput on;
declare
 --说明部分
begin
  --程序
  dbms_output.put_line('Hello World');
--exception 
  --异常处理
end;
/