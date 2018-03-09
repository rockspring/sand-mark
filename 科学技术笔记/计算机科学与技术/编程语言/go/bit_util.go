package main

func pop_array(arr []int64, wordOffset int, numWords int) int64{
	var popCount int64 = 0

	for i := wordOffset; i < wordOffset + numWords; i++ {
		popCount += bitCount(arr[i])
	}

	return popCount
}

func bitCount(i int64) int64{
    // HD, Figure 5-14
    i = i - ((i >> 1) & 0x5555555555555555)
    i = (i & 0x3333333333333333) + ((i >> 2) & 0x3333333333333333)
    i = (i + (i >> 4)) & 0x0f0f0f0f0f0f0f0f
    i = i + (i >> 8)
    i = i + (i >> 16)
    i = i + (i >> 32)
    return int64(i & 0x7f)
 }