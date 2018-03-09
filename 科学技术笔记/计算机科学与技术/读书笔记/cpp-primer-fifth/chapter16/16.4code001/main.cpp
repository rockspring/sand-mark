#include <iostream>

using namespace std;

template <typename T, typename ... Args>
void foo(const T &t, const Args& ... rest) {
    cout << sizeof...(Args) << endl;
    cout << sizeof...(rest) << endl;
};

void test1() {
    int i=0;
    double d = 3.14;
    string s = "how now brown cow";
    foo(i, s, 42, d);
    foo(s, 42, "hi");
    foo(d, s);
    foo("hi");
}

template <typename ... Args> void g(Args ... args) {
    cout << sizeof...(Args) << endl;
    cout << sizeof...(args) << endl;
}

void test2() {
    g(1, 2, "hi");
}

int main() {
    test1();
    //test2();
    return 0;
}