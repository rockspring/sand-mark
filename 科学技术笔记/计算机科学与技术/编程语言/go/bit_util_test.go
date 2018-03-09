package main

import (
    "testing"
)

func Test_pop_array_1(t *testing.T) {

	var arr []int64 = []int64{1, 2, 4}
	count := pop_array(arr, 0, 3)
    if  count != 3 { //try a unit test on function
        t.Error("计算n个int64型整数中设置的位有多少个测试没通过") // 如果不是如预期的那么就报错
    } else {
        t.Log("计算n个int64型整数中设置的位有多少个测试通过了") //记录一些你期望记录的信息
    }
}