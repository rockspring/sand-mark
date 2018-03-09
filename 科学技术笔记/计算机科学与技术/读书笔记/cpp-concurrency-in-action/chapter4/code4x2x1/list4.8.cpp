//
// Created by zlq on 7/10/15.
//

#include <deque>
#include <mutex>
#include <future>
#include <thread>
#include <utility>


std::mutex m;

std::deque<std::packaged_task<void()> > tasks;


