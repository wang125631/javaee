/*
存储函数
*/
create or replace query_emp_income_function(eno in number)
return number
is
	--定义变量用于存储员工工资和奖金
	psal emp.sal%type;
	pcomm emp.comm%type;
begin
	--将工资和奖金信息赋值给变量
	select sal,comm into psal,pcomm from emp where empno = eno;
	--用于返回收入信息
	return psal*12+nvl(comm,0);
end query_emp_income_function;
/


/*
调用存储函数
*/
select query_emp_income_funtion(7654) from dual;
