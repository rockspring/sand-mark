#include <iostream>
#include <list>
#include <forward_list>

using namespace std;

void removeLastKthNode(list<int> &l, int k){
    if (l.empty() || k < 1) {
        return;
    }
    list<int>::iterator itr = l.begin();
    while (itr != l.end()) {
        k--;
        itr++;
    }
    if (k > 0) {
        return;
    } else if (k == 0) {
        l.pop_front();
    } else {
        itr = l.begin();
        while (k != 0) {
            k++;
            itr++;
        }
        cout << "to erase:" << *itr << endl;
        l.erase(itr);
    }
}

void removeLastKthNode(forward_list<int> &l, int k){
    if (l.empty() || k < 1) {
        return;
    }
    forward_list<int>::iterator itr = l.begin();
    while (itr != l.end()) {
        k--;
        itr++;
    }
    if (k > 0) {
        return;
    } else if (k == 0) {
        l.pop_front();
    } else {
        cout << "k=" << k << endl;
        itr = l.before_begin();
        while (k != 0) {
            k++;
            itr++;
        }
        cout << "to erase:" << *itr << endl;
        l.erase_after(itr);
        //l.erase(itr);
    }
}


int main() {
    cout << "sizeof(int)=" << sizeof(int) << endl;
    list<int> l = {1, 2, 3, 4, 5, 6, 7};
    removeLastKthNode(l, 3);
    
    for (auto current = l.cbegin(); current != l.cend(); current++) {
        cout << *current << " ";
    }
    
    cout << endl;
    
    forward_list<int> l2 = {1, 2, 3, 4, 5, 6, 7};
    removeLastKthNode(l2, 3);
    
    for (auto current = l2.cbegin(); current != l2.cend(); current++) {
        cout << *current << " ";
    }
    
    cout << endl;

    return 0;
}
