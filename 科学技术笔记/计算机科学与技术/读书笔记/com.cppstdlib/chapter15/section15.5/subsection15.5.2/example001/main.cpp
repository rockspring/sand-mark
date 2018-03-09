#include <iostream>
#include <fstream>

using namespace std;

int main() {
    ofstream f("a.txt");
    f.put('a');
    f.put(0xF0);
    
    char chars[] = {'a', 'b'};
    f.write(chars, 2);
    f.flush();
    f.close();
    return 0;
}
