cmake_minimum_required(VERSION 3.2)
project(tail_study)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES main.cpp)
add_executable(tail_study ${SOURCE_FILES})