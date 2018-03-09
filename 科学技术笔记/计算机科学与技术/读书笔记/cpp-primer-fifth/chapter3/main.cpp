#include <iostream>
#include <vector>

using namespace std;

int main() {
    vector<int> ivec;
    ivec = {1, 2};

    vector<int>::size_type n = 10;

    vector<int> v1;
    vector<int> v2(v1);
    vector<int> v3 = v1;
    vector<int> v4(n, 1);
    vector<int> v5{1, 2, 3, 4}; // initializer list c++11
    vector<int> v6 = {1, 2, 3, 4}; // initializer list c++11

    int a = 0b100;

    v6[0] = 2;

    for(int i : v6) {
        cout << i << endl;
    }

    char char_arr[] = "abc";
    char *char_ptr = "abc";

    string string1(char_arr);

    cout << string1 << endl;

    string1.c_str();
    return 0;
}