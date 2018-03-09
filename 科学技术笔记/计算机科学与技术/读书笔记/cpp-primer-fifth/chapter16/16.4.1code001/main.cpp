#include <iostream>

using namespace std;

template <typename T>
ostream &print(ostream &os, const T &t) {
    return os << t;
}

template <typename T, typename ... Args>
ostream &print(ostream &os, const T &t, const Args& ... rest) {
    os << t << ", ";
    return print(os, rest...);
};

void test1() {
    int i = 1;
    string s = "hi";
    print(cout, i, s, 42);
}

int main() {
    test1();
    return 0;
}