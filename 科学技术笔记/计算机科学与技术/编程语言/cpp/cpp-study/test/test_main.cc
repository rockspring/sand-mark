/**
 * Author: leqinzhou
 * Date: 2015-05-24
 *
 * This is a simple test study program.
 */

#include <iostream>
#include "gtest/gtest.h"

using std::cout;
using std::endl;

TEST(HelloGTestCase, HelloGTest) {
    EXPECT_EQ(0, 0);
}

int main(int argc, char **argv) {
    ::testing::InitGoogleTest(&argc, argv);
    cout << "Hello GTest!" << endl;
    int result = RUN_ALL_TESTS();
    return result;
}