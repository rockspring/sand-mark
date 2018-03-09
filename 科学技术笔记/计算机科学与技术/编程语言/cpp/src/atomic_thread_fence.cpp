#include <thread>
#include <mutex>
#include <atomic>
#include <cassert>
#include <string>
#include <iostream>

//Global
std::string computation(int);
void print( std::string );
 
int desired[3]  = { -1, -1, -1 };
std::atomic<int> arr[3];
atomic_init(arr, desired);
std::string data[1000]; //non-atomic data
std::mutex mtx;

 
// Thread A, compute 3 values
void ThreadA( int v0, int v1, int v2 )
{
//assert( 0 <= v0, v1, v2 < 1000 );
data[v0] = computation(v0);
data[v1] = computation(v1);
data[v2] = computation(v2);
std::atomic_thread_fence(std::memory_order_release);
std::atomic_store_explicit(&arr[0], v0, std::memory_order_relaxed);
std::atomic_store_explicit(&arr[1], v1, std::memory_order_relaxed);
std::atomic_store_explicit(&arr[2], v2, std::memory_order_relaxed);
}
 
// Thread B, prints between 0 and 3 values already computed.
void ThreadB()
{
int v0 = std::atomic_load_explicit(&arr[0], std::memory_order_relaxed);
int v1 = std::atomic_load_explicit(&arr[1], std::memory_order_relaxed);
int v2 = std::atomic_load_explicit(&arr[2], std::memory_order_relaxed);
std::atomic_thread_fence(std::memory_order_acquire);
// v0, v1, v2 might turn out to be -1, some or all of them.
// otherwise it is safe to read the non-atomic data because of the fences:
if( v0 != -1 ) { print( data[v0] ); }
if( v1 != -1 ) { print( data[v1] ); }
if( v2 != -1 ) { print( data[v2] ); }
}

std::string computation(int v) {
    if(v==0) {
    return std::string("v1");

    } else if(v == 1) {
    return std::string("v2");

    } else {
    return std::string("v3");

    }
}

void print( std::string *s) {
    std::lock_guard<std::mutex>lck(mtx); 
    std::cout << std::this_thread::get_id() << s << std::endl;
}


int main()
{
    std::thread t1(ThreadA, 1, 2, 3);
    std::thread t2(ThreadB);
    t1.join(); t2.join();
}
