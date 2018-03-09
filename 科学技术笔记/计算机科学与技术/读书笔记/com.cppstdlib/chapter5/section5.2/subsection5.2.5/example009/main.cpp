#include <iostream>

using namespace std;

//unique_ptr被当作成员
//这个版本使用原始指针

class ClassA {
private:
    int val_;
public:
    ClassA(int val):val_(val){
    }
    
    ~ClassA() {
        cout << "~ClassA()" << endl;
    }
};

class ClassB {
private:
    ClassA *ptr1;
    ClassA *ptr2;
public:
    ClassB(int val1, int val2):ptr1(new ClassA(val1)), ptr2(new ClassA(val2)) {
    }
    
    ClassB(const ClassB& x):ptr1(new ClassA(*x.ptr1)), ptr2(new ClassA(*x.ptr2)) {
        
    }
    
    const ClassB& operator= (const ClassB& x) {
        *ptr1 = *x.ptr1;
        *ptr2 = *x.ptr2;
        return *this;
    }
    
    ~ClassB() {
        cout << "~ClassB()" << endl;
        delete ptr1;
        delete ptr2;
    }
};

int main() {
    ClassB class_b(1, 2);

    return 0;
}
