#include <iostream>
#include <cstring>

using namespace std;
class A {
public:
    typedef int AA;
    class B;
    int a_i_;
    void print();
};


class A::B {
public:
    void print() {
        AA a = 100;
        cout << a << endl;
        //cout << a_i_ << endl;
    }
    int i = 0;
};

void A::print() {
    B b;
    cout << b.i << endl;
    
}

int main() {
    A::AA a = 100;
    A::B b;
    b.i = 10;
    cout << b.i << endl;
    b.print();
    
    A aa;
    aa.print();
    return 0;
}
