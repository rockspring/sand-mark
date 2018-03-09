cmake_minimum_required(VERSION 3.2)
project(code4x2x1)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES main.cpp)
add_executable(code4x2x1 ${SOURCE_FILES})

add_executable(source_2 source_2.cpp)

add_executable(chrono1 chrono1.cpp)