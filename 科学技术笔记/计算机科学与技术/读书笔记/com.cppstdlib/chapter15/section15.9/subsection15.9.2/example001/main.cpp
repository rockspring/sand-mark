#include <iostream>
#include <string>
#include <fstream>

using namespace std;

int main() {
    string s("hello");
    //cout << "world" << endl;
    ofstream("fstream2.tmp") << s << endl;
    
    ofstream("fstream2.tmp", ios::app) << "word" << endl;
    
    ofstream("fstream2.tmp", ios::app | ios::binary) << 1 << endl;

    return 0;
}
