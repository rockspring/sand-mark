#include <iostream>
#include <functional>

using namespace std;

int main() {
    cout << negate<int>()(1) << endl;
    
    cout << plus<int>()(1, 2) << endl;
    
    cout << minus<int>()(3, 1) << endl;
    
    cout << multiplies<int>()(2, 3) << endl;
    
    cout << divides<int>()(4, 2) << endl;
    
    cout << modulus<int>()(3, 2) << endl;
    
    cout << equal_to<int>()(1, 2) << endl;
    
    cout << not_equal_to<int>()(1, 2) << endl;
    
    cout << less<int>()(1, 2) << endl;
    
    cout << greater<int>()(1, 3) << endl;
    
    cout << less_equal<int>()(1, 2) << endl;
    
    cout << greater_equal<int>()(1, 2) << endl;
    
    cout << logical_not<int>()(true) << endl;
    
    cout << logical_and<bool>()(true, false) << endl;
    
    cout << logical_or<bool>()(true, false) << endl;
    
    cout << bit_and<int>()(1, 2) << endl;
    
    cout << bit_or<int>()(1, 2) << endl;
    
    cout << bit_xor<int>()(1, 1) << endl;

    return 0;
}
