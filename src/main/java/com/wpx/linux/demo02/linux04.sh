#!/bin/sh
DATE=`/bin/date +%F`
echo "today is $DATE"
#这个程序的参数个数
echo '$# :' $#
#这个程序的所有参数
echo '$* :' $*
#执行上一个程序的返回值
echo '$? :' $?
#这个程序的PID
echo '$$ :' $$
#$(0-9) 显示位置变量
echo '$0 :' $0
