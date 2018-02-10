#!/bin/sh
#格式化现实生活日期  >> 为内容追加
/bin/date +%F >> /linux/linux02.info
echo "disk info" >> /linux/linux02.info
/bin/df -h >> /linux/linux02.info
echo "online users:" >> /linux/linux02.info
#-v 表示排除
/usr/bin/who | bin/grep -v root >> /linux/linux02.info
echo "memory info" >> /linux/linux02.info
/usr/bin/free -m >> /linux/linux02.info
echo >> /linux/linux02.info
#write root < 表示 重定向输入
/usr/bin/write root < /linux/linux02.info && /bin/rm /linux/linux02.info
# 定时执行任务 没周一到周五
#crontab  -e
#0 9 * * 1-5 /bin /sh /linux/linux02.sh

