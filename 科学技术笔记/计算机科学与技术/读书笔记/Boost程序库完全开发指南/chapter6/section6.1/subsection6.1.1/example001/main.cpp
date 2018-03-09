//#define BOOST_DISABLE_ASSERTS
#define BOOST_ENABLE_ASSERT_HANDLER
#include <iostream>
#include <boost/assert.hpp>

using namespace std;

double func(int x) {
    BOOST_ASSERT_MSG(x!=0, "divided by zero");
    return 1.0/x;
}

int main() {
    cout << "sizeof(int)=" << sizeof(int) << endl;
    BOOST_ASSERT(1);
    //BOOST_ASSERT_MSG(1==2, "1!=2");
    func(0);
    return 0;
}
