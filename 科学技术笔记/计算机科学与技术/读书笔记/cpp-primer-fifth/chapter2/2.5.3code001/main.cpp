#include <iostream>

using namespace std;

int main() {
    const int ci = 0, &cj = ci;
    decltype(ci) x = 0; // x 是const int类型
    decltype(cj) y = x; // y 是const int& 类型
    //decltype(cj) z;

    cout << typeid(x).name() << endl;
    cout << typeid(y).name() << endl;

    int i = 42, *p = &i, &r = i;
    decltype(*p) c;

    return 0;
}