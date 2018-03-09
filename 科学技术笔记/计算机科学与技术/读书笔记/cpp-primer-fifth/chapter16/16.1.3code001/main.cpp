#include <iostream>
#include <vector>

using namespace std;

template <typename T> int compare(const T&, const T&);
template <typename T> class Blob;

template <typename T> T calc(const T&, const T&);

template <typename Type>
Type calc(const Type &a, const Type &b) {
    return a + b;
}

template <typename T>
typename T::value_type top(const T &c) {
    if (!c.empty()) {
        return c.back();
    } else {
        // error: missing 'typename' prior to dependent type name 'vector<int, allocator<int> >::value_type'
        return typename T::value_type();
    }
}

//默认模板实参

template <typename T, typename F = less<T>>
int compare(const T &v1, const T &v2, F f = F()) {
    if (f(v1, v2)) return -1;
    if (f(v2, v1)) return 1;
    return 0;
};

// 模板默认实参与类模板

template <class T = int>
class Numbers {
public:
    Numbers(T v = 0): val(v) {}
private:
    T val;
};

void test() {
    Numbers<long double> lots_of_precision;
    Numbers<> average_precision;
}

int main() {

    cout << "1+2=" << calc(1, 2) << endl;

    vector<int> a = {1, 2, 3};
    cout << "top(a)=" << top(a) << endl;
    return 0;
}