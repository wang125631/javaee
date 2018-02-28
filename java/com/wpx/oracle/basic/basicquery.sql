/*
查询当前用户
*/
show user;
/*
查询所有table
*/
select * from tab;
/*
sql优化原则
使用列名字
*/
select empno,ename,sal from emp;
/*
sql中的null
 1.包含null的表达式都为null
 2.null永远 != null
 select empno,ename,sal,sal*12,comm,sal*12+comm from emp;不能达到预期的结果
 nvl(a,b); 当a为null值返回b
 nvl2(a,b,c);当a为null值返回b,否则返回c
*/
select empno "员工号",ename "姓名",sal "薪水",sal*12 "年薪",comm "奖金",sal*12+nvl(comm,0) "总收入" from emp;
select * from emp where comm=null;
/*
去除重复数据
作用于后面的所有列
*/
select distinct deptno,job from emp;
/*
concat函数用于连接字符,dual为oracle的虚表
mysql的5.0以后版本也支持
*/
select concat('hello',' world') from dual; 
select 'hello'||' world' from dual;
select ename ||'的新水为'||sal from emp;
