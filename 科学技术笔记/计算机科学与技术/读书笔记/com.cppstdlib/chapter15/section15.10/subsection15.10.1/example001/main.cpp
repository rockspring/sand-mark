#include <iostream>
#include <sstream>
#include <bitset>

using namespace std;

int main() {
    ostringstream os;
    os << "dec: " << 15 << hex << " hex: " << 15 << endl;
    string s = os.str();
    cout << os.str();
    cout << "end...";
    
    bitset<15> b(56789);
    os << "float: " << 4.67 << " bitset: " << b << endl;

    os.seekp(0);
    os << "oct: " << oct << 1515;
    
    cout << os.str() << endl;
    
    os.str("");
    
    cout << os.str() << endl;
    
    cout << os << endl;
    return 0;
}
