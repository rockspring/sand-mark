#include <iostream>
#include <fstream>

using namespace std;

int main() {
    fstream file("example.txt", ios::in | ios::out);
    file << 1;
    //file.flush();
    int x;
    //file.seekg(0);
    file >> x;
    
    cout << x << endl;
    return 0;
}
