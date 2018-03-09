#include <iostream>
#include <sstream>

using namespace std;

int main() {
    string s("value: ");
    
    ostringstream os(s, ios::out | ios::ate);
    os << 77 << " " << hex << 77 << endl;
    cout << os.str();
    cout << s;
    return 0;
}
