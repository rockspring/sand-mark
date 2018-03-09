#include <iostream>

using namespace std;

int main() {
    shared_ptr<double> p1;
    shared_ptr<int> p2(new int(42));

    {
        //shared_ptr<int> p1 = new int(1024);
        shared_ptr<int> p2(new int(1024));
    }
    {
        shared_ptr<int> p1 = make_shared<int>(1);
    }
    cout << "Hello, World!" << endl;
    return 0;
}