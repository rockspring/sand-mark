#include <iostream>
#include <boost/version.hpp>
#include <boost/progress.hpp>

using namespace std;

int main() {
    cout << BOOST_VERSION << endl;
    
    cout << BOOST_LIB_VERSION << endl;
    
    boost::progress_display pd(10);
    pd+=1;
    pd+=1;

    return 0;
}
