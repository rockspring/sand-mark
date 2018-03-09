//
// Created by zlq on 5/25/15.
//

#ifndef CPP_STUDY_BIT_H
#define CPP_STUDY_BIT_H

#include <cache.h>

class Bits
{
public:
    virtual bool get(int index) = 0;
    virtual int length() = 0;
    class MatchAllBits;
    class MatchNoBits;
};

class Bits::MatchAllBits : Bits {
private:
    int len;
public:
    MatchAllBits(int len) {
        this->len = len;
    }
    bool get(int index) {
        return true;
    }
    int length() {
        return this->len;
    }
};

class Bits::MatchNoBits : Bits {
private:
    int len;
public:
    MatchNoBits(int len) {
        this->len = len;
    }
    bool get(int index) {
        return false;
    }
    int length() {
        return this->len;
    }
};

class MutableBits : Bits
{
public:
    virtual void clear(int index) = 0;

    /* data */
};

class BitSet : MutableBits
{
public:
    BitSet(){};
    ~BitSet(){};

    virtual void set(int i) = 0;

    virtual void clear(int startIndex, int endIndex) = 0;

    virtual int cardinality() = 0;

    int approximateCardinality() {
        return cardinality();
    }

    virtual int prevSetBit(int index) = 0;

    virtual int nextSetBit(int index) = 0;

    /* data */
};

class FixedBitSet : BitSet
{
public:
    FixedBitSet(int numBits);
    ~FixedBitSet();
    int bits2words(int numBits);
    void set(int index);
    bool get(int index);
    void clear(int index);
    void clear(int startIndex, int endIndex);
    int cardinality();
    int prevSetBit(int index);
    int nextSetBit(int index);

private:
    long * bits;
    int numBits;
    int numWords;
};

#endif //CPP_STUDY_BIT_H
