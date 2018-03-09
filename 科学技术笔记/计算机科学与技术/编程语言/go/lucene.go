package main

import (
	//"io"
	"encoding/binary"
	"os"
	//"bytes"
	"fmt"
	//"math/big"
	//"encoding/gob"
	"bufio"
	"log"
)

func ByteToBits(b byte) string {
	var bits [8]int
	for i := 0; i < 8; i++ {
		bits[i] = int(b % 2)
		b = b / 2
	}
	//fmt.Println(bits)
	var a string
	for i := 0; i < 8; i++ {
		if bits[i] == 0 {
			a = "0" + a
		} else {
			a = "1" + a
		}
	}
	return a
}

func ReadGen() {
	fi, _ := os.Open("/Users/zlq/Servers/solr/solr-4.7.0/example/solr/collection1/data/index/segments.gen")
	buf := make([]byte, 1024)
	n, _ := fi.Read(buf)
	fmt.Println(n)
	//fmt.Println(buf[0:n])
	for i := 0; i < n; i++ {
		a := ByteToBits(buf[i])
		fmt.Println(a)
	}
}

func ReadSegments() {
	fi, _ := os.Open("/Users/zlq/Servers/solr/solr-4.7.0/example/solr/collection1/data/index/segments_1")
	buf := make([]byte, 1024)
	n, _ := fi.Read(buf)
	fmt.Println(n)
	fmt.Println(buf[0:n])

	fmt.Println(buf[0] >> 1)
}

func CatSegmentInfo() {
	file, _ := os.Open("/Users/zlq/Servers/solr/solr-4.7.0-demo/example/solr/collection1/data/index/_2.si")
	buf := make([]byte, 1024)
	n, _ := file.Read(buf)
	fmt.Print("file lenght:")
	fmt.Println(n)
	// Header
	fmt.Print("Magic:")
	fmt.Println(uint32(binary.BigEndian.Uint32(buf[0:4]))) // Magic 1071082519
	//fmt.Println(buf[4])
	fmt.Println("CodecName:" + string(buf[5:24])) // CodecName Lucene46SegmentInfo
	fmt.Print("segments version:")
	fmt.Println(uint32(binary.BigEndian.Uint32(buf[24:28]))) // Version
	//SegVersion String[lenght + string]
	//fmt.Print("string lenght:")
	//fmt.Println(buf[28])            // length
	fmt.Print("version:")
	fmt.Println(string(buf[29:32])) // version string
	fmt.Print("doc number:")
	fmt.Println(int32(binary.BigEndian.Uint32(buf[32:36]))) // doc number
	fmt.Print("is compound file:")
	fmt.Println(int(buf[36])) // is compound file
	// diagnostics
	var position int = 37
	ReadMapStringString(buf, &position)
	ReadSetStringSet(buf, &position)
	fmt.Println(position)

}

func ReadMapStringString(buf []byte, position *int) {
	var count int32 = int32(binary.BigEndian.Uint32(buf[*position : *position+4])) // string map count:
	*position += 4
	fmt.Print("Map String String count:")
	fmt.Println(count)
	var strLen int = 0
	for i := 0; i < int(count); i++ {
		strLen = ReadVInt(buf, position)
		//fmt.Print("string length:")
		//fmt.Println(strLen)
		fmt.Print("<")
		fmt.Print(string(buf[*position : *position+strLen])) // version string
		fmt.Print(", ")
		*position += strLen

		strLen = ReadVInt(buf, position)
		//fmt.Print("string length:")
		//fmt.Println(strLen)
		fmt.Print(string(buf[*position : *position+strLen])) // version string
		fmt.Println(">")
		*position += strLen
	}

}

func ReadSetStringSet(buf []byte, position *int) {
	var count int32 = int32(binary.BigEndian.Uint32(buf[*position : *position+4])) // string set count:
	*position += 4
	var strLen int = 0
	fmt.Print("String Set count:")
	fmt.Println(count)
	fmt.Print("(")
	for i := 0; i < int(count); i++ {
		strLen = ReadVInt(buf, position)
		//fmt.Print("string length:")
		//fmt.Println(strLen)
		fmt.Print(string(buf[*position : *position+strLen])) // version string
		fmt.Print(", ")
		*position += strLen
	}
	fmt.Println(")")
}

func ReadVInt(buf []byte, position *int) int {
	var b byte = buf[*position]
	*position++
	//fmt.Println(int(b))
	if b >= 0 {
		return int(b)
	}
	return 0
}

