#include <iostream>

using namespace std;

template <typename T> void f(T &p) {

}

template <typename T> void f1(T &r) {

}

void test1() {
    int i;
    f1(i);

    const int ci = 1;
    f1(ci);

    // candidate function [with T = int] not viable: expects an l-value for 1st argument
    //f1(5);
}

template <typename T> void f2(const T &p) {

}

void test2() {
    int i = 1;
    f2(i);

    const int ci = 2;
    f2(ci);

    f2(5);

    const int &ci2 = 2;
}

template <typename T> void f3(T &&p) {
    p++;
    string a(p);
    cout << "p=" << p << endl;
}

void test3() {
    f3(42);

    int i = 1;
    f3(i);

    int &ci = i;
    f3(ci);

    cout << "ci=" << ci << endl;
}





int main() {
    test1();
    test2();
    test3();
    return 0;
}