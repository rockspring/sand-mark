#include <iostream>

using namespace std;

template<typename T>
class queue {
private:
    struct node {
        std::shared_ptr<T> data;
        std::unique_ptr<node> next;
    };
    std::unique_ptr<node> head; // 1
    node *tail; // 2

public:
    queue():head(new node),tail(head.get()) { }

    queue(const queue &other) = delete;

    queue &operator=(const queue &other) = delete;

    std::shared_ptr<T> try_pop() {
        if(head.get()==tail) {
            return std::shared_ptr<T>();
        }
        std::shared_ptr<T> const res(head->data);
        std::unique_ptr<node> const old_head = std::move(head);
        head = std::move(old_head->next); // 3
        return res;
    }

    void push(T new_value) {
        std::shared_ptr<T> new_data(std::make_shared<T>(std::move(new_value)));
        std::unique_ptr<node> p(new node);
        tail->data=new_data;
        node *const new_tail = p.get();
        if (tail) {
            tail->next = std::move(p); // 4
        } else {
            head = std::move(p); // 5
        }
        tail = new_tail; // 6
    }
};

int main() {
    cout << "Hello, World!" << endl;
    return 0;
}