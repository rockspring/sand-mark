#include <iostream>

using namespace std;

template <typename T> int compare(const T &v1, const T &v2) {
    if (v1 < v2) return -1;
    if (v2 < v1) return 1;
    return 0;
}

void test1() {
    int (*pf1) (const int&, const int&) = compare;
    cout << pf1(1, 2) << endl;
    cout << (*pf1)(1, 2) << endl;
}

void func(int (*) (const string&, const string&)) {

}

void func(int (*) (const int&, const int&)) {

}

void test2() {
    //func(compare);// error: call to 'func' is ambiguous
    func(compare<int>);
}



int main() {
    test2();
    return 0;
}