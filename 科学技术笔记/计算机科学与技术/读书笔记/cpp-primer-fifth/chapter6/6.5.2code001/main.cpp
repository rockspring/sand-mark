#include <iostream>
#include <cassert>

using namespace std;

constexpr int new_sz() {
    return 42;
}

constexpr size_t scale(size_t cnt) {
    return new_sz() * cnt;
}

int main() {
    constexpr int foo = new_sz();

    int arr[scale(2)];
    int i = 2;
    int a2[scale(i)];

    cout << sizeof(a2) / sizeof(int) << endl;

    assert((sizeof(a2) / sizeof(int)) == 84);

    //
    string s;

    while (cin >> s && s != "a") {}

    assert(cin);
    return 0;
}