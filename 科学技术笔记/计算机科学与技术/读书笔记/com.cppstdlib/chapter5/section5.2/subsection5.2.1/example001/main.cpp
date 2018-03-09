//
//  main.cpp
//  xcode-demo
//
//  Created by zlq on 9/26/15.
//  Copyright © 2015 zlq. All rights reserved.
//

#include <iostream>
#include <memory>
#include <string>
#include <list>
#include <vector>
#include <time.h>
#include <new>
#include <utility>
#include <tuple>

using std::string;
using std::shared_ptr;
using std::make_shared;
using std::cout;
using std::endl;
using std::list;
using std::vector;
using std::nothrow;
using std::unique_ptr;
using std::weak_ptr;
using std::allocator;
using std::uninitialized_copy;
using std::uninitialized_fill_n;

using std::pair;
using std::tuple;

void test() {
    shared_ptr<string> p1;
    cout << p1 << endl;
    
    shared_ptr<list<int>> p2;
    cout << p2 << endl;
    
    if (p1 && p1->empty()) {
        *p1 = "hi";
    }
    
    cout << p1 << endl;
    
    //make_shared 函数
    shared_ptr<int> p3 = make_shared<int>(42);
    cout << p3 << endl;
    cout << *p3 << endl;
    
    cout << p3.use_count() << endl;
    shared_ptr<int> p4(p3);
    
    cout << "p3的指针数量" << p3.use_count() << endl;
    cout << "p4的指针数量" << p4.use_count() << endl;
    
    //创建一个新的智能共享指针p5，将p5赋值给p4，观察p4、p5的指针数量
    shared_ptr<int> p5 = make_shared<int>(88);
    p4 = p5;
    
    cout << "p4的指针数量" << p4.use_count() << endl;
    cout << "p5的指针数量" << p5.use_count() << endl;
    
    p4 = nullptr;
    cout << "p4的指针数量" << p4.use_count() << endl;
    cout << "p5的指针数量" << p5.use_count() << endl;
}

void test1() {
    shared_ptr<string> p = make_shared<string>(10, '9');
    cout << *p << endl;
}

void test2() {
    //linux操作系统上初始化值为0，Mac上随意
    shared_ptr<int> p = make_shared<int>();
    cout << *p << endl;
}

void test3() {
    auto p = make_shared<vector<string>>();
    cout << p << endl;
}

void test_time() {
    time_t now_seconds = time(NULL);
    cout << now_seconds << endl;
    tm* next_run_time = localtime(&now_seconds);
    
    cout << next_run_time->tm_hour << endl;
    
    next_run_time->tm_hour = 5;
    
    time_t local_now_seconds = mktime(next_run_time);
    cout << local_now_seconds << endl;
    
    local_now_seconds += 24*60*60;
    cout << local_now_seconds << endl;
    
    next_run_time = localtime(&local_now_seconds);
    
    cout << next_run_time->tm_hour << endl;
    
    tm* next_run_time_tm = localtime(&local_now_seconds);
    char next_run_time_str[64];
    strftime(next_run_time_str, 63, "%F %r", next_run_time_tm);
    
    cout << string(next_run_time_str) << endl;
}

void test4() {
    string s = "a";
    auto p = new auto(s);
    cout << *p << endl;
}

void test5() {
    const int *pci = new const int(1024);
    cout << *pci << endl;
    pci = new int(1);
    
    const string *pcs = new const string();
    cout << *pcs << endl;
}

void test6() {
    int *p1 = new int;
    cout << *p1 << endl;
    
    int *p2 = new (nothrow) int;
    
    cout << *p2 << endl;
}

void test7() {
    int *p = new int;
    delete p;
}

void test8() {
    unique_ptr<string> p1(new string("汉字"));
    unique_ptr<string> p2(p1.release());
    cout << *p2 << endl;
    
    p2.reset();
    cout << *p2 << endl;
}

void test9() {
    shared_ptr<int> p;
    {
        p = shared_ptr<int>(new int(10));
    }
    weak_ptr<int> p2(p);
    cout << *p2.lock() << endl;
    
}

void test10() {
    char *cp = new char[0];
    cout << cp << endl;
    
    delete [] cp;
}

void test11() {
    unique_ptr<int[]> up(new int[10]);
    for (int i = 0; i != 10; ++i) {
        up[i] = i;
    }
    for (int i = 0; i != 10; ++i) {
        cout << up[i] << endl;
    }
    up.release();
}

void test12() {
    shared_ptr<int> sp(new int[10], [](int *p) {delete [] p;});
    for (int i = 0; i != 10; ++i) {
        *(sp.get() + i) = i;
    }
    
    for (int i = 0; i != 10; ++i) {
        cout << *(sp.get() + i) << endl;
    }
    sp.reset();
}

void test13() {
    allocator<string> alloc;
    auto p = alloc.allocate(10);
    alloc.construct(p++, 10, 'c');
    cout << *(p-1) << endl;
    alloc.destroy(--p);
    alloc.deallocate(p, 10);
}

void test14() {
    vector<int> vi = {1, 2, 3};
    allocator<int> alloc;
    auto p = alloc.allocate(vi.size() * 2);
    auto q = uninitialized_copy(vi.begin(), vi.end(), p);
    uninitialized_fill_n(q, vi.size(), 42);
    
    for (int i = 0; i < vi.size() * 2; ++i) {
        cout << *(p+i) << endl;
    }
}

class Foo {
public:
    Foo(tuple<int, float> t) {
        cout << "Foo::Foo(tuple)" << endl;
    }
    
    template<typename ...Args>
    Foo(Args... args) {
        cout << "Foo::Foo(args...)" << endl;
    }
};

void test15() {
    tuple<int, float> t(1, 2.22);
    pair<int,Foo> p1(42, t);
    pair<int,Foo> p2(std::piecewise_construct, std::make_tuple(42), t);
}

void test16() {
    pair<char, char> p = std::make_pair('x', 'y');
    
    char c;
    std::tie(std::ignore, c) = p;
    cout << c;
    p.second = 'z';
    //c = 'z';
    cout << c;
    cout << p.second;
}


int main()
{
    //test1();
    //test2();
    //test3();
    //test_time();
    //test4();
    //test5();
    //test6();
    //test7();
    //test8();
    //test9();
    //test10();
    //test11();
    //test12();
    //test13();
    //test14();
    //test15();
    test16();
}

