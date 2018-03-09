#include <iostream>
#include <array>
#include <tuple>
#include <algorithm>
#include <iterator>

using namespace std;

int main() {
    typedef array<string, 5> FiveStrings;
    FiveStrings a = {"hello", "nico", "how", "are", "you"};
    cout << tuple_size<FiveStrings>::value << endl;
    //tuple_element<1, FiveStrings>::type;
    cout << get<1>(a) << endl;
    copy(a.cbegin(), a.cend(), ostream_iterator<string>(cout, " "));
    
    return 0;
}
