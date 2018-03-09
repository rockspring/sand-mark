array=(1 2 3)

echo $array

echo ${array[0]}


输出整个数组，元素之间用空格隔开

```
echo ${array[@]}

echo ${array[*]}
```

数组切片

echo ${array[@]:0:1}

:后的第一个数值为切片在数组中的起始索引，第二个数值代表切片的长度


获取数组的长度

echo ${#array[@]}


依次输出数组的每个元素
for ((i=0; i < ${#array[@]}; i++));do echo ${array[i]};done


往数组插入一个新元素

e=100

array=(${array[@]} $e)

删除数组的最后一个元素

array=(${array[@]:0:$((${#array[@]}-1))})

删除数组的第一个元素

array=(${array[@]:1})



NAME[0]="Zara"
NAME[1]="Qadir"
NAME[2]="Mahnaz"
NAME[3]="Ayan"
NAME[4]="Daisy"