func CatSegmentsGen() {
	file, _ := os.Open("/Users/zlq/Servers/solr/solr-4.7.0-demo/example/solr/collection1/data/index/segments.gen")
	buf := make([]byte, 1024)
	n, _ := file.Read(buf)
	fmt.Print("file lenght:")
	fmt.Println(n)

	var position int = 0
	version := binary.BigEndian.Uint32(buf[position : position+4])
	fmt.Println(version)

	gen0 := binary.BigEndian.Uint64(buf[position : position+8])
	fmt.Println(gen0)

	gen1 := binary.BigEndian.Uint64(buf[position : position+8])
	fmt.Println(gen1)
}

// SegmentInfos.java
func CatSegmentsN() {
	file, _ := os.Open("/Users/zlq/Servers/solr/solr-4.7.0-demo/example/solr/collection1/data/index/segments_4")
	buf := make([]byte, 1024)
	n, _ := file.Read(buf)
	fmt.Print("file lenght:")
	fmt.Println(n)
	var position int = 0
	format := ReadInt(buf, &position)
	fmt.Println(format)
	actualCodec := ReadString(buf, &position)
	fmt.Println(actualCodec)
	actualVersion := ReadInt(buf, &position)
	fmt.Println(actualVersion)
	version := ReadLong(buf, &position)
	fmt.Println(version)
	counter := ReadInt(buf, &position)
	fmt.Print("counter:")
	fmt.Println(counter)
	numSegements := ReadInt(buf, &position)
	fmt.Println(numSegements)
	for i := 0; i < numSegements; i++ {
		segName := ReadString(buf, &position)
		fmt.Println(segName)
		codec := ReadString(buf, &position)
		fmt.Println("codec" + codec)
		delGen := ReadLong(buf, &position)
		fmt.Println(delGen)
		delCount := ReadInt(buf, &position)
		fmt.Println(delCount)
		fieldInfosGen := ReadLong(buf, &position)
		fmt.Println(fieldInfosGen)
		numGensUpdatesFiles := ReadInt(buf, &position)
		fmt.Printf("numGensUpdatesFiles:%d\n", numGensUpdatesFiles)
		ReadMapStringString(buf, &position)
		checksumThen := ReadLong(buf, &position)
		fmt.Printf("checksumThen:%d\n", checksumThen)

	}
	fmt.Printf("file position:%d\n", position)
}

/** Reads eight bytes and returns a long.
 * @see DataOutput#writeLong(long)
 */
func ReadLong(buf []byte, position *int) int64 {
	//return (((long)readInt()) << 32) | (readInt() & 0xFFFFFFFFL)
	a := ReadInt(buf, position)
	b := ReadInt(buf, position)
	return (int64(a)&0xFFFFFFFF)<<32 | (int64(b) & 0xFFFFFFFF)
	//return 0
}

func ReadInt(buf []byte, position *int) int {
	a := ReadByte(buf, position)
	//fmt.Println(a)
	b := ReadByte(buf, position)
	//fmt.Println(b)
	c := ReadByte(buf, position)
	//fmt.Println(c)
	d := ReadByte(buf, position)
	//fmt.Println(d)
	return (int(a)&0xFF)<<24 | (int(b)&0xFF)<<16 | (int(c)&0xFF)<<8 | (int(d) & 0xFF)
}

func ReadString(buf []byte, position *int) string {
	var strLen int = 0
	strLen = ReadVInt(buf, position)
	str := string(buf[*position : *position+strLen])
	*position += strLen
	return str
}

func ReadByte(buf []byte, position *int) byte {
	*position++
	return buf[*position-1]
}

// Lucene46FieldInfosReader.java
func CatFieldInfos() {
	file, _ := os.Open("/Users/zlq/Servers/solr/solr-4.7.0-demo/example/solr/collection1/data/index/_2.fnm")
	buf := make([]byte, 1024)
	n, _ := file.Read(buf)
	fmt.Print("file lenght:")
	fmt.Println(n)
	var position int = 0
	ReadFieldInfosCodecHeader(buf, &position)
	size := ReadVInt(buf, &position)
	fmt.Printf("size: %d\n", size)
	for i := 0; i < size; i++ {
		name := ReadString(buf, &position)
		fmt.Printf("name: %s\n", name)
		fieldNumber := ReadVInt(buf, &position)
		fmt.Printf("fieldNumber: %s\n", fieldNumber)

		bits := ReadByte(buf, &position)
		fmt.Printf("bits: %s\n", ByteToBits(bits))
		val := ReadByte(buf, &position)
		fmt.Printf("val: %s\n", ByteToBits(val))
		dvGen := ReadLong(buf, &position)
		fmt.Printf("dvGen: %d\n", dvGen)
		ReadMapStringString(buf, &position)
	}
	fmt.Printf("file position:%d\n", position)
}

func ReadFieldInfosCodecHeader(buf []byte, position *int) {
	actualHeader := ReadInt(buf, position)
	fmt.Printf("actualHeader: %d\n", actualHeader)
	actualCodec := ReadString(buf, position)
	fmt.Printf("actualCodec: %s\n", actualCodec)
	actualVersion := ReadInt(buf, position)
	fmt.Printf("actualVersion: %d\n", actualVersion)
}

