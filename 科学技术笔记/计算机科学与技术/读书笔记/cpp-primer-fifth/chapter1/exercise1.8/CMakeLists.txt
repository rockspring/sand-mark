cmake_minimum_required(VERSION 3.2)
project(exercise1_8)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES main.cpp)
add_executable(exercise1_8 ${SOURCE_FILES})