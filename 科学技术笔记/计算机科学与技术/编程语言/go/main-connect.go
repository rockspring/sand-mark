package main

import (
	//"bufio"
	"fmt"
	"io/ioutil"
	"net/http"
	//"net/url"
	//"os"
	"time"
)

func selectSolr() {
	start := time.Now()
	response, _ := http.Get("http://192.168.33.10:8983/solr/select?q=*:*")
	end := time.Now()
	fmt.Println(end.Sub(start))
	if response == nil {
		fmt.Println("response == nil")
	} else {
		//defer response.Body.Close()
		//fmt.Println(url)
		//ioutil.ReadAll(response.Body)
		line, _ := ioutil.ReadAll(response.Body)
		fmt.Println(string(line))
	}
}

func main() {
	for i := 0; i < 1000; i++{
		for j := 0; j < 500; j++ {
			go selectSolr()
		}
		time.Sleep(time.Millisecond * 10)
	}
	var input string
	fmt.Scanln(&input)
	fmt.Println("done")
}