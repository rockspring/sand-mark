#include <iostream>

using namespace std;

template <typename T1, typename T2, typename T3>
T3 alternative_sum(T2 v1, T1 v2) {
    return v1 + v2;
};

int main() {
    auto val3 = alternative_sum<int, int, int>(1, 2);
    cout << val3 << endl;
    return 0;
}