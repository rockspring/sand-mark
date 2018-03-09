#include <thread>
#include <mutex>
#include <atomic>
#include <cassert>
#include <string>
#include <iostream>
 
std::atomic<std::string*> ptr;
int data;
std::mutex mtx;
 
void producer()
{
    //std::this_thread::sleep_for(std::chrono::seconds(1));
    std::string* p  = new std::string("Hello");
    data = 42;
    ptr.store(p, std::memory_order_relaxed);
    
    std::lock_guard<std::mutex>lck(mtx); 
    std::cout << "producer" << std::this_thread::get_id() << " data=" << data << std::endl;
    std::cout << "producer" << std::this_thread::get_id() << " p=" << *p << std::endl;
}
 
void consumer()
{
    std::string* p2 = new std::string("consumer");
    p2 = ptr.load(std::memory_order_relaxed);
    //while (!(p2 = ptr.load(std::memory_order_relaxed)))
        //;
    //assert(*p2 == "Hello"); // never fires
    //assert(data == 42); // never fires
    
    std::lock_guard<std::mutex>lck(mtx); 
    std::cout << std::this_thread::get_id() << " data=" << data << std::endl;
    std::cout << std::this_thread::get_id() << " p=" << *p2 << std::endl;
}
 
int main()
{
    ptr.store(new std::string("abcd"));
    std::cout << *ptr.load();
    std::thread t1(producer);
    std::thread t2(consumer);
    t1.join(); t2.join();
}
