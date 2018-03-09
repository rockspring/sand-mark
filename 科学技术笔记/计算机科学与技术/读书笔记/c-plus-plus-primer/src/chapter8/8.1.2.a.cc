#include <iostream>

using std::cout;
using std::cin;
using std::cerr;
using std::endl;

class A {
public:
    operator bool() const {return true;}
};

void func1() {
        A a = A();
    bool b = a;

    cout << typeid(cout.unitbuf).name() << endl;
    cout << cout.unitbuf << endl;

    int ival;
    bool p = (bool)(cin >> ival);
    cout << p << endl;
    cout << typeid(cin >> ival).name() << endl;

        cout << "ival" << ival << endl;
        cout << cin.rdstate() << endl;
        cout << cin.failbit << endl;
        cout << cin.badbit << endl;
        cout << cin.eofbit << endl;
        cout << cin.goodbit << endl;
 

}

void func2() {
    int ival;
    cout << "a";
    //cin.tie(&cerr);
    cin.tie(nullptr);
    cin >> ival;
    cout << ival;
}

int main() {
    func2();
    return 0;
}