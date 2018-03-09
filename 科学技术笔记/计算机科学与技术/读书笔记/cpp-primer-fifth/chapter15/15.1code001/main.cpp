#include <iostream>

using namespace std;

class A{
public:

    virtual void print() {
        cout << "A.print()" << endl;
    };

    virtual void print1() = 0;
};

class B: public A {
public:
    void print(){
        cout << "B.print()" << endl;
    }

    void print1() {
        cout << "B.print1()" << endl;
    }
};

class C final: public A {
public:
    void print() final{
        cout << "C.print()" << endl;
    }

    void print1() {
        cout << "C.print1()" << endl;
    }
};

int main() {
    B *bp = new B;
    A *ap = bp;
    ap->print();

    C c;
    A &a = c;
    a.print();

    A &aa = c;
    aa.print();

    aa.A::print();
    return 0;
}