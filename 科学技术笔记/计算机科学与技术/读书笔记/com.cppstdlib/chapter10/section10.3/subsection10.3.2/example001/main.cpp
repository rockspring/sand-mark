#include <iostream>
#include <vector>

using namespace std;

int main() {
    vector<int> coll = {1, 2, 3, 4, 5, 6, 7, 8};
    long sum = 0;
    for_each(coll.begin(), coll.end(), [&sum] (int elem) noexcept {
        sum += elem;
    });
    
    double mv = static_cast<double>(sum)/static_cast<double>(coll.size());
    
    cout << "mean value: " << mv << endl;
    
    auto sum_lambda = [=] (int elem) mutable noexcept -> int {
        sum = 0;
        return sum + elem;
    };
    sum = 1;
    cout << sum_lambda(10) << endl;
    return 0;
}
