#include <iostream>
#include <memory>

using namespace std;

int main() {
    unique_ptr<int, void(*)(int *)> up(new int[10], [](int *p) {
        delete []p;
    });
    
    (*up) = 0;
    
    cout << (*up) << endl;
    
    unique_ptr<int, function<void(int*)>> up2(new int[10], [](int *p) {
        delete []p;
    });
    
    (*up2) = 1;
    
    cout << (*up2) << endl;
    
    auto l = [](int *p) {
        delete []p;
    };
    
    unique_ptr<int, decltype(l)> up3(new int[10], l);
    
    (*up3) = 1;
    
    cout << (*up3) << endl;
    return 0;
}
