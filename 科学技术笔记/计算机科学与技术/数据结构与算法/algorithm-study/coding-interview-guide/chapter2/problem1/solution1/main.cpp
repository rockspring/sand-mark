#include <iostream>
#include <forward_list>

using namespace std;

void printCommonPart(forward_list<int> &first, forward_list<int> &second) {
    cout << "common part:";
    forward_list<int>::iterator iterator1 = first.begin();
    forward_list<int>::iterator iterator2 = second.begin();
    
    while (iterator1 != first.end() && iterator2 != second.end()) {
        if (*iterator1 < *iterator2) {
            iterator1++;
        } else if (*iterator2 < *iterator1) {
            iterator2++;
        } else {
            cout << *iterator1 << " ";
            iterator1++;
            iterator2++;
        }
    }
    cout << endl;
}

int main() {
    cout << "sizeof(int)=" << sizeof(int) << endl;
    forward_list<int> first_list = {1,3,5,7};
    forward_list<int> second_list = {0,3,6,7};
    
    printCommonPart(first_list, second_list);

    return 0;
}
