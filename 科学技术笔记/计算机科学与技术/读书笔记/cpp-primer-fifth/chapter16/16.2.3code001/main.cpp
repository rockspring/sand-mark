#include <iostream>
#include <vector>

using namespace std;

template <typename It>
auto fn(It beg, It end) -> decltype(*beg) {
return *beg;
}

void test1() {
    vector<int> vi = {1, 2, 3, 4, 5};
    auto &i = fn(vi.begin(), vi.end());
}

template <typename It>
auto fcn2(It beg, It end) -> typename remove_reference<decltype(*beg)>::type {
    return *beg;
};

void test2() {
    vector<int> vi = {1, 2, 3, 4, 5};
    auto i = fcn2(vi.begin(), vi.end());
}

int main() {
    test1();
    test2();
    return 0;
}