#include <iostream>

using namespace std;

namespace A {
    int i=1;
}

namespace B {
    int i;
}

int i=1;

void print() {
    //using namespace A;
    cout << "print():i=" << i << endl;

}

namespace C {
    //int i=12;
    void print() {
        using namespace A;
        cout << "print() A::i=" << A::i << endl;
        cout << "print() ::i=" << ::i << endl;
    }
}

void print2() {
    using namespace B;
    cout << "print2()" << endl;
}

int main() {
    print();
    print2();
    
    C::print();

    return 0;
}
