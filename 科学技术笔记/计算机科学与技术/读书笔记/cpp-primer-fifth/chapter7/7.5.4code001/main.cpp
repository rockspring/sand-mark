#include <iostream>

using namespace std;

class Debug {
public:
    constexpr Debug(bool b);
    constexpr Debug():Debug(false){}

private:
    bool hw;
    bool io;
    bool other;
};


constexpr Debug::Debug(bool b): hw(b), io(b), other(b) {}

int main() {
    Debug debug(false);
    //cout << debug << endl;
    return 0;
}