#include <iostream>
#include <vector>

using std::cout;
using std::cin;
using std::cerr;
using std::endl;
using std::istream_iterator;

int main() {
    istream_iterator<int> int_itr(cin);
    istream_iterator<int> end;

    std::vector<int> vec;

    while(int_itr != end) {
        vec.push_back(*int_itr++);
    }
    std::vector<int>::iterator i;
    for ( std::vector<int>::iterator i = vec.begin(); i != vec.end(); ++i)
    {
        cout << *i << endl;
    }

    return 0;
}