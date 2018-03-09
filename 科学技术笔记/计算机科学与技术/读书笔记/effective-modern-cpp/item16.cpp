#include <typeinfo>
#include <iostream>
#include <vector>
#include <utility>

using namespace std;

int f1(int x) throw();

int f2(int x) noexcept;

class Widget {
public:
    int magicValue() const {
        std::lock_guard<std::mutex> guard(m); // lock m
        if (cacheValid) {
            return cachedValue;
        } else {
            auto val1 = 1;
            auto val2 = 2;
            cachedValue = val1 + val2;
            cacheValid = true;
            return cachedValue;
        }
    }
    
private:
    mutable std::mutex m;
    mutable int cachedValue;
    mutable bool cacheValid{false};
};

int main() {
    Widget w;
    int magicValue = w.magicValue();
    cout << magicValue << endl;
}
