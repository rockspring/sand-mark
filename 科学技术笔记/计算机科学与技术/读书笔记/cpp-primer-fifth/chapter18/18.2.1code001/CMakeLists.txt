cmake_minimum_required(VERSION 3.2)
project(18_2_1code001)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES main.cpp Sales_data.cpp)
add_executable(18_2_1code001 ${SOURCE_FILES})