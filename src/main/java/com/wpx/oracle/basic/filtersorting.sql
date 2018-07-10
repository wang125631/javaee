/*
查询depno=10的所有部门信息
*/
select * from emp where deptno=10;
/*
大小写敏感
*/
select * from emp where ename='KING';
select * from emp where ename='king';
/*
日期格式敏感
*/
select * from emp where hiredate='17-11月-81';
/*
修改日期格式
*/
select * from V$NLS_PARAMETERS;
alter session set NLS_DATE_FORMAT='yyyy-mm-dd ';
select * from emp where hiredate='1981-11-17'; 

/*
between and
  1.含有边界
  2.小值在前 大值在后
*/
select * from emp where sal between 1000 and 2000;
/*
null值 
如果集合中有null不能使用not in,但可以使用in
*/
select * from emp where deptno not in (10,20,null);
select * from emp where deptno  in (10,20,null);
/*
模糊查询
*/
select * from emp where ename like '%S';
select * from emp where ename like '____';
/*
模糊查询 带有'_'的字段
*/
insert into emp(empno,ename,sal,deptno) values(1001,'Wang_px',3000,10);
select * from emp where ename like '%\_%' escape '\';

/*
Sql优化
where 解析顺序:右->左
*/
select * from emp order by  sal*12 desc;
select * from emp order by 6 desc;
/*
  多个列排序
  orader 作用于后面的所有列,先按照第一排序,再后面的列
   desc只作用于离他最近的列
   
*/
select * from emp order by deptno,sal;
select * from emp order by sal,deptno desc;
select * from emp order by deptno desc,sal;
 /*
  希望在排序中将所有的null值放至最后
  null值最大
 */
 select * from emp order by comm;
 select * from emp order by comm desc;
 select * from emp order by comm desc nulls last;