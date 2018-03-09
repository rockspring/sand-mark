#include <iostream>
#include <memory>
#include <string>

using namespace std;

//对付Array

int main() {
    //unique_ptr<string> up(new string[10]);
    
    unique_ptr<string[]> up(new string[10]);
    
    up[0] = 'a';
    
    cout << up[0] << endl;
    return 0;
}
