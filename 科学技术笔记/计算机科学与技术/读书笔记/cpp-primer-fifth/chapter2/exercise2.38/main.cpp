#include <iostream>

using namespace std;

int main() {
    const int i = 27;
    int j = 27;

    int * p = &j;
    auto a = (i);

    a = &i;

    //decltype((i)) b = &i;

    //const int & c = &i;

    decltype(*p) pp = j;
    return 0;
}