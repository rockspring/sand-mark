#include <iostream>
#include <thread>

using namespace std;

std::mutex m;

void log(__thread_id thread_id, string s) {
    lock_guard<std::mutex> l(m);
    cout << "thread:" << thread_id << " " << s << endl;
}

template<typename T>
class lock_free_stack {
private:
    struct node;
    struct counted_node_ptr {
        int external_count;
        node *ptr;
    };

    struct node {
        std::shared_ptr<T> data;
        std::atomic<int> internal_count;
        counted_node_ptr next;

        node(T const &data_) :
                data(std::make_shared<T>(data_)),
                internal_count(0) { }
    };

    std::atomic<counted_node_ptr> head;

    void increase_head_count(counted_node_ptr &old_counter) {
        cout << "increase_head_count 1,head:" << &head << endl;
        counted_node_ptr new_counter;
        do {
            cout << "loop.........................." << endl;
            new_counter = old_counter;
            ++new_counter.external_count;
            cout << "head != old_counter" << endl;
        }
        while (!head.compare_exchange_strong(old_counter, new_counter));
        old_counter.external_count = new_counter.external_count;
        cout << "increase_head_count 2,head:" << &head << endl;
    }

public:
    ~lock_free_stack() {
        //while (pop());
        cout << "";
    }

    void push(T const &data) {
        counted_node_ptr new_node;
        new_node.ptr = new node(data);
        new_node.external_count = 1;
        new_node.ptr->next = head.load();
        while (!head.compare_exchange_weak(new_node.ptr->next, new_node));
    }

    std::shared_ptr<T> pop() {
        log(std::this_thread::get_id(),"start pop()................................................");
        counted_node_ptr old_head = head.load();
        for (; ;) {
            increase_head_count(old_head);
            cout << "pop2,old_head:" << &old_head << endl;

            node *const ptr = old_head.ptr;
            if (!ptr) {
                return std::shared_ptr<T>();
            }
            counted_node_ptr temp = head.load();
            cout << "temp:" << &temp<< endl;
            if (head.compare_exchange_strong(old_head, ptr->next)) {
                cout << "head == old_head" << endl;
                cout << "pop2,head:" << &head << endl;
                std::shared_ptr<T> res;
                res.swap(ptr->data);

                int const count_increase = old_head.external_count - 2;
                cout << "count_increase " << count_increase << endl;
                if (ptr->internal_count.fetch_add(count_increase) == -count_increase) {
                    cout << "delete prt:" << &ptr << endl;
                    delete ptr;
                }
                cout << "before return" << endl;
                return res;
                cout << "after return" << endl;
            }
            else if (ptr->internal_count.fetch_sub(1) == 1) {

                cout << "ptr->internal_count.fetch_sub(1) == 1" <<endl;
                delete ptr;
            }
        }

        cout << "finish pop()................................................" << endl;
    }
};


lock_free_stack<int> stack;
void task1() {
    int *result = stack.pop().get();
    cout << "result:" << *result << endl;

}

void task2() {
    int *result = stack.pop().get();
    cout << "result:" << *result << endl;
}
int main() {
    stack.push(1);
    stack.push(2);
    stack.push(3);
    int *result = stack.pop().get();
    cout << "result:" << *result << endl;
    //std::this_thread::sleep_for(1000*1000*1000);

    //task1();

    thread thread1(task1);
    thread thread2(task2);
    thread1.join();
    thread2.join();
    //return 0;
}