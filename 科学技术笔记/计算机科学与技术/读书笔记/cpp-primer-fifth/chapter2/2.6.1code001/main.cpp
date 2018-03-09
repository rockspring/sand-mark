#include <iostream>

using namespace std;

struct Sales_data {
    std::string bookNo;
    unsigned units_sold = 0;
    //double revenue = 0.0; // 正确
    //double revenue(0.0); //错误
    //double revenue{0.0}; // 正确
    double revenue = {0.0}; // 正确
};

int main() {
    Sales_data accum, trans, *salesptr;

    int a(1);
    return 0;
}