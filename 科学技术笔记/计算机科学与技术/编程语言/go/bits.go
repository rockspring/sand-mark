package main

type FixedBitSet struct {
	bits     []int64
	numBits  int
	numWords int
}

func NewFixedBitSet(numBits int) *FixedBitSet {
	numWords := bits2words(numBits)
	bits := make([]int64, numWords)
	return &FixedBitSet{bits, numBits, numWords}
}

func bits2words(numBits int) int {
	numLong := numBits >> 6

	if (numBits & 63) != 0 {
		//numLong = numLong + 1
		numLong++
	}

	return numLong
}

func (self *FixedBitSet) length() int {
	return self.numBits
}

func (self *FixedBitSet) getBits() []int64 {
	return self.bits
}

func (self *FixedBitSet) set(index uint) {
	wordNum := index >> 6

	// 1 << 2 => 100
	// 1 << 63 =>  1000...000
	// 1 << 64 =>  0000...001
	bitmask := 1 << index
	self.bits[wordNum] |= int64(bitmask)
}

func (self *FixedBitSet) get(index uint) bool {
	wordNum := index >> 6

	// 1 << 2 => 100
	// 1 << 63 =>  1000...000
	// 1 << 64 =>  0000...001
	bitmask := 1 << index
	if (self.bits[wordNum] & int64(bitmask)) != 0 {
		return true
	} else {
		return false
	}
}
