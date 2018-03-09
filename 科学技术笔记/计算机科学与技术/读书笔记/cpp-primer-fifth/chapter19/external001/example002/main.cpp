#include <iostream>

using namespace std;

class Foo {
public:
    static int f(string str) {
        cout << "Foo::f()" << endl;
        return 1;
    }
};

int main(int argc, char *argv[]) {
    //int (Foo::*fptr) (string) = &Foo::f; // 错误
    int (*fptr) (string) = &Foo::f; // 正确
    (*fptr)("str"); // 调用 Foo::f()
    
    return 0;
}