// CompressingStoredFieldsWriter --> StoredFieldsWriter
// _2.fdx
func CatFieldData() {
	file, _ := os.Open("/Users/zlq/Servers/solr/solr-4.7.0-demo/example/solr/collection1/data/index/_2.fdt")
	buf := make([]byte, 1024)
	n, _ := file.Read(buf)
	fmt.Print("file lenght:")
	fmt.Println(n)
	var position int = 0
	ReadFieldInfosCodecHeader(buf, &position)
	numFields := ReadVInt(buf, &position)
	fmt.Printf("numFields: %d\n", numFields)
}

// CompressingStoredFieldsWriter --> StoredFieldsWriter
// _2.fdx
func CatFieldIndexData() {
	file, _ := os.Open("/Users/zlq/Servers/solr/solr-4.7.0-demo/example/solr/collection1/data/index/_2.fdx")
	buf := make([]byte, 1024)
	n, _ := file.Read(buf)
	fmt.Print("file lenght:")
	fmt.Println(n)
	var position int = 0
	ReadFieldInfosCodecHeader(buf, &position)
	packedIntsVersion := ReadVInt(buf, &position)
	fmt.Printf("packedIntsVersion: %d\n", packedIntsVersion)

	numChunks := ReadVInt(buf, &position)
	fmt.Printf("numChunks: %d\n", numChunks)

	DocBase := ReadVInt(buf, &position)
	fmt.Printf("DocBase: %d\n", DocBase)

	AvgChunkDocs := ReadVInt(buf, &position)
	fmt.Printf("AvgChunkDocs: %d\n", AvgChunkDocs)
}

// CompressingTermVectorsWriter --> TermVectorsWriter
// VECTORS_EXTENSION: tvd
// VECTORS_INDEX_EXTENSION: tvx
func func_name() {

}

type DataInput interface {
	ReadByte() byte
	ReadBytes(b []byte, offset int, len int)
}

type IndexInput struct {
	bufferedReader *bufio.Reader
}

func NewIndexInput(path string) *IndexInput {
	file, error := os.Open(path)

	if error != nil {
		log.Fatal(error)
	}
	in := new(IndexInput)
	in.bufferedReader = bufio.NewReader(file)

	return in
}

func (in *IndexInput) ReadByte() byte {
	b, error := in.bufferedReader.ReadByte()
	if error != nil {
		log.Fatal(error)
	}

	return b
}

func (in *IndexInput) ReadBytes(length int) []byte {
	var s []byte = make([]byte, length)
	for i := 0; i < length; i++ {
		b, error := in.bufferedReader.ReadByte()
		if error != nil {
			log.Fatal(error)
		}
		s[i] = b
	}

	return s
}

func (in *IndexInput) ReadInt16() int16 {
	a := in.ReadByte()
	b := in.ReadByte()
	return (int16(a)&0xFF)<<8 | (int16(b) & 0xFF)
}

func (in *IndexInput) ReadInt32() int32 {
	a := in.ReadByte()
	b := in.ReadByte()
	c := in.ReadByte()
	d := in.ReadByte()
	return (int32(a)&0xFF)<<24 | (int32(b)&0xFF)<<16 | (int32(c)&0xFF)<<8 | (int32(d) & 0xFF)
}

func (in *IndexInput) ReadVInt32() int32 {
	var stop bool = false
	var i int32 = 0
	b := in.ReadByte()
	if b >= 0 {
		stop = true
		i = int32(b)
	}
	if !stop {
		i = int32(b) & 0x7F
		b = in.ReadByte()
		i = i | (int32(b)&0x7F)<<7

		if b >= 0 {
			stop = true
		}
	}
	if !stop {
		b = in.ReadByte()
		i = i | (int32(b)&0x7F)<<14

		if b >= 0 {
			stop = true
		}
	}
	if !stop {
		b = in.ReadByte()
		i = i | (int32(b)&0x7F)<<21

		if b >= 0 {
			stop = true
		}
	}
	if !stop {
		b = in.ReadByte()
		i = i | (int32(b)&0x0F)<<28

		if b&0xF0 == 0 {
			stop = true
		} else {
			log.Fatal("too many bytes")
		}
	}
	return i
}

func (in *IndexInput) ReadInt64() int64 {
	a := in.ReadInt32()
	b := in.ReadInt32()

	return (int64(a) & 0xFFFFFFFF << 32) | int64(b)&0xFFFFFFFF
}

