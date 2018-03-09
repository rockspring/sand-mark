PROJECT (cmake-demo-google-test LANGUAGES C CXX)
cmake_minimum_required(VERSION 3.1)

SET(SRC_LIST main.cc)
MESSAGE(STATUS "This is BINARY dir " ${HELLO_BINARY_DIR})
MESSAGE(STATUS "This is SOURCE dir " ${HELLO_SOURCE_DIR})

find_package(Threads REQUIRED)

if(CMAKE_COMPILER_IS_GNUCXX)
    add_definitions(-Wall -ansi -Wno-deprecated -pthread)
endif()



add_subdirectory(contrib/googletest-read-only)

#add_subdirectory(hello bin)

add_subdirectory(src)

add_subdirectory(test)

#include_directories(googletest-read-only/include)
include_directories(${PROJECT_SOURCE_DIR}/contrib/googletest-read-only/include)

include_directories(
  ${PROJECT_SOURCE_DIR}/src/include
  ${PROJECT_SOURCE_DIR})

message("main---------------------")
message("PROJECT_SOURCE_DIR=${PROJECT_SOURCE_DIR}")
message("EXECUTABLE_OUTPUT_PATH=${EXECUTABLE_OUTPUT_PATH}")
message("INCLUDE_DIRECTORIES=${INCLUDE_DIRECTORIES}")
message("main---------------------")

ADD_EXECUTABLE(main ${SRC_LIST})

target_link_libraries(main gtest hello)

enable_testing()

add_test(test_main main)

