cmake_minimum_required(VERSION 3.2)
project(code1_1)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES main.cpp)
add_executable(code1_1 ${SOURCE_FILES})