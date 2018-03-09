#include <iostream>

using namespace std;

int main() {
    char x = -127;
    cout << "(x<0)=" << (x<0) << endl;
    cout << "(x>0)=" << (x>0) << endl;
    cout << (x<0) - (x>0) << endl;
    cout << "Hello, World!" << endl;
    return 0;
}