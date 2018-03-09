#include <iostream>
#include <sstream>

using namespace std;

template <typename T>
string debug_rep(const T &t) {
    ostringstream ret;
    ret << t;

    return ret.str();
}

template <typename T>
string debug_rep(T *p) {
    ostringstream ret;
    ret << "pointer: " << p;
    if (p) {
        ret << " " << debug_rep(*p);
    } else {
        ret << " null pointer";
    }

    return ret.str();
}

void test1() {
    string s("hi");
    cout << debug_rep(s) << endl;

    cout << debug_rep(&s) << endl;
}

void test2() {
    string s("hi");
    const string *sp = &s;

    cout << debug_rep(sp) << endl;
}

string debug_rep(const string &s) {
    return '"' + s + '"';
}

void test3() {
    string s("hi");
    cout << debug_rep(s) << endl;
}

void test4() {
    cout << debug_rep("hi world!") << endl;
}

string debug_rep(char *p) {
    return debug_rep(string(p));
}

string debug_rep(const char *p) {
    return debug_rep(string(p));
}

void test5() {
    cout << debug_rep("hi world!") << endl;
}

int main() {
    //test1();
    //test2();
    //test3();
    //test4();
    test5();
    return 0;
}