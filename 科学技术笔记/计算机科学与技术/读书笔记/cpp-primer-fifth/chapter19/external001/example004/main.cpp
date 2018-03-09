#include <iostream>

using namespace std;

class Foo {
public:
    int f(char *c = 0) {
        std::cout << "Foo::f()" << std::endl;
        return 1;
    }
};

class Bar {
public:
    void b(int i = 0) {
        std::cout << "Bar::b()" << std::endl;
    }
};

class FooDerived : public Foo {
public:
    int f(char *c = 0) {
        std::cout << "FooDerived::f()" << std::endl;
        return 1;
    }
};

int main(int argc, char *argv[]) {
    typedef int (Foo::*FPTR) (char*);
    typedef void (Bar::*BPTR) (int);
    typedef int (FooDerived::*FDPTR) (char*);
    
    FPTR fptr = &Foo::f;
    BPTR bptr = &Bar::b;
    FDPTR fdptr = &FooDerived::f;
    
    // bptr = static_cast<void(Bar::*)(int)>(fptr); // 错误
    fdptr = fptr;
    //fdptr = static_cast<int(FooDerived::*)(char*)>(fptr); // 正确，逆变性规则
    
    Bar obj;
    (obj.*bptr)(2);
    ( obj.*(BPTR) fptr )(1); // 调用 Foo::f()
    
    return 0;
}
