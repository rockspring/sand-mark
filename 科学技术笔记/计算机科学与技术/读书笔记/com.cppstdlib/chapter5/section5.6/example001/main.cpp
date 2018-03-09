#include <iostream>
#include <ratio>

using namespace std;

int main() {
    cout << ratio<5, 3>::num << "/" << ratio<5, 3>::den << endl;
    
    cout << ratio<25, 15>::num << "/" << ratio<25, 15>::den << endl;
    
    cout << ratio_add<ratio<2, 7>, ratio<2, 6>>::num << endl;
    
    cout << ratio_add<ratio<2, 7>, ratio<2, 6>>::den << endl;
    
    //ratio_multiply<ratio<1, numeric_limits<long long>::max()>, ratio<1, 2>>::den;//编译出错

    return 0;
}
