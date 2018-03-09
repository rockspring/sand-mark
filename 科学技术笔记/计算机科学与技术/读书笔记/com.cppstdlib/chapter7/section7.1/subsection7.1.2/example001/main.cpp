#include <iostream>
#include <vector>
#include <unordered_set>
#include <string>
#include <list>
#include <set>
#include <deque>

using namespace std;

int main() {
    vector<int> v1 = {1, 2, 3, 5, 7, 11, 13, 17, 21};
    
    vector<int> v2{1, 2, 3, 5, 7, 11, 13, 17, 21};
    
    vector<int> v3({1, 2, 3, 5, 7, 11, 13, 17, 21});
    
    unordered_set<string> w1 = {"hello", string(), ""};
    
    unordered_set<string> w2{"hello", string(), ""};

    unordered_set<string> w3({"hello", string(), ""});
    
    list<int> l = {1, 2, 3};
    
    vector<float> c(l.begin(), l.end());
    
    list<string> l1 = {"aaa", "bbb", "ccc"};
    vector<string> c2(make_move_iterator(l1.begin()), make_move_iterator(l1.end()));
    
    cout << l1.size() << endl;
    cout << *l1.begin() << endl;
    
    int carray[] = {2, 3, 17, 33, 45, 77};
    set<int> set1(begin(carray), end(carray));
    
    deque<int> deque1{istream_iterator<int>(cin), istream_iterator<int>()};
    cout << *deque1.begin() << endl;
    cout << deque1.size() << endl;
    
    deque<int> deque2((istream_iterator<int>(cin)), istream_iterator<int>());

    vector<int> v4 = {1, 2, 3};
    vector<int> v5 = std::move(v4);
    cout << v5.size() << endl;
    
    for(auto elem : v5) {
        cout << elem << endl;
        elem = elem*elem;
    }
    
    for(auto& elem : v5) {
        cout << elem << endl;
        elem = elem*elem;
    }
    
    for(auto elem : v5) {
        cout << elem << endl;
    }


    return 0;
}
