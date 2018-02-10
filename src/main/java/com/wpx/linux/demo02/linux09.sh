#!/bin/sh
#select var in [param] do .. done
select var in "java" "c" "c++" "python" "ruby" "php"
do 
	break
done
echo "you selected $var"

