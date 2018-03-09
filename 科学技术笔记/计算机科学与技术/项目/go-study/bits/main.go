package main

import (
	"fmt"
	"reflect"
	"unsafe"
)

func test() {
	var a int16 = 0x01 + int16(2)
	var b uint16 = (uint16(a) & 0xFFFF) << 8
	fmt.Printf("a=%d\n", a)
	fmt.Printf("b=%d\n", b)
	fmt.Printf("type of a is %s\n", reflect.TypeOf(a))
	fmt.Printf("size of a is %d\n", unsafe.Sizeof(a))

	var c int8 = -1

	fmt.Printf("c= %d, c >> 1 = %d\n", c, uint8(c)&0x0F)
}

func main() {
	test()
}
