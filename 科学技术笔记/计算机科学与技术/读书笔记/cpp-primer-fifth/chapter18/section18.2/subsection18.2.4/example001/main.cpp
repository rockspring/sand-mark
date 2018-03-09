#include <iostream>

using namespace std;

namespace A {
    void f() {
        printf("I am f() from namespace A\n");
    }
}

namespace B {
    void f() {
        printf("I am f() from namespace B\n");
    }
}


int main() {
    using A::f;
    f();
    return 0;
}
