/*
创建视图
错误报告 -
SQL 错误: ORA-01031: 权限不足

解决方式:
通过管理用户授权,grant.png
*/
create view empinfoview
as
select e.empno,e.ename,e.sal,d.dname
from emp e,dept d
where e.deptno = d.deptno; 
desc empinfoview;
/*
查询视图数据
*/
select * from empinfoview;
/*
替换视图
*/
create or replace view empinfoview
as
select e.empno,e.ename,e.sal,e.sal*12 annsal,d.dname
from emp e,dept d
where e.deptno=d.deptno
with read only;
/*
序列
*/
create sequence myseq;

create table testseq(
tid number,
tname varchar2(20)
);
/*
ORA-08002: 序列 MYSEQ.CURRVAL 尚未在此会话中定义
08002. 00000 -  "sequence %s.CURRVAL is not yet defined in this session"
*Cause:    sequence CURRVAL has been selected before sequence NEXTVAL
*Action:   select NEXTVAL from the sequence before selecting CURRVAL
*/
select myseq.currval from dual;

select myseq.nextval from dual;
select myseq.currval from dual;

insert into testseq values(myseq.nextval,'wangpx3');
insert into testseq values(myseq.nextval,'wangpx4');
insert into testseq values(myseq.nextval,'wangpx5');
select * from testseq;
/*
索引是一种单独的,物理的对数据表中一列或者多列的值进行排序的数据结构
*/

/*
单列索引 :
  create index 索引名称 on 表名(列名)
  explain plan  执行计划 
*/
create index myindex on emp(deptno);
explain plan for select *  from emp where deptno = 10;
select * from table(dbms_xplan.display);