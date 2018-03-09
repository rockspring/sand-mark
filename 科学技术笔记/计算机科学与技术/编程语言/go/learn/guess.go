package main

import "fmt"

func main(){
	min,max :=1,100
	fmt.Println("请在心里想一个%d~%d之间的数让我来猜！\n",min, max)
	for min < max {
		i :=(min+max)/2
		fmt.Println("该数小于或等于%d吗？\n",i)
		var s string
		fmt.Scanf("%s",&s)
		if(s !="" && s[0]=='y'){
			max = i
		}else{
			min=i+1
		}
	}
	fmt.Println("你想的数是%d\n",max)
}