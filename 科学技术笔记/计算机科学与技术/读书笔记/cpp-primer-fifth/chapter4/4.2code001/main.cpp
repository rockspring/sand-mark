#include <iostream>
#include <vector>

using namespace std;

int main() {
    int a = 18;
    int b = 5;

    int c = a / b;

    cout << "c=" << c << endl;

    c = a / -b; // 向0取整，-3.6 ==> 3，Python向负无穷取整-3.6 ==> 4
    cout << "c=" << c << endl;

    //(m/n)*n + m%n == m

    if ((a = b)) {
        a = b;
    }

    string s = "abcd";

    auto beg = s.begin();
    while (beg != s.end() && !isspace(*beg)) {
        *beg = toupper(*beg++);
    }

    cout << s;

    b= a << 1 << 2;

    cout << sizeof s;

    vector<string> v = {"a"};

    for (int i = 0; i < 100; ++i) {
        v.push_back("a");
    }

    cout << ".." << endl;

    cout << sizeof v;

    int *ip;

    //char *pc = static_cast<char *>(ip);
    char *pc = reinterpret_cast<char *>(ip);

    return 0;
}