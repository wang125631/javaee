/*
创建表
*/
create table test1(
  tid number,
  tname varchar(20)
);
/*
rowid 行地址
*/
select rowid,empno,ename,sal
from emp;

select *
from emp
where rowid='AAAMfPAAEAAAAAgAAH';
/*
新创建员工表,保存20号部门员工
*/
create table emp20
as
select * 
from emp 
where deptno =20;
/*
创建表: 员工号,姓名,月薪,年薪,部门名称
*/
create table empinfo
as 
select e.EMPNO,e.ENAME,e.SAL,e.SAL*12 annsal,d.DNAME
from emp e,dept d
where
e.deptno=d.deptno;

select *
from empinfo;
/*
增加新列
*/
alter table test1 add photo blob;
desc test1;
/*
修改列
*/
alter table test1 modify tname varchar2(40);
/*
删除列
*/
alter table test1 drop column photo;
desc test1;
/*
重命名列
*/
alter table test1 rename column tname to tusername;
desc test1;
/*
重命名表
*/
rename test1 to test01;
desc test01;
/*
删除表
*/
select * from tab;
drop table emp10;
/*
查看回收站
*/
show recyclebin;
/*
清空回收站
管理员没有回收站
*/
purge recyclebin;