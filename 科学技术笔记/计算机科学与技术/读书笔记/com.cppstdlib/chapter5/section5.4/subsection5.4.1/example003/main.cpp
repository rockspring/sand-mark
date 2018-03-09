#include <iostream>

using namespace std;

template <typename  T1, typename  T2>
typename std::common_type<T1, T2>::type a_min(const T1& x, const T2& y) {
    if (x < y) {
        return x;
    } else {
        return y;
    }
}

int main() {
    string s("abc");
    cout << a_min("a", s) << endl;
    return 0;
}
