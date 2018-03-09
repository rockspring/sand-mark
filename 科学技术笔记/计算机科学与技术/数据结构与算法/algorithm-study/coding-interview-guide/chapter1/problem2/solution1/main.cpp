#include <iostream>
#include <stack>

using namespace std;

class TwoStackQueue {
public:
    void add(int value) {
        stackPush.push(value);
    }
    
    int poll() {
        if (stackPush.empty() && stackPop.empty()) {
            throw exception();
        }
        if (stackPop.empty()) {
            while (!stackPush.empty()) {
                stackPop.push(stackPush.top());
                stackPush.pop();
            }
        }
        int value = stackPop.top();
        stackPop.pop();
        
        return value;
    }
    
    int peek() {
        if (stackPush.empty() && stackPop.empty()) {
            throw exception();
        }
        if (stackPop.empty()) {
            while (!stackPush.empty()) {
                stackPop.push(stackPush.top());
                stackPush.pop();
            }
        }
        int value = stackPop.top();
        return value;
    }
private:
    stack<int> stackPush;
    stack<int> stackPop;
};

int main() {
    cout << "sizeof(int)=" << sizeof(int) << endl;
    
    TwoStackQueue queue;
    queue.add(1);
    queue.add(2);
    queue.add(3);
    int value;
    value = queue.poll();
    cout << "poll:" << value << endl;
    value = queue.poll();
    cout << "poll:" << value << endl;
    value = queue.poll();
    cout << "poll:" << value << endl;
    
    queue.add(4);
    queue.add(5);
    queue.add(6);
    value = queue.poll();
    cout << "poll:" << value << endl;
    value = queue.poll();
    cout << "poll:" << value << endl;
    value = queue.poll();
    cout << "poll:" << value << endl;

    return 0;
}
