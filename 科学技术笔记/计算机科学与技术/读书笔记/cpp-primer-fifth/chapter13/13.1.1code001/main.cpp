#include <iostream>
//#include <cinttypes>
#include <cstdio>
#include <cfloat>

using namespace std;

class Foo {
    public:
    Foo(){cout << "Foo" << endl;};
    Foo(const Foo&){ cout << "Foo(const Foo&)" << endl;};
    Foo& operator=(const Foo&) {cout << "Foo& operator=(const Foo&)" << endl; return *this;};
};

class Sales_data {
public:
    Sales_data() = default;
    Sales_data(const Sales_data&);

private:
    std::string bookNo;
    int units_sold = 0;
    double revenue = 0.0;
};

Sales_data::Sales_data(const Sales_data &orig):bookNo(orig.bookNo), units_sold(orig.units_sold), revenue(orig.revenue) {
    cout << "Sales_data复制构造函数" << endl;
}

int main() {
    Foo a;
    Foo b = a;
    b = a;
    b = a;

    Sales_data sales_data1;

    Sales_data sales_data2 = sales_data1;

    cout << sizeof(char *) << endl;

    int16_t c = 100;

    cout << INT64_MAX << endl;

    cout << 1 % -2 << endl;
    cout << "-3 % 4=" << (-3) % -4 << endl;

    int d =1U;

    printf("0x%x", 100);

    unsigned e = 0;
    cout << e - (unsigned)1 << endl;

    cout << FLT_MIN << endl;
    cout << sizeof(0.2f) << endl;
    cout << FLT_MIN_EXP << endl;
    cout << FLT_MIN_10_EXP << endl;
    cout << DBL_MIN_10_EXP << endl;

    return 0;
}