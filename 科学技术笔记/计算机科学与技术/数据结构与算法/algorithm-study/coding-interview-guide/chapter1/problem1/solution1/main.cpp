#include <iostream>
#include <stack>

using namespace std;

class MyStack {
public:
    MyStack() {
        
    }
    
    void push(int newNum) {
        if (stackMin.empty()) {
            stackMin.push(newNum);
        } else if (newNum <= stackMin.top()) {
            stackMin.push(newNum);
        }
        stackData.push(newNum);
    }
    
    int pop() {
        if (stackData.empty()) {
            throw std::exception();
        }
        
        int value = stackData.top();
        stackData.pop();
        
        if (value == stackMin.top()) {
            stackMin.pop();
        }
        
        return value;
    }
    
    int getMin() {
        if (stackMin.empty()) {
            throw std::exception();
        }
        return stackMin.top();
    }
    
    bool empty() {
        return stackData.empty() && stackMin.empty();
    }
    
private:
    std::stack<int> stackData;
    std::stack<int> stackMin;
    
};


int main() {
    cout << "sizeof(int)=" << sizeof(int) << endl;
    MyStack myStack;
    
    try {
        int min = myStack.getMin();
        cout << "myStack.getMin=" << min << endl;
    } catch (exception e) {
        cout << e.what() << endl;
    }
    
    try {
        int pop = myStack.pop();
        cout << "myStack.pop=" << pop << endl;
    } catch (exception e) {
        cout << e.what() << endl;
    }
    
    try {
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        myStack.push(2);
        myStack.push(2);
        
        while (!myStack.empty()) {
            int min = myStack.getMin();
            cout << "myStack.getMin=" << min << endl;
            int pop = myStack.pop();
            cout << "myStack.pop=" << pop << endl;

        }
    } catch (exception e) {
        cout << e.what() << endl;
    }
    
    

    return 0;
}
