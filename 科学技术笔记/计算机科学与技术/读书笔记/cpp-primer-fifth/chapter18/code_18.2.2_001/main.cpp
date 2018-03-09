#include <iostream>

using namespace std;

namespace A {
    int i, j;
    class A{};
    void f() {};
}

class B {
//using namespace A;
};

void test1() {
    //using namespace A;
    {
        //using namespace A;
        {
            using namespace A;
            cout << i << endl;
            f();
        }
    }
    //cout << i << endl;

    B b;
}

namespace blip {
    int i = 16, j = 15, k=23;
    namespace blip_sub {
        int l = 16;
    }
}

int j = 0;
int l = 0;

void manip() {
    {
        using namespace blip;
        using namespace blip::blip_sub;
        ++i;
        //++j;
        ++l;
    }

}

void test2() {
    manip();
}

int main() {
    test1();
    return 0;
}