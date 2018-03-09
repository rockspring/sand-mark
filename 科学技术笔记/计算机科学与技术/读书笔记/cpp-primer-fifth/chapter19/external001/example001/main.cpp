#include <iostream>

using namespace std;

class Foo {
public:
    Foo(int i = 0) { _i = i; }
    void f() {
        std::cout << "Foo::f()" << std::endl;
    }
    int f(string s) {
        cout << "f(string)" << endl;
        return 1;
    }
    /*动态绑定的就出错了
     virtual void f() {
     std::cout << "Foo::f()" << std::endl;
     }
     */
private:
    int _i;
};

int main() {
    Foo *p = 0;
    p->f();
    
    //void  (Foo::*fptr) () = &Foo::f;
    
    int (Foo::* fptr)(string);
    fptr = &Foo::f;
    
    (p->*fptr)("a");
    
    Foo obj;
    (obj.*fptr)("A");
    
    return 0;
}
