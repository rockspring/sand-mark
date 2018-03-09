#include <iostream>

using namespace std;

class Base {
};

class Derived : public Base {
};

class Base1 {
public:
    virtual ~Base1(){};
};

class Derived1 : public Base1 {
public:
    ~Derived1() {};
};

int main() {
    cout << sizeof(Base) << endl;
    Derived * dp = new Derived;
    Base * bp = dp;
    cout << typeid(*dp).name() << endl;
    cout << typeid(*bp).name() << endl;

    
    if (typeid(*bp) == typeid(*dp)) {
        cout << "typeid(*bp) == typeid(*dp)" << endl;
    }
    
    if (typeid(*bp) == typeid(Derived)) {
        cout << "typeid(*dp) == typeid(Derived)" << endl;
    }
    
    Derived1 * dp1 = new Derived1;
    Base1 * bp1 = dp1;
    cout << typeid(*dp1).name() << endl;
    cout << typeid(*bp1).name() << endl;
    
    
    if (typeid(*bp1) == typeid(*dp1)) {
        cout << "typeid(*bp1) == typeid(*dp1)" << endl;
    }
    
    if (typeid(*bp1) == typeid(Derived1)) {
        cout << "typeid(*dp1) == typeid(Derived1)" << endl;
    }
    return 0;
}
