#!/bin/sh
#if test $1 then ...else fi
num1=$[2*3]
num2=$[3+3]
if test $[num1] -eq $[num2]
then 
	echo "eq"
else 
	echo "not eq"
fi

