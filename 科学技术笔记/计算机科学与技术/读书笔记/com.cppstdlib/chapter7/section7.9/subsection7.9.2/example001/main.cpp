#include <iostream>
#include <unordered_set>

using namespace std;

int main() {
    unordered_set<int> a = {1, 2};
    cout << a.hash_function()(1) << endl;
    cout << a.key_eq()(1, 2) << endl;
    cout << a.bucket_count() << endl;
    cout << a.max_bucket_count() << endl;
    cout << a.load_factor() << endl;
    cout << a.max_load_factor() << endl;
    a.rehash(4);
    
    cout << a.hash_function()(1) << endl;
    cout << a.key_eq()(1, 2) << endl;
    cout << a.bucket_count() << endl;
    cout << a.max_bucket_count() << endl;
    cout << a.load_factor() << endl;
    cout << a.max_load_factor() << endl;
    
    a.reserve(4);
    cout << a.hash_function()(1) << endl;
    cout << a.key_eq()(1, 2) << endl;
    cout << a.bucket_count() << endl;
    cout << a.max_bucket_count() << endl;
    cout << a.load_factor() << endl;
    cout << a.max_load_factor() << endl;
    
    pair<unordered_set<int>::iterator, unordered_set<int>::iterator> ret;
    ret = a.equal_range(1);
    
    cout << "安插元素之后" <<endl;

    cout << *ret.first << endl;
    cout << (ret.second != a.end()) << endl;
    cout << "安插元素之后" <<endl;

    cout << (++ret.first == a.end()) << endl;
    cout << "安插元素之后" <<endl;

    
    //安插和移动元素
    unordered_set<int>::iterator pos = a.find(2);
    cout << *++pos << endl;

    cout << "安插元素之后" <<endl;

    
    a.insert(3);
    a.insert(4);
    a.insert(5);
    //a.emplace(4, 5, 6);
    cout << "安插元素之后" <<endl;
    pos = a.find(4);
    //cout << *++pos << endl;
    //cout << *++pos << endl;
    
    a.insert(pos, 6);
    for(auto elem : a) {
        cout << elem << endl;
    }
    cout << endl;
    
    a.insert({10, 11});
    for(auto elem : a) {
        cout << elem << endl;
    }
    cout << endl;

    a.emplace(12);
    for(auto elem : a) {
        cout << elem << endl;
    }
    cout << endl;
    
    pair<unordered_set<int>::iterator, bool> emplace_result = a.emplace(13);
    cout << emplace_result.second << endl;
    cout << *emplace_result.first << endl;


    return 0;
}
