/*
禁止在非工作时间 插入新员工

1、周末:  to_char(sysdate,'day') in ('星期六','星期日')
2、上班前 下班后：to_number(to_char(sysdate,'hh24')) not between 9 and 17
*/
create or replace trigger securityemp
before insert
on emp
begin
  if to_char(sysdate,'day') in ('星期六','星期日','星期五') or to_number(to_char(sysdate,'hh24')) not between 9 and 17 then
    --禁止insert
    RAISE_APPLICATION_ERROR(-20000, 'Fatal error.');
  end if;
end;
/