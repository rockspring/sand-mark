#include <iostream>

using namespace std;

int main() {
    auto x = 1;
    auto y = 2;
    int result = (x > y) - (x < y);
    cout << "result=" << result << endl;
    return 0;
}