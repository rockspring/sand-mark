package main

import (
	"bufio"
	"fmt"
	"io/ioutil"
	"net/http"
	//"net/url"
	"os"
	"time"
)

func selectSolr(url string) {
	start := time.Now()
	response, _ := http.Get("http://10.10.6.12:8989" + url)
	end := time.Now()
	fmt.Println(end.Sub(start))
	if response == nil {
		fmt.Println("response == nil")
	} else {
		defer response.Body.Close()
		fmt.Println(url)
		//ioutil.ReadAll(response.Body)
		line, _ := ioutil.ReadAll(response.Body)
		fmt.Println(string(line))
	}
}

func main() {
	args := os.Args
	if len(args) < 2 {
		fmt.Println("Input file is missing.")
		os.Exit(1)
	}
	fi, _ := os.Open(args[1])

	reader := bufio.NewReader(fi)

	for {
		for j := 0; j < 2; j++ {
			line, err := reader.ReadBytes('\n')

			if err != nil {
				fmt.Println("err")
				os.Exit(1)
			}
			if line == nil {
				fmt.Println("nil line")
				continue
			}
			//l, _ := url.QueryUnescape(string(line[0 : len(line)-1]))
			//fmt.Println(l)
			go selectSolr(string(line[0 : len(line)-1]))
		}
		time.Sleep(time.Millisecond * 10)
	}
	var input string
	fmt.Scanln(&input)
	fmt.Println("done")
}