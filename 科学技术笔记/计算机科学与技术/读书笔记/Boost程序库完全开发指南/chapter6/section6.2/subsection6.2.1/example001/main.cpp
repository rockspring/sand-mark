#include <iostream>
#include <boost/static_assert.hpp>

using namespace std;

template <typename T>
T my_min(T a, T b) {
    //BOOST_STATIC_ASSERT(sizeof(T) < sizeof(int));
    BOOST_STATIC_ASSERT_MSG(sizeof(T) < sizeof(int), "only short or char");
    return a < b ? a : b;
}

int main() {
    BOOST_STATIC_ASSERT(2 == sizeof(short));
    BOOST_STATIC_ASSERT(true);
    BOOST_STATIC_ASSERT_MSG(16 == 0x10, "test static assert");
    
    cout << my_min((short)1, (short)3);
    //cout << my_min(1L, 3L);
    //cout << my_min(1, 3);
    return 0;
}
