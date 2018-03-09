#include <iostream>

using namespace std;

int main() {
    int a = 3, b =4;
    decltype(a) c = a;
    decltype(a = b) d = a;

    cout << "a=" << a << endl;
    cout << "b=" << b << endl;
    cout << "c=" << c << endl;
    cout << "d=" << d << endl;

    cout << endl;
    d = 4;

    cout << "a=" << a << endl;
    cout << "b=" << b << endl;
    cout << "c=" << c << endl;
    cout << "d=" << d << endl;

    return 0;
}