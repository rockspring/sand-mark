#include <iostream>

using namespace std;

class X {
int i;
int j;
public:
    X(int val): j(val), i(j) {}
};

int main() {
    cout << "Hello, World!" << endl;
    return 0;
}