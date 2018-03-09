#include <iostream>
#include <boost/lockfree/queue.hpp>
#include <thread>
#include <atomic>
#include <vector>

using namespace std;

class thread_pool {
    std::atomic_bool done;
    boost::lockfree::queue <std::function<void()> > work_queue;
    std::vector<std::thread> threads;
    join_threads joiner;
};

int main() {
    cout << "Hello, World!" << endl;
    return 0;
}