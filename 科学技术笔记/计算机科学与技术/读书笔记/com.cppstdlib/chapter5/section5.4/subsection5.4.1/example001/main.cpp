#include <iostream>
#include <string>

using namespace std;

template <typename T>
void foo(const T& val) {
    if (std::is_pointer<T>::value) {
        std::cout << "foo() called for a pointer" << std::endl;
    } else {
        std::cout << "foo() called for a value" << std::endl;
    }
}

int main() {
    foo(1);
    foo(new string("abc"));
    return 0;
}
