#include <iostream>
#include <memory>

using namespace std;

template<typename T>
class lock_free_stack {
private:
    struct node {
        std::shared_ptr<T> data;
        std::shared_ptr<node> next;

        node(T const &data_):data(std::make_shared<T>(data_)) {
        }
    };

    std::shared_ptr<node> head;

public:
    void push(T const &data) {
        std::shared_ptr<node> const new_node = std::make_shared<node>(data);
        new_node->next = head.get();
        while (!std::atomic_compare_exchange_weak(&head, &new_node->next, new_node));
    }
};

template<typename T>
struct node {
    std::shared_ptr<T> data;
    std::shared_ptr<node> next;

    node(T const &data_):data(std::make_shared<T>(data_)) {
    }
};

std::shared_ptr<node<int>> head;

std::shared_ptr<int> i;

std::shared_ptr<atomic_flag> f;

struct aa {
    int a;
    int *b;
};

std::atomic<int> a;

std::atomic<aa> bbb;
aa aaa = {1,0};



aa ccc = {1,0};

int main() {
    cout << "std::atomic_is_lock_free(&some_shared_pointer)" << std::atomic_is_lock_free(&f) << endl;

    int b=0;
    aa ddd = {10,0};
    bbb.store(aaa);
    cout << bbb.load().a << endl;
    cout << ccc.a << endl;
    bbb.compare_exchange_weak(ccc, ddd);

    if (aaa == ccc) {
        cout << "aaa==ccc" << endl;
    }

    cout << bbb.load().a << endl;
    return 0;
}