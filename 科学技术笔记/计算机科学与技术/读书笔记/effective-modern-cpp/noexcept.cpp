#include <typeinfo>
#include <iostream>
#include <vector>
#include <utility>

using namespace std;

int f1(int x) throw();

int f2(int x) noexcept;

class Widget {
public:
    Widget() {
        cout << "default constructor" << endl;
    }
    
    Widget(const Widget& w) {
        //throw exception();
        cout << "copy construct" << endl;
    }
    
    Widget(const Widget&& w) noexcept{
        //throw exception();
        cout << "move construct" << endl;
    }
    
    ~Widget() {
        cout << "default destructor" << endl;
    }

};

void testCopy(std::vector<Widget>& vw) {
    Widget w;
    vw.push_back(w);
}

void testMove(std::vector<Widget>& vw) {
    Widget w;
    vw.push_back(std::move(w));
}


int main() {
    std::vector<Widget> vw;
    //testCopy(vw);
    testMove(vw);
    
    int a;
    cin >> a;
}
