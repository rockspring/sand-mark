#include <iostream>
#include <atomic>

using namespace std;

template<typename T>

class lock_free_stack {
private:
    struct node {
        std::shared_ptr<T> data;
        node *next;

        node(T const &data_):data(std::make_shared(data_)) {
        }
    };

    std::atomic<node *> to_be_deleted;

    void test() {
        to_be_deleted.exchange(nullptr);
    }
};

int main() {


    cout << "Hello, World!" << endl;
    return 0;
}