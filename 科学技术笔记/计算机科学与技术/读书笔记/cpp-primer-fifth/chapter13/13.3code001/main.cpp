#include <iostream>

using namespace std;

class HasPtr {
friend void swap(HasPtr &, HasPtr &);
public:
    HasPtr(const std::string &s = std::string()):ps(new std::string(s)), i(0){}
    HasPtr(const HasPtr &p):ps(p.ps), i(i){}

    HasPtr& operator=(HasPtr rhs);

    void print() {
        cout << "ps= " << ps << " ";
        cout << "*ps= " << *ps << endl;
    }

    ~HasPtr() {
        cout << "~HasPtr()" << endl;
    }

private:
    std::string *ps;
    int i;
};

HasPtr& HasPtr::operator=(HasPtr rhs) {
    rhs.print();
    swap(*this, rhs);

    return *this;
}

inline void swap(HasPtr &lhs, HasPtr &rhs) {
    cout << "swap(HasPtr &lhs, HasPtr &rhs)" << endl;
    using std::swap;
    swap(lhs.ps, rhs.ps);
    swap(lhs.i, rhs.i);
}

class Foo {
friend void swap(Foo &, Foo &);
private:
    HasPtr h;
};

inline void swap(Foo &lhs, Foo &rhs) {
    using std::swap;
    swap(lhs.h, rhs.h);
}

int main() {
    Foo a;
    Foo b;
    swap(a, b);

    HasPtr hasPtr1("abc");
    HasPtr hasPtr2("efg");

    hasPtr1.print();

    hasPtr1 = hasPtr2;

    hasPtr1.print();

    cout << "Hello, World!" << endl;
    return 0;
}