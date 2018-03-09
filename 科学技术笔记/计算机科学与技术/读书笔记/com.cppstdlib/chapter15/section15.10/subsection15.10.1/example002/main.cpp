#include <iostream>
#include <sstream>

using namespace std;

int main() {
    int x;
    float y;
    
    string s = "3.7";
    
    istringstream is(s);
    
    is >> x >> y;
    
    cout << x << endl;
    cout << y << endl;
    
    return 0;
}
