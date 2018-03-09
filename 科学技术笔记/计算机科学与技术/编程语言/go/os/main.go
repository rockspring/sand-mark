package main

import (
	"fmt"
	"os"
)

func printEnv() {
	envs := os.Environ()
	for _, env := range envs {
		fmt.Println(env)
	}
}

func testExpand() {
	s := "$PATH"
	newS := os.Expand(s,os.Getenv)
	fmt.Println(newS)

	s = "${PATH}"
	newS = os.Expand(s,os.Getenv)
	fmt.Println(newS)
}

func test() {
	var dir string
	dir = "/tmp"
	err := os.Chdir(dir)
	if err != nil {
		fmt.Println(err)
	} else {
		fmt.Println("change dir to ", dir)
	}

	fmt.Println(os.ModeDir | 0555 | os.ModeAppend | os.ModeType)

}

func main() {
	testExpand()
}
