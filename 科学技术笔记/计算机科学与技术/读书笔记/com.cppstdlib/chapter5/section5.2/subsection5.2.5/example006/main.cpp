#include <iostream>
#include <memory>
#include <string>

using namespace std;

// up2原来拥有一个对象，up1移动赋值给up2后，up2释放原来拥有的对象

int main() {
    string *sp = new string("hello");
    unique_ptr<string> up1(sp);
    
    string *sp2 = new string("leqinzhou");
    unique_ptr<string> up2(sp2);
    
    cout << "before assignment" << endl;
    
    cout <<"up1=" << up1.get() << endl;
    
    cout <<"up2=" << up2.get() << endl;
    
    cout << "*up2=" << *up2 << endl;
    
    up2 = std::move(up1);
    
    cout << "after assignment" << endl;
    
    cout <<"up1=" << up1.get() << endl;
    
    cout <<"up2=" << up2.get() << endl;
    
    cout << "*up2=" << *up2 << endl;
    
    return 0;
}
