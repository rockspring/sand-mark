#include <iostream>
#include <string>

//1 using声明出现杂全局作用域
using std::cout;

class Base {
public:
    int i_ = 100;
private:
    int j_ = 1;
};

class Derived : private Base {
public:
    //2 using声明出现在类的作用域，这样的语句只能指向基类成员
    using Base::i_;
private:
    
};

namespace name_space {
    //3 using声明出现命名空间作用域
    using std::string;
    string s("name_space string instance");
}

int main() {
    //4 using声明出现局部作用域
    using std::endl;
    Derived derived;
    cout << derived.i_ << endl;
    derived.i_ = 101;
    cout << derived.i_ << endl;
    
    cout << name_space::s << endl;
    return 0;
}
