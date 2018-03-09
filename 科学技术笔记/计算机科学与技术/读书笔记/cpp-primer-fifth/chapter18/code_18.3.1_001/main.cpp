#include <iostream>
#include <memory>

using namespace std;

struct Base1 {
    Base1() = default;
    Base1(const std::string&) {};
    Base1(std::shared_ptr<int>) {};
};

struct Base2 {
    Base2() = default;
    Base2(const std::string&) {};
    Base2(int a) {};
};

struct D1: public Base1, public Base2 {
    //using Base1::Base1;
    //using Base2::Base2;
};

struct D2: public Base1, public Base2 {
    using Base1::Base1;
    using Base2::Base2;

    D2(const string& s): Base1(s), Base2(s) {};
    D2() = default;
};

int main() {
    //D1 d1;
    D2 d2;
    return 0;
}