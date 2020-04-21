#include "gtest/gtest.h"

namespace {
    TEST(DemoTest, IntSize) {
        EXPECT_EQ(4, sizeof(int));
    }
}
