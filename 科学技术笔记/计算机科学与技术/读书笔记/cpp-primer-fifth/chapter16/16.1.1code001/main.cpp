#include <iostream>

using namespace std;

template <typename T>
int compare(const T &v1, const T &v2) {
    if (v1 < v2) return -1;
    if (v2 < v1) return 1;
    return 0;
}

template <typename T>
int compare2(const T &v1, const T &v2) {
    if (less<T>()(v1, v2)) return -1;
    if (less<T>()(v2, v1)) return 1;
    return 0;
}

int main() {
    int *v1 = new int(10);
    int *v2 = new int(20);
    cout << "&v1" << &v1 << endl;
    cout << "&v2" << &v2 << endl;
    cout << boolalpha << compare(v1, v2) << endl; // 指针比较，行为未定义
    cout << boolalpha << compare2(v1, v2) << endl;
    cout << boolalpha << compare(10, 20) << endl;
    cout << boolalpha << compare(20, 10) << endl;

    cout << boolalpha << compare(0x7fff57a3a3f0, 0x7fff57a3a3e8) << endl;

    return 0;
}