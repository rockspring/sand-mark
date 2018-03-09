#include <iostream>
#include <array>

using namespace std;

void print(const array<int, 4>& arr) {
    for(int i : arr) {
        cout << i << endl;
    }
}

template<typename T>
void print(T& arr) {
    for(int i : arr) {
        cout << i << endl;
    }
}

int main() {
    array<int, 4> x; //初值不明确，不一定是0
    print(x);
    
    array<int, 4> x1 = {};
    print(x1);
    
    array<int, 5> x2 = {{42, 377, 611, 21, 44}};
    print(x2);
    
    array<int, 10> x3 = {{42}};
    print(x3);
    
    array<int, 5> x4 = {1, 2, 3, 4, 5};
    print(x4);
    
    x4 = std::move(x2);
    print(x4);
    
    sort(x4.begin(), x4.end());
    print(x4);

    
    return 0;
}
