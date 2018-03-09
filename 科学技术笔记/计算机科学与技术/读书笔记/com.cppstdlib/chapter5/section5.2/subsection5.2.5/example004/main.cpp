#include <iostream>
#include <memory>
#include <string>

using namespace std;

int main() {
    string *sp = new string("hello");
    unique_ptr<string> up1(sp);
    //unique_ptr<string> up2(sp);
    
    //unique_ptr<string> up2(up1);
    unique_ptr<string> up2(std::move(up1));
    
    cout << up1.get() << endl;
    
    cout << *up2 << endl;

    return 0;
}
