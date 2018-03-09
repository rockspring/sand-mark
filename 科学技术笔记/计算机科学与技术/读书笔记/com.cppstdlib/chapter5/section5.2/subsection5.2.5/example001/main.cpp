#include <iostream>
#include <memory>
#include <string>

using namespace std;

int main() {
    unique_ptr<string> up(new string("hello"));
    
    cout << up->length() << endl;
    
    cout << *up << endl;
    
    (*up)[0] = 'N';
    up->append("lai");
    cout << *up << endl;
    
    
    return 0;
}
