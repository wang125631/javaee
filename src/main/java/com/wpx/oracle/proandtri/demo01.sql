/*
��ֹ�ڷǹ���ʱ�� ������Ա��

1����ĩ:  to_char(sysdate,'day') in ('������','������')
2���ϰ�ǰ �°��to_number(to_char(sysdate,'hh24')) not between 9 and 17
*/
create or replace trigger securityemp
before insert
on emp
begin
  if to_char(sysdate,'day') in ('������','������','������') or to_number(to_char(sysdate,'hh24')) not between 9 and 17 then
    --��ֹinsert
    RAISE_APPLICATION_ERROR(-20000, 'Fatal error.');
  end if;
end;
/