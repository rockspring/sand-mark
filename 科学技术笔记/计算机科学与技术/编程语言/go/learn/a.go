package main

import (
	"fmt"
	"unicode/utf8"
)

func funA() {
    const placeOfInterest = `⌘`

    fmt.Printf("plain string: ")
    fmt.Printf("%s", placeOfInterest)
    fmt.Printf("\n")

    fmt.Printf("quoted string: ")
    fmt.Printf("%+q", placeOfInterest)
    fmt.Printf("\n")

    fmt.Printf("hex bytes: ")
    for i := 0; i < len(placeOfInterest); i++ {
        fmt.Printf("%x ", placeOfInterest[i])
    }
    fmt.Printf("\n")

}

func funB() {
	const x = "\xe6\xb1\x89\xe5\xad\x97"
	
	fmt.Println(x)

    for i := 0; i < len(x); i++ {
        fmt.Printf("%b ", x[i])
    }
    fmt.Printf("\n")

    for i := 0; i < len(x); i++ {
        fmt.Printf("%o ", x[i])
    }
    fmt.Printf("\n")

    for i := 0; i < len(x); i++ {
        fmt.Printf("%d ", x[i])
    }
    fmt.Printf("\n")

    for i := 0; i < len(x); i++ {
        fmt.Printf("%x ", x[i])
    }
    fmt.Printf("\n")

    fmt.Printf("% x\n", x)

    const sample = "\xbd\xb2\x3d\xbc\x20\xe2\x8c\x98"

    fmt.Printf("%q\n", sample)

    fmt.Printf("%+q\n", sample)

    fmt.Printf("%+q\n", x)

    for i := 0; i < len(sample); i++ {
        fmt.Printf("%p ", sample[i])
    }
    fmt.Printf("\n")
}

func funC() {
	//const nihongo = "日本語"
	const nihongo = "\xbd\xb2\x3d\xbc\x20\xe2\x8c\x98"
    for index, runeValue := range nihongo {
        fmt.Printf("%#U starts at byte position %d\n", runeValue, index)
    }
}

func funD() {
	const nihongo = "日本語"
    for i, w := 0, 0; i < len(nihongo); i += w {
        runeValue, width := utf8.DecodeRuneInString(nihongo[i:])
        fmt.Printf("%#U starts at byte position %d\n", runeValue, i)
        w = width
    }
}

func main() {
	funD()
}