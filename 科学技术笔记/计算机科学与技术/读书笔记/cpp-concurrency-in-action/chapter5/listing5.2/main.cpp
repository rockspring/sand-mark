#include <vector>
#include <atomic>
#include <iostream>
#include <thread>

std::vector<int> data;
std::atomic<bool> data_ready(false);

void reader_thread() {
    while (!data_ready.load()) { // 1
        std::this_thread::sleep_for(1);
    }

    std::cout << "The anwser=" << data[0] << "\n"; // 2
}

void writer_thread() {
    data.push_back(42); // 3
    data_ready = true; // 4
}

// happens 顺序 3 --> 4 --> 1 --> 2

using namespace std;

// write operation W on x in thread A

// read operation R on x

// subsequent write on x after W in thread A

// read-modify-write operations on x by any thread

//

int main() {
    cout << "Hello, World!" << endl;
    return 0;
}