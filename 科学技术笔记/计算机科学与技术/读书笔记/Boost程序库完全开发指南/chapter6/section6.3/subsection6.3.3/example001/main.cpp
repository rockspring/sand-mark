#include <iostream>
#include <boost/core/lightweight_test_trait.hpp>

using namespace std;

int main() {
    BOOST_TEST_TRAIT_TRUE((is_integral<int>));
    BOOST_TEST_TRAIT_FALSE((is_function<int>));
    
    return boost::report_errors();
}
