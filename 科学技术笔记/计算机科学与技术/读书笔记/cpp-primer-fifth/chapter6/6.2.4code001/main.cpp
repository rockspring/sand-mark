#include <iostream>

using namespace std;

void print(int (&arr)[3]) {
    for (int a : arr) {
        cout << a << endl;
    }

    for (int &a : arr) {
        a *= a;
    }

    for (int a : arr) {
        cout << a << endl;
    }
}

auto func1(int i) -> int {
    return i*i;
}

int main() {
    int arr[] = {1, 2, 3};
    print(arr);

    cout << func1(2);
    return 0;
}