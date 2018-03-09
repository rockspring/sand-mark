#include <iostream>
#include <memory>
#include <string>

using namespace std;

//源头和去处（Source and Sink)

//对象的拥有权从函数转移至调用端场景

unique_ptr<string> source() {
    unique_ptr<string> ptr(new string("abc"));
    
    return ptr;//return语句编译器自动尝试加上move
}

int main() {
    unique_ptr<string> up;
    
    for (int i=0; i < 10; ++i) {
        up = source();
        if (up != nullptr) {
            cout << *up << endl;
        }
    }
    return 0;
}
