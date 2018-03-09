#include <iostream>
#include <boost/smart_ptr.hpp>
#include <boost/core/lightweight_test.hpp>

using namespace std;

int main() {
    auto p = make_shared<int>(10);
    
    BOOST_TEST(*p == 10);
    BOOST_TEST(p.unique());
    
    BOOST_TEST_EQ(p.use_count(), 1);
    BOOST_TEST_NE(*p, 20);
    
    p.reset();
    BOOST_TEST(!p);
    
    BOOST_TEST_THROWS(*p, std::runtime_error);
    BOOST_ERROR("error accured!!");
    
    return boost::report_errors();
}
