#include <iostream>

using namespace std;

//其它相应资源的Deleter

class ClassA {
    
};

class ClassADeleter {
public:
    void operator()(ClassA *p) {
        cout << "call delete for ClassA object" << endl;
        delete p;
    }
};

int main() {
    unique_ptr<ClassA, ClassADeleter> up(new ClassA());
    return 0;
}
