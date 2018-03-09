/**
 * Author: leqinzhou
 * Date: 2015-05-24
 *
 * This is a simple study program.
 */

//#include <boost/program_options.hpp>
#include <iostream>
#include <map>

using namespace std;

using std::cout;
using std::endl;

class A {
public:
    ~A() {
        cout << "~A" << endl;
    }
};

int main(int argc, char **argv) {
    map<string, A*> map_var;
    map_var["a"] = new A;
    for (auto item : map_var) {
        delete item.second;
    }
    
    map<string, A> map_var_1;
    //map_var_1["a"] = A();
    return 0;
}
