#include <iostream>
#include <utility>

using namespace std;

int main() {
    pair<int, int> p(1,2);
    
    cout << p.first << endl;
    
    cout << p.second << endl;
    
    cout << tuple_size<pair<int, int>>::value << endl;
    
    cout << tuple_element<0, pair<int, int>>::type() << endl;
    
    cout << tuple_element<1, pair<int, int>>::type() << endl;
    
    pair<int, int> p1(1,'a');
    
    cout << "xxx" << endl;
    
    cout << tuple_element<0, pair<int, char>>::type() << endl;
    
    cout << tuple_element<1, pair<int, char>>::type() << endl;

    return 0;
}
