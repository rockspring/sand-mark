#include <iostream>

using namespace std;

template <typename F, typename T1, typename T2>
void flip1(F f, T1 t1, T2 t2) {
    f(t2, t1);
};

void f(int v1, int &v2) {
    cout << v1 << " " << ++v2 << endl;
}

void test1() {
    int i = 1;
    f(42, i);
    cout << "i=" << i << endl;

    int j = 1;
    flip1(f, j, 42);
    cout << "j=" << j << endl;

}

template <typename F, typename T1, typename T2>
void flip2(F f, T1 &&t1, T2 &&t2) {
    f(t2, t1);
};

void test2() {
    int i = 1;
    f(42, i);
    cout << "i=" << i << endl;

    int j = 1;
    flip2(f, j, 42);
    cout << "j=" << j << endl;

}

void g(int &&i, int &j) {
    cout << i << " " << j << endl;
}

void test3() {
    int i = 1;
    // error: rvalue reference to type 'int' cannot bind to lvalue of type 'int'
    //flip2(g, i, 42);
}

template <typename F, typename T1, typename T2>
void flip(F f, T1 &&t1, T2 &&t2) {
    f(std::forward<T2>(t2), std::forward<T1>(t1));
};

void test4() {
    int i = 1;
    flip(g, i, 42);
}


int main() {
    //test1();
    //test2();
    //test3();
    test4();
    return 0;
}