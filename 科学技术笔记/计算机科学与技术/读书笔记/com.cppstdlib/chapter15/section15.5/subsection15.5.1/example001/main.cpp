#include <iostream>

using namespace std;

int main() {
    char c;
    //cin.get(c);
    /*ios::int_type r = cin.get();
    r = cin.get();
    r = cin.get();
    cout << cin.eof() << endl;*/
    
    char str[3];
    cin.readsome(str, 3);
    cout << cin.gcount() << endl;
    cout << cin.std::__1::ios_base::fail() << endl;
    c = cin.get();
    cout << cin.gcount() << endl;

    return 0;
}
