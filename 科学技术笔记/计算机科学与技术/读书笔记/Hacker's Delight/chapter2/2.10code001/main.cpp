#include <iostream>

using namespace std;

int main() {
    unsigned short x = 0xff;
    unsigned char y = ((x-1) & 0xff) +1;
    cout << (int)y << endl;
    return 0;
}