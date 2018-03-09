//main.c
#include <iostream>
#include <stdio.h>
#include "gtest/gtest.h"
//#include <limits>

#include "hello/Hello.h"

#include "hello/shape.h"

using namespace std;

TEST(FactorialTest, HandlesZeroInput) {
    EXPECT_EQ(1, 1);
}

void shape() {
    Rectangle Rect;
    Triangle  Tri;

    Rect.setWidth(5);
    Rect.setHeight(7);
    // Print the area of the object.
    cout << "Total Rectangle area: " << Rect.getArea() << endl;

    Tri.setWidth(5);
    Tri.setHeight(7);
    // Print the area of the object.
    cout << "Total Triangle area: " << Tri.getArea() << endl;
}


int main(int argc, char** argv)
{

    sayHello();
    printSub();
    shape();

    return 0;
}
