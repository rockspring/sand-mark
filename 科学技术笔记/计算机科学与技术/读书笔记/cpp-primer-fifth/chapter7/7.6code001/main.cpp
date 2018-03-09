#include <iostream>

using namespace std;

class Bar {
public:

private:
    static Bar mem1;
    Bar *mem2;
    //Bar mem3; // 类定义尚未完成，不知道需要分配多少内存
};

class Screen {
public:
    Screen clear(char = bkground){ Screen s; return s;}
    static const char bkground;
    static char a = 'a';
};

const char Screen::bkground = 'a';

int main() {
    Screen s;
    s.clear();

    cout << Screen::bkground << endl;
    cout << Screen::a << endl;
    return 0;
}