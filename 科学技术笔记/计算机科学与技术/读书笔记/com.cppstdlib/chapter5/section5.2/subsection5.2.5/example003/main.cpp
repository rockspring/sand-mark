#include <iostream>
#include <memory>
#include <string>

using namespace std;

int main() {
    unique_ptr<string> up;
    
    if (up) {
        cout << "up is not empty" << endl;
        cout << *up << endl;
    } else {
        cout << "up is empty" << endl;
    }
    
    up = nullptr;
    
    up.reset();
    
    up = unique_ptr<string>(new string("nico"));
    
    if (up) {
        cout << "up is not empty" << endl;
        cout << *up << endl;
    } else {
        cout << "up is empty" << endl;
    }
    
    string *sp = up.release();
    
    cout << *sp << endl;
    
    delete sp;
    
    if (up) {
        cout << "up is not empty" << endl;
        cout << *up << endl;
    } else {
        cout << "up is empty" << endl;
    }
    
    if (up != nullptr) {
        cout << "up is not empty" << endl;
        cout << *up << endl;
    } else {
        cout << "up is empty" << endl;
        
        cout << up.get() << endl;
    }
    
    if (up.get() != nullptr) {
        cout << "up is not empty" << endl;
        cout << *up << endl;
    } else {
        cout << "up is empty" << endl;
        
        cout << up.get() << endl;
    }

    return 0;
}
