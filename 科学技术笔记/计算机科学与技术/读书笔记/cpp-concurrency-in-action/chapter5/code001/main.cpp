#include <iostream>

using namespace std;

struct my_data {
    //int i; // 4
    //double b; // 8
    unsigned bf1:10; // 4
    int bf2:25; // 4
    //int bf3:0;
    //int bf4:9;// 4
    //int i2; // 4
    //char c1;
    //char c2; // 2
    //std::string s;
};

struct char_data {
    char c1;
};

int main() {
    cout << sizeof(my_data) << endl;
    cout << sizeof(char_data) << endl;
    return 0;
}