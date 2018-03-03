/*
为员工涨工资,从最低的涨起每人10%,
但工资总额不能超过5w元计算并输出涨工资人数及工资总额
*/
set serveroutput on;
declare
  cursor cemp is select empno,sal from emp order by sal;
  pempno emp.empno%type;
  psal emp.sal%type;
  
  countEmp number := 0;
  salTotal number := 0;
begin
  rollback;
  --得到工资总额的初始值
  select sum(sal) into salTotal from emp;
  open cemp;
  loop
    --总额大于5w
    exit when salTotal > 50000;
    --取一个员工
    fetch cemp into pempno,psal;
    --遍历完退出
    exit when cemp%notfound;
    
    --为员工涨工资
    update emp set sal=sal*1.1 where empno = pempno;
    --人数加1
    countEmp := countEmp + 1;
    --刷新涨后总工资金额
    salTotal := salTotal+psal*0.1;
  end loop;
  close cemp;
  commit;
  dbms_output.put_line('涨工资的人数为 '||countEmp||' 涨后工资总额为 '||salTotal);
end;
/
