#include <iostream>
#include <stack>

using namespace std;

int firstDeep;
int secondDeep;

int getAndRemoveLastElement(stack<int> *p) {
    cout << "getAndRemoveLastElement";
    for (int i=0; i < secondDeep; i++) {
        cout << "-";
    }
    cout << endl;
    secondDeep++;
    int result = p->top();
    p->pop();
    if (p->empty()) {
        secondDeep--;
        return result;
    } else {
        int last = getAndRemoveLastElement(p);
        cout << secondDeep << " last=" << last << endl;
        p->push(result);
        secondDeep--;
        return last;
    }
}

void reverse(stack<int> *p) {
    cout << "reverse";
    for (int i=0; i < firstDeep; i++) {
        cout << "-";
    }
    cout << endl;
    firstDeep++;
    if (p->empty()) {
        return;
    }
    
    int last = getAndRemoveLastElement(p);
    cout << firstDeep << " reverse last=" << last << endl;
    reverse(p);
    p->push(last);
}

int main() {
    cout << "sizeof(int)=" << sizeof(int) << endl;
    stack<int> *p = new stack<int>;
    p->push(1);
    p->push(2);
    p->push(3);
    //getAndRemoveLastElement(p);
    
    reverse(p);

    delete p;
    return 0;
}
