#include <iostream>
#include <string>
#include <vector>
#include <functional>
#include <algorithm>

using namespace std;

class A {
public:
    A(const string &data):data_(data){}
    bool empty() const;
//private:
    string data_;
};

bool A::empty() const {
    return true;
}

int main() {
    vector<A> svec;
    svec.push_back(A("aaa"));
    //auto fp = &string::empty;
    
    //find_if(svec.begin(), svec.end(), fp);
    function<bool (const A&)> fcn = &A::empty;
    vector<A>::iterator found =
    find_if(svec.begin(), svec.end(), fcn);
    
    cout << found->data_ << endl;
    
    
    vector<A>::iterator found2 =
    find_if(svec.begin(), svec.end(), mem_fn(&A::empty));
    
    cout << found2->data_ << endl;
    
    vector<A>::iterator found3 =
    find_if(svec.begin(), svec.end(), bind(&A::empty, std::placeholders::_1));
    
    cout << found2->data_ << endl;

    return 0;
}
