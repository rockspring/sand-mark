#include <iostream>
#include <limits.h>

using namespace std;

int main() {
    cout << numeric_limits<int>::min() << endl;
    cout << numeric_limits<int>::lowest() << endl;
    cout << numeric_limits<int>::max() << endl;
    
    
    cout << "digits:" << numeric_limits<int>::digits << endl;
    
    cout << "digits10:" << numeric_limits<int>::digits10 << endl;
    
    cout << numeric_limits<float>::infinity() << endl;
    
    cout << numeric_limits<float>::epsilon() << endl;
    
    cout << numeric_limits<float>::has_quiet_NaN << endl;
    
    cout << numeric_limits<float>::quiet_NaN() << endl;
    
    cout << numeric_limits<float>::signaling_NaN() << endl;
    
    cout << numeric_limits<float>::denorm_min() << endl;
    
    cout << numeric_limits<float>::round_style << endl;
    
    cout << numeric_limits<unsigned int>::min() << endl;
    cout << numeric_limits<unsigned int>::round_style << endl;
    return 0;
}
