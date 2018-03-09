#include <iostream>

using namespace std;

int main() {
    int a = 144;
    int b = 456;
    int c=0;
    int count = 0;
    while (a && b) {
        int current_count = a % 10 + b % 10 + c > 9 ? 1 : 0;
        count += current_count;
        c = (a % 10 + b % 10 + c ) / 10;
        a = a / 10;
        b = b / 10;
    }
    cout << count << endl;
    return 0;
}
