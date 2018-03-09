#include <iostream>
#include <stack>

using namespace std;

void sortStackByStack(stack<int> &toSort) {
    stack<int> help;
    while (!toSort.empty()) {
        int cur = toSort.top();
        toSort.pop();
        while (!help.empty() && cur > help.top()) {
            toSort.push(help.top());
            help.pop();
        }
        help.push(cur);
    }
    
    while (!help.empty()) {
        toSort.push(help.top());
        help.pop();
    }
    
    
}

int main() {
    cout << "sizeof(int)=" << sizeof(int) << endl;

    stack<int> toSort;
    toSort.push(2);
    toSort.push(3);
    toSort.push(1);
    
    sortStackByStack(toSort);
    while (!toSort.empty()) {
        cout << toSort.top();
        toSort.pop();
    }
    return 0;
}
