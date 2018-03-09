#include <iostream>

using namespace std;

int main() {
    cout << "Hello, World!" << endl;
    typedef char *pstring;
    pstring cstr = 0;
    pstring *ps;

    ps = &cstr;

    char cc[1]= {'a'};
    cstr = cc;
    cout << (long)*ps;
    return 0;
}