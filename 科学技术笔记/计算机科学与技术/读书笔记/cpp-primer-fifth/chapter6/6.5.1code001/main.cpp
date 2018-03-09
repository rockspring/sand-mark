#include <iostream>

using namespace std;

int func(int a=1, int b=2) {
    return a + b;
}

int aa = 100;
int bb = 200;

int func1(int a=aa, int b=bb) {
    return a + b;
}

int main() {
    cout << func() << endl;
    cout << func(2) << endl;
    cout << func1() << endl;
    cout << func1(2) << endl;

    bb = 1000; //改变默认实参的值
    int aa = 1;
    cout << func1() << endl;
    return 0;
}