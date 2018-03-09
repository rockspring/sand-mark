#include <iostream>
#include <fstream>

using namespace std;

int main() {
    filebuf buffer;
    ostream output(&buffer);
    istream input(&buffer);
    buffer.open("example.dat", ios::in | ios::out | ios::trunc);
    
    for (int i=1; i <=4; i++) {
        output << i << ". line" << endl;
        
        /*input.seekg(0);
        char c;
        while (input.get(c)) {
            cout.put(c);
        }*/
        input.seekg(0);
        cout << input.rdbuf();
        
        cout << endl;
        input.clear();
    }
    return 0;
}
