#include <typeinfo>
#include <iostream>
#include <vector>
#include <utility>

using namespace std;

template <typename Container, typename Index>
auto authAndAccessC11(Container& c, Index i) -> decltype(c[i]) {
    return c[i];
}

template <typename Container, typename Index>
decltype(auto) authAndAccessC14(Container&& c, Index i) {
    return std::forward<Container>(c)[i];
}

template <typename T>
class TD;

decltype(auto) f1() {
    int x = 0;
    
    return x;
}

decltype(auto) f2() {
    const int x = 0;
    
    return (x);
}

class Widget {
public:
    Widget(int i, bool b) {
        
    }
    
    Widget(int i, double b) {
        
    }
    
    Widget(std::initializer_list<bool> il) {
        
    }
};


int main()
{
    vector<int> v = {1, 2, 3};
    int& a = authAndAccessC11(v, 1);
    cout << "type(a)=" << typeid(a).name() << endl;
    //TD<decltype(a)> xType;
    authAndAccessC11(v, 1) = 2;
    
    cout << "authAndAccess(v, 1)=" << authAndAccessC11(v, 1) << endl;
    
    vector<bool> v1 = {true, false};
    //const bool& b = authAndAccess(v1, 0);
    authAndAccessC14(v1, 1) = false;
    
    cout << "authAndAccess(v1, 1)=" << authAndAccessC14(v1, 1) << endl;

    
    //TD<decltype(f1())> yType;
    //TD<decltype(f2())> zType;
    const int  * const p = &a;
    const int  * const & pr = p;
    cout << "type(b)=" << typeid(pr).name() << endl;
    
    //Widget w{10, 5.0};
}
