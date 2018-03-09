#include <iostream>
#include <vector>

using namespace std;

class Example {
public:
    //static double rate = 6.5;
    static const int vecSize = 20;
    static vector<double> vec;

    int num = 100;

    class a {};
    a printA();
};

//double Example::rate;

//vector<double> Example::vec(::Example::vecSize);
vector<double> Example::vec;

Example::a Example::printA() {
    cout << num;
}

int main() {
    int size = 10;
    vector<double> vec(size);
    cout << Example::vec.size();
    cout << "Hello, World!" << endl;
    return 0;
}