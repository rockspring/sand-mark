#include <iostream>

using namespace std;

namespace A {
    //void f2();
    class C {
        friend void f2();
        friend void f(const C&);
    };
    
    void f2() {
        printf("I am f2\n");
    }
    
    void f(const A::C& c) {
        printf("I am f\n");
    }
}



int main() {
    A::C c;
    //A::f2();
    using A::f2;
    f2();
    f(c);
    return 0;
}
