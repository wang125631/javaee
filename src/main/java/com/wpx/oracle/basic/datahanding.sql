/*
SQL的类型
1.DML (Data Manipulation Language) :insert delete update select
2.DDL(Data Definition Language): create table,alter table,drop table,truncate table,create/drop view,sequnece,index,synonym
3.DCL(Data COntrol Language): grant(授权) revoke(撤销权限)
*/
/*
 &地址符
原值:insert into emp(empno,ename,sal,deptno) values(&empno,&ename,&sal,&deptno)
新值:insert into emp(empno,ename,sal,deptno) values(1111,'wangpx',1000,30)
1 行已插入。
*/
insert into emp(empno,ename,sal,deptno) values(&empno,&ename,&sal,&deptno);
select &l from emp;
select * from &t;
/*
一次插入多条记录
*/
create table emp10 as select * from emp where 1=2;
desc emp10;
select * from emp10;
/*
将部门号为30的所有员工信息插入到emp10表中
*/
insert into emp10 select * from emp where deptno=30;
select * from emp10;
/*
海量插入数据
  1.数据泵(PLSQL程序) dbms_datapump(程序包)
  2.SQL*Loader
  3.外部表
*/
/*
  delete和truncate的区别:
  1.delete逐条删除,truncate是先摧毁表再重建
  2.delete是DML,可以回滚,truncate是DDL不能回滚
  3.delete不会释放空间,truncate会
  4.delete会产生碎片,truncate不会
  5.delete可以flashback,truncate不能
*/
set feeback off;
set timing on;
/*
oracle 中的事务
  1.起始标志:事务中的第一条DNL语句
  2.结束标志:
    提交:显式:commit 隐式:正常退出DDL DCL
    回滚:显式rollback 隐式:非正常退出 宕机
*/
/*
创建保存点
*/
create table testsavepoint(
tid number,
tname varchar(20)
);
insert into testsavepoint values(1,'wangpx');
savepoint a;
insert into testsavepoint values(2,'wpx');
rollback to savepoint a;
select count(*) from testsavepoint;
/**
set transaction read only;
 将不能在 READ ONLY 事务处理中执行插入/删除/更新操作 
*/
/*
行号rownum
  1.rownum 永远按照默认的顺序生成
  2.rownum 只能使用< <= ;不能使用> >=
*/
select rownum,empno,ename,sal from emp;
select rownum,empno,ename,sal from emp where rownum <= 3 order by sal desc; 
/*
查询工资最高三个人的信息
*/
select rownum,empno,ename,sal
from (select * from emp order by sal desc)
where rownum <=3;
/*
oracle分页
*/
select *
from (select rownum r,e1.* 
  from (select * from emp order by sal) e1 
  where rownum <=8
)
where r >=5;
/*
相关子查询
*/
select empno,ename,sal,(select avg(sal) from emp where deptno = e.deptno) avgsal
from emp e
where sal > (select avg(sal) from emp where deptno = e.deptno);
/*
集合运算
*/
/*
查询10号和20号部门的员工
*/
select * 
from emp 
where deptno =10 or deptno =20;

select * 
from emp 
where deptno in(10,20,null);
/*
oracle 的增强group by
*/
select deptno,job,sum(sal)
from emp
group by deptno,job;

select deptno,job,sum(sal) 
from emp
group by rollup(deptno,job);
/*
增强group by 与下面的三条语句是等价的

ORA-01789: 查询块具有不正确的结果列数
01789. 00000 -  "query block has incorrect number of result columns"
*Cause:    
*Action:
行 122 列 1 出错

*/
select deptno,job,sum(sal) from emp group by deptno,job
union
select deptno,sum(sal) from emp group by deptno
union
select sum(sal) from emp;
/*
出现上述原因:
  1.参与运算的各个集合必须列数
  2.采用第一个集合作为表头
  3.order by 永远在最后
  4.括号
*/
select deptno,job,sum(sal) from emp group by deptno,job
union
select deptno,to_char(null),sum(sal) from emp group by deptno
union
select to_number(null),to_char(null),sum(sal) from emp;
