#include <iostream>
#include <string>

using namespace std;

int process(int num, string left, string mid, string right, string from, string to) {
    if (num == 1) {
        if (from == mid || to == mid) {
            cout << "Move 1 from " << from << " to " + to << endl;
            return 1;
        } else {
            cout << "Move 1 from " << from << " to " + mid << endl;
            cout << "Move 1 from " << mid << " to " + to << endl;
            return 2;
        }
    } else if (from == mid || to == mid) {
        string another = (from == left || to == left) ? right : left;
        int part1 = process(num-1, left, mid, right, from, another);
        int part2 = 1;
        cout << "Move 1 from " << from << " to " << to << endl;
        int part3 = process(num-1, left, mid, right, another, to);
        return part1 + part2 + part3;
    } else {
        int part1 = process(num-1, left, mid, right, from, to);
        int part2 = 1;
        cout << "Move 1 from " << from << " to " << mid << endl;
        int part3 = process(num-1, left, mid, right, to, from);
        int part4 = 1;
        cout << "Move 1 from " << mid << " to " << to << endl;
        int part5 = process(num-1, left, mid, right, from, to);
        return part1 + part2 + part3 + part4 + part5;
    }
}

int hanoiProblem(int num, string left, string mid, string right) {
    if (num < 1) {
        return 0;
    }
    
    return process(num, left, mid, right, left, right);
}

int main() {
    cout << "sizeof(int)=" << sizeof(int) << endl;

    int steps = hanoiProblem(8, "left", "mid", "right");
    cout << "steps=" << steps << endl;
    return 0;
}
