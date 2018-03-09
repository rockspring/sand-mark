package main

import (
	"fmt"
)

func main() {
	x := [...]int{1, 2, 3}
	for i,j := range x {
		fmt.Println(i,j)
	}
}
