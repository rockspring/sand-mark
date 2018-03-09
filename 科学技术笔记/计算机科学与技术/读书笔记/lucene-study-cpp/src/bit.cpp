//
// Created by zlq on 5/25/15.
//

#include "bit.h"

int FixedBitSet::bits2words(int numBits) {
    int numLong = numBits >> 6;

    if ((numBits & 63) !=0) {
        numLong++;
    }

    return numLong;
}

FixedBitSet::FixedBitSet(int numBits) {
    this->numBits = numBits;
    this->bits = new long[bits2words(numBits)];
    this->numWords = sizeof(this->bits) / sizeof(this->bits[0]);
}

FixedBitSet::~FixedBitSet() {
    delete(this->bits);
}

void FixedBitSet::set(int index) {
    int wordNum = index >> 6;
    long bitmask = 1 << index;
    this->bits[wordNum] |= bitmask;
}

bool FixedBitSet::get(int index) {
    int i = index >> 6;
    long bitmask = 1 << index;

    return (this->bits[i] & bitmask) != 0;
}

void FixedBitSet::clear(int index) {
}

int FixedBitSet::cardinality() {
    return 0;
}

void FixedBitSet::clear(int startIndex, int endIndex) {
}

int FixedBitSet::nextSetBit(int index) {
    return 0;
}

int FixedBitSet::prevSetBit(int index) {
    return 0;
}