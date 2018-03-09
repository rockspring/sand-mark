#include <iostream>

using namespace std;

class Base {
protected:
    int prot_mem;
};

class Sneaky : public Base {
    friend void clobber(Sneaky&);
    friend void clobber(Base&);
    int j;
};

void clobber(Sneaky &s) {
    s.j = s.prot_mem = 10;
    cout << s.prot_mem;
}

void clobber(Base &b) {
    //b.prot_mem = 0; // error: 'prot_mem' is a protected member of 'Base'
}

int main() {
    Sneaky s;
    clobber(s);
    return 0;
}