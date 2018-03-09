/**
 * Author: leqinzhou
 * Date: 2015-05-24
 *
 * This is a simple test study program.
 */

#include <iostream>
#include "gtest/gtest.h"
#include "bit.h"
#include "number.h"

using std::cout;
using std::endl;

TEST(HelloGTestCase, HelloGTest) {
    EXPECT_EQ(0, 0);
}

TEST(BitsTestCase, BitsTest) {
    FixedBitSet *bits = new FixedBitSet(100);
    bits->set(66);
    bool isSet = bits->get(66);
    EXPECT_EQ(true, isSet);

    Bits * bitsA = (Bits *)bits;
    isSet=bitsA->get(66);
    EXPECT_EQ(true, isSet);
}

TEST(NumberTestCase, NumberisOddTest) {
    long i = 0;
    EXPECT_EQ(false, isOdd(i));

    i = 1;
    EXPECT_EQ(true, isOdd(i));

    i = 2;
    EXPECT_EQ(false, isOdd(i));
}

TEST(NumberTestCase, NumberLeadingZeroTest) {
    EXPECT_EQ(32, numberOfLeadingZero(0));
    EXPECT_EQ(31, numberOfLeadingZero(1));
    EXPECT_EQ(30, numberOfLeadingZero(2));
}

int main(int argc, char **argv) {
    ::testing::InitGoogleTest(&argc, argv);
    cout << "Hello GTest!" << endl;
    int result = RUN_ALL_TESTS();
    return result;
}