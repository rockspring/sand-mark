//
// Created by zlq on 5/25/15.
//

#include "number.h"

long lowestOneBit(long i) {
    return i & -i;
}

bool isOdd(long i) {
    long result = i>>0;
    for (int j = 1; j < 64; ++j) {
        result = result ^ i>>j;
    }

    return result==1;
}

int numberOfLeadingZero(int i) {
    int n = 0;

    if (i ==0) {
        n = 32;
        return n;
    }

    if (i >> 16 == 0) n += 16; i = i << 16;
    if (i >> 24 == 0) n += 8; i = i << 8;
    if (i >> 28 == 0) n += 4; i = i << 4;
    if (i >> 30 == 0) n += 2; i = i << 2;

    n = n + 1 - ((unsigned int)i >> 31);

    return n;
}
