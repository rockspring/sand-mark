#include <iostream>
#include <stack>

using namespace std;

enum Action {
    NO,
    LToM,
    MToL,
    MToR,
    RtoM
};

int fStackTotStack(Action record[], Action preNoAct, Action nowAct, stack<int> &fStack, stack<int> &tStack,
                   string from, string to) {
    if (record[0] != preNoAct && fStack.top() < tStack.top()) {
        tStack.push(fStack.top());
        fStack.pop();
        cout << "Move " << tStack.top() << " from " << from << " to " << to << endl;
        record[0] = nowAct;
        return 1;
    } else {
        return 0;
    }
}

int hanoiProblem(int num, string left, string mid, string right) {
    stack<int> lS;
    stack<int> mS;
    stack<int> rS;
    
    lS.push(INT_MAX);
    mS.push(INT_MAX);
    rS.push(INT_MAX);
    
    for (int i=num; i > 0; i--) {
        lS.push(i);
    }
    
    Action record[1] = {NO};
    
    int step = 0;
    
    while (rS.size() != num+1) {
        step += fStackTotStack(record, MToL, LToM, lS, mS, left, mid);
        step += fStackTotStack(record, LToM, MToL, mS, lS, mid, left);
        step += fStackTotStack(record, RtoM, MToR, mS, rS, mid, right);
        step += fStackTotStack(record, MToR, RtoM, rS, mS, right, mid);
    }
    
    return step;
}

int main() {
    cout << "sizeof(int)=" << sizeof(int) << endl;

    int steps = hanoiProblem(5, "left", "mid", "right");
    cout << "steps=" << steps << endl;
    
    return 0;
}
