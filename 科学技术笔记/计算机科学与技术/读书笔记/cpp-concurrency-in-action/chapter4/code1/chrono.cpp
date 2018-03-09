//
// Created by zlq on 7/11/15.
//

//
// Created by zlq on 7/11/15.
//

#include <iostream>
#include <iomanip>
#include <ctime>
#include <chrono>
#include <thread>

int main()
{
    std::ratio ratio;
    std::chrono::duration<long, std::ratio<60,1>> duration;
    std::chrono::system_clock::time_point now = std::chrono::system_clock::now();
    std::cout << std::chrono::hours(24).count() << std::endl;
    std::time_t now_c = std::chrono::system_clock::to_time_t(now - std::chrono::hours(24));
    std::cout << "24 hours ago, the time was "
    << std::put_time(std::localtime(&now_c), "%F %T") << '\n';

    std::chrono::steady_clock::time_point start = std::chrono::steady_clock::now();
    std::cout << "Hello World\n";
    std::this_thread::sleep_for(std::chrono::duration<long>(1));
    std::chrono::steady_clock::time_point end = std::chrono::steady_clock::now();
    std::cout << "Printing took "
    << std::chrono::duration_cast<std::chrono::microseconds>(end - start).count()
    << "us.\n";
}


