#include <iostream>
#include <array>

using namespace std;

template<typename T>
void print(T& arr) {
    cout << "......" << endl;
    for(int i : arr) {
        cout << i << endl;
    }
    cout << "......" << endl;
}

int main() {
    array<int, 3> a = {1,3,2};
    print(a);
    a.fill(1);
    print(a);
    
    //元素访问
    cout << a[3] << endl;
    //cout << a.at(3) << endl;
    
    cout << a.front() << endl;
    cout << a.back() << endl;

    return 0;
}
