#include <iostream>

using namespace std;

int main() {
    char a = -127;
    char x = 0x81;
    cout << hex << ((x + 0x00000080) & 0x000000ff) - 0x00000080 << endl;
    cout << dec << (int)a << endl;
    return 0;
}