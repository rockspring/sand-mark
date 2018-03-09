#include <iostream>

using namespace std;

void test1() {
    try {
        throw exception();
    } catch (exception) {
        cout << "catch exception" << endl;
    }
}

void test2() {
    try {
        {
            overflow_error e = overflow_error("overflow_error");
            throw &e;
        }

    } catch (exception *e) {
        cout << "catch exception: " << string(e->what()) << endl;
    }
}

void test3() {
    overflow_error e = overflow_error("overflow_error");
    throw &e;
}

void test31() {
    overflow_error *e = new overflow_error("overflow_error");
    throw e;
}

void test4() {
    try {
        test31();

    } catch (exception *e) {
        cout << "catch exception: " << string(e->what()) << endl;
    }
}

void test5a() noexcept{
    overflow_error e = overflow_error("overflow_error");
    throw e;
}

void test5b(){
    overflow_error e = overflow_error("overflow_error");
    throw e;
}

void test5() {
    try {
        test5a();
    } catch (exception e) {
        cout << "catch exception: " << string(e.what()) << endl;
    }
}

void test6a() noexcept(true){
    overflow_error e = overflow_error("overflow_error");
    throw e;
}

void test6b() noexcept(false){
    overflow_error e = overflow_error("overflow_error");
    throw e;
}

void test6c() noexcept{

}



void test6() {
    try {
        test6b();
    } catch (exception &e) {
        cout << "catch exception: " << string(e.what()) << endl;
    }

    bool has_except = noexcept(test6a());

    cout << boolalpha << has_except << endl;

    has_except = noexcept(test6a);

    cout << boolalpha << has_except << endl;

    has_except = noexcept(test6b());

    cout << boolalpha << has_except << endl;

    has_except = noexcept(test6b);

    cout << boolalpha << has_except << endl;

    has_except = noexcept(test6c());

    cout << boolalpha << has_except << endl;

    has_except = noexcept(test6c);

    cout << boolalpha << has_except << endl;
}

void test7a() {
    cout << "test7a" << endl;
}

void test7b() noexcept{
    cout << "test7b" << endl;
}

void test7() {
    //void (*pf1) () noexcept = test7a;
    void (*pf1) () noexcept = test7b;

    pf1();
}

class Test8ASuper {
public:
    virtual void test8a() noexcept {cout << "Test8ASuper.test8a" << endl; };
};

class Test8ADerived : public Test8ASuper {
public:
    virtual void test8a() noexcept {cout << "Test8ADerived.test8a" << endl; };
};

class Test8BDerived : public Test8ASuper {
public:
    //virtual void test8a() {cout << "Test8BDerived.test8a" << endl; }; //错误，子类的重载函数异常说明更宽松了
};

void test8() {
    Test8ADerived test8ADerived =  Test8ADerived();
    Test8ASuper& test8ASuper = test8ADerived;
    test8ASuper.test8a();
}



int main() {
    //test2();

    //test4();
    //test5();
    //test6();
    //test7();
    test8();
    return 0;
}