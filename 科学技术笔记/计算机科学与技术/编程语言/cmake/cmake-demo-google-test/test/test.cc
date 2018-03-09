//main.c
#include <stdio.h>
#include "gtest/gtest.h"

TEST(FactorialTest, HandlesZeroInput) {
    EXPECT_EQ(1, 1);
}


int main(int argc, char** argv)
{
    ::testing::InitGoogleTest(&argc, argv);
    printf("Hello GTest!\n");
    int result = RUN_ALL_TESTS();
    return result;
}