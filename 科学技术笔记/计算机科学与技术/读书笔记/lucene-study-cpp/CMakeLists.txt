project(cpp-study LANGUAGES C CXX)
cmake_minimum_required(VERSION 3.1)

add_subdirectory(contrib/gmock)

add_subdirectory(src bin)

add_subdirectory(test test_bin)

enable_testing()
