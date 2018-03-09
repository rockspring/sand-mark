#include <iostream>

using namespace std;

class Base {
    friend bool operator==(const Base&, const Base&);
public:
protected:
    virtual bool equal(const Base& other) const;
private:
    int i=0;
};

class Derived : public Base {
public:
protected:
    bool equal(const Base& other) const;
private:
    int j=0;

};

bool operator==(const Base& lhs, const Base& rhs) {
    if (typeid(lhs) != typeid(rhs)) {
        cout << "typeid(lhs) != typeid(rhs)" << endl;
        return false;
    } else {
        return lhs.equal(rhs);
    }
}

bool Base::equal(const Base& other) const{
    return true;
}

bool Derived::equal(const Base& other) const{
    auto r = dynamic_cast<const Derived&>(other);
    cout << "this->j=" << j << endl;
    cout << "r.j=" << r.j << endl;
    if (this->j == r.j) {
        return true;
    } else {
        return false;
    }
}

int main() {
    Derived d;
    Base &bp1 = d;
    Derived &bp2 = d;
    
    if (bp1 == bp2) {
        cout << "bp1 == bp2" << endl;
    }
    return 0;
}