func (in *IndexInput) ReadVInt64() int64 {
	var stop bool = false
	var i int64 = 0
	b := in.ReadByte() // byte 1

	if b >= 0 {
		stop = true
		i = int64(b)
	}
	if !stop {
		i = int64(b) & 0x7F
		b = in.ReadByte() // byte 2
		i = i | (int64(b)&0x7F)<<7
		if b >= 0 {
			stop = true
		}
	}
	if !stop {
		b = in.ReadByte() // byte 3
		i = i | (int64(b)&0x7F)<<14

		if b >= 0 {
			stop = true
		}
	}
	if !stop {
		b = in.ReadByte() // byte 4
		i = i | (int64(b)&0x7F)<<21

		if b >= 0 {
			stop = true
		}
	}
	if !stop {
		b = in.ReadByte() // byte 5
		i = i | (int64(b)&0x7F)<<28

		if b >= 0 {
			stop = true
		}
	}
	if !stop {
		b = in.ReadByte() // byte 6
		i = i | (int64(b)&0x7F)<<35

		if b >= 0 {
			stop = true
		}
	}
	if !stop {
		b = in.ReadByte() // byte 7
		i = i | (int64(b)&0x7F)<<42

		if b >= 0 {
			stop = true
		}
	}
	if !stop {
		b = in.ReadByte() // byte 8
		i = i | (int64(b)&0x7F)<<49

		if b >= 0 {
			stop = true
		}
	}
	if !stop {
		b = in.ReadByte() // byte 9
		i = i | (int64(b)&0x7F)<<56

		if b >= 0 {
			stop = true
		} else {
			log.Fatal("too many bytes")
		}
	}

	return i
}

func (in *IndexInput) ReadString() string {
	strLen := in.ReadVInt32()
	return string(in.ReadBytes(int(strLen)))
}

func (in *IndexInput) ReadStringStringMap() map[string]string {
	stringString := make(map[string]string)
	var count int = int(in.ReadInt32())
	for i := 0; i < count; i++ {
		key := in.ReadString()
		val := in.ReadString()
		stringString[key] = val
	}

	return stringString
}

func (in *IndexInput) ReadStringSet() []string {
	var count int = int(in.ReadInt32())
	var stringSet []string = make([]string, count)
	for i := 0; i < int(count); i++ {
		val := in.ReadString()
		stringSet[i] = val
	}
	return stringSet
}

func TestIndexInput() {
	filePath := "/Users/zlq/Servers/solr/solr-4.7.0-demo/example/solr/collection1/data/index/_2.fdx"
	indexInput := NewIndexInput(filePath)

	actualHeader := indexInput.ReadInt32()
	fmt.Printf("actualHeader: %d\n", actualHeader)
	actualCodec := indexInput.ReadString()
	fmt.Printf("actualCodec: %s\n", actualCodec)
	actualVersion := indexInput.ReadInt32()
	fmt.Printf("actualVersion: %d\n", actualVersion)

	packedIntsVersion := indexInput.ReadVInt32()
	fmt.Printf("packedIntsVersion: %d\n", packedIntsVersion)

	numChunks := indexInput.ReadVInt32()
	fmt.Printf("numChunks: %d\n", numChunks)

	DocBase := indexInput.ReadVInt32()
	fmt.Printf("DocBase: %d\n", DocBase)

	AvgChunkDocs := indexInput.ReadVInt32()
	fmt.Printf("AvgChunkDocs: %d\n", AvgChunkDocs)
}

func CatSegmentInfoNew(path string) {
	in := NewIndexInput(path)

	// Header
	fmt.Printf("Magic:%d\n", in.ReadInt32()) // Magic 1071082519
	fmt.Printf("CodecName:%s\n", in.ReadString()) // CodecName Lucene46SegmentInfo
	fmt.Printf("Segments version:%d\n", in.ReadInt32())

	fmt.Printf("version:%s\n", in.ReadString()) // version string
	fmt.Printf("doc number:%d\n", in.ReadInt32()) // doc number
	fmt.Printf("is compound file:%d\n", in.ReadByte()) // is compound file
	// diagnostics
	fmt.Println(in.ReadStringStringMap())
	fmt.Println(in.ReadStringSet())
}

func TestCatSegmentInfo() {
	path := "/Users/zlq/Servers/solr/solr-4.7.0-demo/example/solr/collection1/data/index/_2.si"
	CatSegmentInfoNew(path)
}

func main() {
	//ReadGen()
	//ReadSegments()
	CatSegmentInfo()
	fmt.Println("......................................")
	TestCatSegmentInfo()
	//CatSegmentsGen()
	//CatSegmentsN()
	//CatFieldInfos()
	//CatFieldData()
	//CatFieldIndexData()
	//a := 0x3fd76c17
	//fmt.Println(a)
	//b := 0xFFFFFFFF
	//fmt.Println(b)
	//TestIndexInput()
}
