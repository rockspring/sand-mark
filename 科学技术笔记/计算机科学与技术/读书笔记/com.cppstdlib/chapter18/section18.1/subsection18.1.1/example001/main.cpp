#include <iostream>
#include <future>
#include <thread>
#include <chrono>
#include <random>
#include <exception>

using namespace std;

int doSomething(char c) {
    std::default_random_engine der(c);
    std::uniform_int_distribution<int> id(10,10000);
    
    for (int i=0; i<10; ++i) {
        this_thread::sleep_for(chrono::milliseconds(id(der)));
        cout.put(c).flush();
    }
    
    return c;
}

int func1() {
    return doSomething('.');
}

int func2() {
    return doSomething('+');
}

int main() {
    std::cout << "starting func1() in background"
    << " and func2 in foreground:" << std::endl;
    
    //std::future<int> result1(std::async( func1));
    std::future<int> result1(std::async(std::launch::deferred, func1));//只有调用get函数时才会调用func1
    //std::future<int> result1(std::async(std::launch::async, func1));//这时如果不调用get，result1离开作用域时会调用func1
    //std::async(std::launch::async, func1);//不赋值出去，相当于同步调用
    
    //int result2 = func2();
    
    //int result = result1.get() + result2;
    //int result = result2;
    int result = 0;
    
    std::cout << "\nresult of func1() + func2(): " << result << std::endl;
    return 0;
}
