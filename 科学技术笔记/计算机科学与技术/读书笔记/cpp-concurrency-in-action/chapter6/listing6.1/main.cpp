#include <iostream>
#include <exception>
#include <stack>
#include <vector>

using namespace std;

struct empty_stack : std::exception {
    const char* what() const throw();
};

template<typename T>
class threadsafe_stack {
private:
    std::stack<T> data;
    mutable std::mutex m;
public:
    threadsafe_stack() {};
    threadsafe_stack(const threadsafe_stack& other) {
        std::lock_guard<std::mutex> lock(other.m);
        data = other.data;
    }
    threadsafe_stack& operator=(const threadsafe_stack&) = delete;

    void push(T new_value) {
        std::lock_guard<std::mutex> lock(m);
        data.push(std::move(new_value)); // 1
    }

    std::shared_ptr<T> pop() {
        std::lock_guard<std::mutex> lock(m);
        if (data.empty()) throw empty_stack(); // 2
        std::shared_ptr<T> const res(std::make_shared<T>(std::move(data.top()))); // 3
        data.pop(); // 4
        return res;
    }

    void pop(T& value) {
        std::lock_guard<std::mutex> lock(m);
        if (data.empty()) throw empty_stack();
        //value = std::move(data.top()); // 5
        value = data.top(); // 5
        data.pop(); // 6
    }

    bool empty() const {
        std::lock_guard<std::mutex> lock(m);
        return data.empty();
    }
};

int main() {
    vector<int> v1 = {1, 2, 3};
    vector<int> v2 = vector<int>(std::move(v1));
    cout << "&v1=" << &v1 << endl;
    cout << "&v2=" << &v2 << endl;
    cout << "&&v1[0]" << &v1[0] << endl;
    cout << "&&v1[1]" << &v1[1] << endl;
    cout << "&&v2[0]" << &v2[0] << endl;
    return 0;
}