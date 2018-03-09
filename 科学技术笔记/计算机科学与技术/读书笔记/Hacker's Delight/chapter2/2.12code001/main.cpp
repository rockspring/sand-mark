#include <iostream>

using namespace std;

int main() {
    int x_abs = abs(-1);
    cout << x_abs << endl;

    cout << abs(1-1) - 1 << endl;

    cout << ~(1 | -1) << endl;

    auto numBits = 0;
    cout << (numBits - 1) << endl;
    cout << hex << ((unsigned int)-1 >> 6) << endl;
    cout << ((numBits - 1) >> 6 ) + 1 << endl;
    return 0;
}