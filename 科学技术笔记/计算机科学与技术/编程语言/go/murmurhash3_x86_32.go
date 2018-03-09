package main

import "fmt"
import "strconv"
import "encoding/binary"

func main() {
	fmt.Println("Hello, World!")
	//murmur3_32("abcd", 4 ,0)
	murmur3_32("abcde", 5 ,0)
	murmur3_32("abcdef", 6 ,0)
	murmur3_32("abcdefg", 7 ,0)
}

func murmur3_32(key string, length uint32, seed uint32) {
	fmt.Println(key)
	var c1 uint32 = 0xcc9e2d51
	var c2 uint32 = 0x1b873593
	var r1 uint32 = 15
	var r2 uint32 = 13
	var m uint32 =5
	var n uint32 = 0xe6546b64

	var blocks int = int(length/4)

	var hash uint32 = seed

	var i int

	for i = 0; i < blocks; i++ {
		/**
		*uint32_t k = blocks[i];
		k *= c1;
		k = (k << r1) | (k >> (32 - r1));
		k *= c2;
 
		hash ^= k;
		hash = ((hash << r2) | (hash >> (32 - r2))) * m + n;
		*/
		fmt.Println("loop",i)

		//var k []byte = []byte(key[i*4:4])

		//var k uint32 = uint32([]byte(key[i*4:4]))
		var k uint32

		//var tmp uint64

		//tmp, _ = strconv.ParseUint(key[i*4:4], 10, 32)

		//k = uint32(tmp)
		fmt.Println("k:", k)

		k = binary.LittleEndian.Uint32([]byte(key[i*4:4]))

		k *= c1

		k = (k << r1) | (k >> (32-r1))

		k *= c2

		hash ^= k

		hash = ((hash << r2) | (hash >> (32 - r2))) * m + n

		fmt.Println("hash:", hash)

		
		fmt.Println(key[i*4:4])
		fmt.Println("k:", k)
	}

	/*
	const uint8_t *tail = (const uint8_t *) (key + nblocks * 4);
	uint32_t k1 = 0;
 
	switch (len & 3) {
	case 3:
		k1 ^= tail[2] << 16;
	case 2:
		k1 ^= tail[1] << 8;
	case 1:
		k1 ^= tail[0];
 
		k1 *= c1;
		k1 = (k1 << r1) | (k1 >> (32 - r1));
		k1 *= c2;
		hash ^= k1;
	}
	*/

	fmt.Println("key[0:]",key[0:])

	fmt.Println(key[i*4:])

	var tail []byte  = []byte(key[i*4:])

	//var tailInt, k1 uint32
	var k1 uint32

	fmt.Println("case:", (length & 3))

	fmt.Println("tail:", key[i*4:])

	fmt.Println("tail:", tail[0:])



	switch (length & 3) {
	case 3:
		fmt.Println("tail[2]:", tail[2])
		//tailInt = binary.LittleEndian.Uint32(tail[2:3] & 0xffff)
		k1 ^= (uint32(tail[2]) & 0xffff) << 16

		k1 ^= (uint32(tail[1]) & 0xffff) << 8

		k1 ^= uint32(tail[0]) & 0xffff

		fmt.Println("k1:", k1)
		k1 *= c1
		fmt.Println("k1:", k1)
		k1 = (k1 << r1) | (k1 >> (32 - r1))
		k1 *= c2
		hash ^= k1

	case 2:
		fmt.Println("tail[1]:", tail[1])
		//tailInt = binary.LittleEndian.Uint32(tail[1:2] & 0xffff)
		k1 ^= (uint32(tail[1]) & 0xffff) << 8

		k1 ^= uint32(tail[0]) & 0xffff

		fmt.Println("k1:", k1)
		k1 *= c1
		fmt.Println("k1:", k1)
		k1 = (k1 << r1) | (k1 >> (32 - r1))
		k1 *= c2
		hash ^= k1

	case 1:
		/*
		k1 ^= tail[0];
 
		k1 *= c1;
		k1 = (k1 << r1) | (k1 >> (32 - r1));
		k1 *= c2;
		hash ^= k1;
		*/
		tail_new := []byte{}
		//tail = append(tail, tail[0])
		
		
		
		//tail_new = append(tail_new, 0)
		//tail_new = append(tail_new, 0)
		//tail_new = append(tail_new, 0)
		//tail_new = append(tail_new, tail[0])
		//tailInt = binary.LittleEndian.Uint32(tail[0])

		fmt.Println("tail_new:", tail_new)

		//tailInt = binary.LittleEndian.Uint32(tail[0] & 0xffff)

		k1 ^= uint32(tail[0]) & 0xffff

		fmt.Println("k1:", k1)
		k1 *= c1
		fmt.Println("k1:", k1)
		k1 = (k1 << r1) | (k1 >> (32 - r1))
		k1 *= c2
		hash ^= k1
		
	}


	/*
	hash ^= len;
	hash ^= (hash >> 16);
	hash *= 0x85ebca6b;
	hash ^= (hash >> 13);
	hash *= 0xc2b2ae35;
	hash ^= (hash >> 16);
	*/

	hash ^= length
	hash ^= (hash >> 16)
	hash *= 0x85ebca6b
	hash ^= (hash >> 13)
	hash *= 0xc2b2ae35
	hash ^= (hash >> 16)

	fmt.Println("hash:", hash)

	fmt.Println("hash binary:", strconv.FormatInt(int64(hash), 2))

	fmt.Println("blocks:", blocks)

	fmt.Println(c1)
	fmt.Println(c2)
	fmt.Println(r1)
	fmt.Println(r2)
	fmt.Println(m)
	fmt.Println(n)
	fmt.Println(hash)

	fmt.Println(len(key))

}