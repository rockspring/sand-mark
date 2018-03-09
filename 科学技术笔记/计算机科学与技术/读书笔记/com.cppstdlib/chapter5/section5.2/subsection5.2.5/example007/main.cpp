#include <iostream>
#include <memory>
#include <string>

using namespace std;

//源头和去处（Source and Sink)

//对象的拥有权转移至函数

void sink(unique_ptr<string> up) {
    if (up) {
        cout << *up << endl;
    }
}

int main() {
    unique_ptr<string> up(new string("abc"));
    
    sink(std::move(up));
    return 0;
}
