#include <iostream>

using namespace std;

int main() {
    cout << "Hello, World!" << endl;
    int sum = 0, val =1;
    sum += val;
    //cout << (sum += val);
    cout << (sum++);
    cout << (++sum);
    return 0;
}