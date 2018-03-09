#include <typeinfo>
#include <iostream>
#include <vector>
#include <utility>

using namespace std;

class Widget {
public:
    Widget() {
        cout << "Widget constructor" << endl;
    }
    
    Widget(const Widget& rhs) {
        cout << "Widget copy constructor" << endl;
    }
    
    Widget& operator=(const Widget& rhs) {
        cout << "Widget copy assignment" << endl;
        return *this;
    }
    
    Widget(const Widget&& rhs) {
        cout << "Widget move constructor" << endl;
    }
    
    Widget& operator=(const Widget&& rhs) {
        cout << "Widget move assignment" << endl;
        return *this;
    }
    
    ~Widget() {
        cout << "Widget destructor" << endl;
    }
};

class Widget1 {
public:
    Widget *wp = new Widget;
    Widget w;
};

class Widget2 {
public:
    Widget2(const Widget2&& rhs) {
        cout << "move constructor" << endl;
    }
};

int main() {
    Widget1 w1;
    cout << w1.wp << endl;
    cout << &w1.w << endl;
    //Widget1 w1CopyConstruct(w1);
    Widget1 w1CopyAssignment = w1;
    cout << w1CopyAssignment.wp << endl;
    cout << &w1CopyAssignment.w << endl;

}
