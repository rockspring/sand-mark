#include <iostream>

using namespace std;

int main() {
    cout << cin.tie() << endl;
    cout << &cout << endl;
    
    int x;
    cin.tie(0);
    cout << cin.tie() << endl;

    cout << nounitbuf << "x=";
    cin >> x;
    return 0;
}
