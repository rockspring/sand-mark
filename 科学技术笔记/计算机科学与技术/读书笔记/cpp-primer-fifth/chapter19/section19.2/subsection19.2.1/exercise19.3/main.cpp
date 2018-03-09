#include <iostream>

using namespace std;

class A {
public:
    void say() {
        cout << "say from A" << endl;
    }
    virtual ~A() {
        cout << "virtual ~A()" << endl;
    }
};

class B : public A {
public:
    void say() {
        cout << "say from B" << endl;
    }
    virtual ~B() {
        cout << "virtual ~B()" << endl;
    }
};

class C : public B {
public:
    virtual ~C() {
        cout << "virtual ~C()" << endl;
    }
};

class D : public C {
public:
    virtual ~D() {
        cout << "virtual ~D()" << endl;
    }
};

void test1() {
    A *pa = new C;
    B *pb = dynamic_cast<B*>(pa);
    //delete  pa;
    delete pb;
}

void test2() {
    B *pb = new B;
    cout << pb << endl;
    C *pc = dynamic_cast<C*>(pb);
    cout << pc << endl;
    delete pc;
}

void test3() {
    A *pa = new D;
    cout << pa << endl;

    B *pb = dynamic_cast<B*>(pa);
    cout << pb << endl;
    delete pb;
}

void test4() {
    B *pb = new B;
    pb->say();
    A *pa = dynamic_cast<A*>(pb);
    pa->say();
    B *pb1 = dynamic_cast<B*>(pa);
    pb1->say();
    
    delete pb;
}

int main() {
    test4();
    return 0;
}
