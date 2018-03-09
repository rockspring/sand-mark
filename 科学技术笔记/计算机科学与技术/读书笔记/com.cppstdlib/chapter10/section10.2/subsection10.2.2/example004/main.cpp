#include <iostream>
#include <map>
#include <utility>
#include <algorithm>
#include <numeric>

using namespace std;

int main() {
    map<string, int> coll;
    coll.insert(make_pair("a", 1));
    coll.insert(make_pair("b", 2));
    coll.insert(make_pair("c", 3));
    int sum = accumulate(coll.begin(), coll.end(), 0, bind(plus<int>(), placeholders::_1, bind(&map<string, int>::value_type::second, placeholders::_2)));
    
    cout << "sum=" << sum << endl;
    return 0;
}
