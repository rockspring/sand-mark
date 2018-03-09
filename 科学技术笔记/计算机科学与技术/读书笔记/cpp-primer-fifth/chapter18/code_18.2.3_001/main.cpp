#include <iostream>
#include <stdio.h>

using namespace std;

std::ostream& operator<<(std::ostream& os, int i) {
    printf("a");
    return os;
}



namespace a {


    void test1() {
        //std::cin << 1;
        operator<<(std::cout, 1);
    }

    void test() {
        test1();
    }
}

class A {

};

namespace primerLib {
    void compute() {
        cout << "compute()" << endl;
    }

    void compute(const void * a) {
        cout << "compute(const void * a)" << endl;
    }
}


// using primerLib::compute;
void compute(int a) {
    cout << "compute(int a)" << endl;
}

void compute(double a, double b = 3.4) {
    cout << "compute(double a, double b = 3.4)" << endl;
}

void compute(char * a, char * b = 0) {
    cout << "compute(char * a, char * b = 0)" << endl;
}

void f() {
    //using primerLib::compute; // 该函数的所有版本被引入到当前作用域中
    using namespace primerLib; //命名空间的成员提升到外层作用域
    compute(0);
}

void test2() {
    f();
}



int main() {
    using namespace a;
    //test1();
    test2();
    return 0;
}