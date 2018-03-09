package main

import (
	"bufio"
	"fmt"
	//"io/ioutil"
	//"net/http"
	"net/url"
	"os"
	//"time"
	//"reflect"
)


func main() {
	args := os.Args
	if len(args) < 2 {
		fmt.Println("Input file is missing.")
		os.Exit(1)
	}
	fi, _ := os.Open(args[1])

	reader := bufio.NewReader(fi)

	for {
		line, err := reader.ReadBytes('\n')

		if err != nil {
			fmt.Println("err")
			os.Exit(1)
		}
		if line == nil {
			fmt.Println("nil line")
			continue
		}
		l, _ := url.QueryUnescape(string(line[0 : len(line)-1]))
		//fmt.Println(reflect.TypeOf(l).Kind())
		//fmt.Println(l)
		r := []rune(l)
		var qStart int
		//var qEnd int
		var stat int =0
		for k,v := range(l) {
			//fmt.Println(k)
			//fmt.Println(string(v))
			if stat == 0 {
				if v == 'q' && l[k-1] == '&'{
					qStart = k
					stat = 1
					//fmt.Println("q maybe begin")
				}
			} else if stat == 1 {

				if v == '=' && (qStart+1) == k{
					stat = 2
					//fmt.Println("q begin")
				} else {
					stat = 0
				}

			} else if stat == 2 {
				//fmt.Print(string(v))
				if v == '&' {
					//fmt.Println("q end")
					stat =0
					continue
				}

				if v == ':' {
					r[k] = ' '
					//fmt.Println(":::::::::::::::::::::::::::::::::::::::::::::::")
				}
			}
		}
		fmt.Println(string(r))
		//go selectSolr(string(line[0 : len(line)-1]))
		//time.Sleep(time.Millisecond * 5)
	}
	var input string
	fmt.Scanln(&input)
	fmt.Println("done")
}