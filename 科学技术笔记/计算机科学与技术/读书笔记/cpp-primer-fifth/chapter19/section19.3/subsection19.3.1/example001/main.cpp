#include <iostream>

using namespace std;
enum class open_modes { input, output, append};

enum color { red, yellow, green};

enum {floatPrec = 6, doublePrec = 10, double_doublePrec = 10};

int main() {
    color hair = red;
    cout << hair << endl;
    hair = color::green;
    cout << hair << endl;

    open_modes open_mode = open_modes::input;
    cout << (int)open_mode << endl;
    
    constexpr color hair1 = color::yellow;
    return 0;
}
