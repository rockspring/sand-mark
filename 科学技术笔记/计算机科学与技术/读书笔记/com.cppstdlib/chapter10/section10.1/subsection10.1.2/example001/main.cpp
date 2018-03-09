#include <iostream>
#include <list>
#include <algorithm>
#include <iterator>
#include <string>

using namespace std;

// PRINT_ELEMENTS()
// - prints optional string optstr followed by
// - all elements of the collection coll
// - in one line, separated by spaces
template <typename T>
inline void PRINT_ELEMENTS (const T& coll,
                            const std::string& optstr="")
{
    std::cout << optstr;
    for (const auto&  elem : coll) {
        std::cout << elem << ' ';
    }
    std::cout << std::endl;
}

class IntSequence {
public:
    IntSequence(int initial_value): value_(initial_value) {}
    
    int operator() () {
        return ++value_;
    }
private:
    int value_;
};

int main() {
    list<int> coll;
    generate_n(back_inserter(coll), 9, IntSequence(1));
    PRINT_ELEMENTS(coll);
    
    generate(next(coll.begin()), prev(coll.end()), IntSequence(42));
    PRINT_ELEMENTS(coll);
    

    return 0;
}
