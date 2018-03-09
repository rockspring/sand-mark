#include <iostream>
#include <atomic>
#include <cassert>

using namespace std;

int main() {
    std::atomic_flag f = ATOMIC_FLAG_INIT;
    f.test_and_set(std::memory_order_seq_cst);

    std::atomic<bool> f1(true);
    cout << boolalpha << f1.load() << endl;
    f1.store(false);
    cout << boolalpha << f1.load() << endl;

    bool flag = false;
    f1.compare_exchange_weak(flag, true);
    cout << boolalpha << f1.load() << endl;
    cout << boolalpha << flag << endl;


    class Foo {};
    Foo some_array[5];
    std::atomic<Foo *> p(some_array);
    Foo *x = p.fetch_add(2);

    assert(x == some_array);
    assert(p.load() == &some_array[2]);
    return 0;
}