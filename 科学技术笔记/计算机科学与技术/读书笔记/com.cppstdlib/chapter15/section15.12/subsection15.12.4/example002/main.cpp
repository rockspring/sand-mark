#include <iostream>
#include <fstream>

using namespace std;

int main() {
    ofstream out("example.txt", ios::in | ios::out);
    istream in(out.rdbuf());
    out << 1;
    int x;
    in.seekg(0);
    in >> x;
    
    cout << x << endl;
    return 0;
}
