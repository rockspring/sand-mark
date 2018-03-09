message("PROJECT_SOURCE_DIR=${PROJECT_SOURCE_DIR}")
include_directories(
    ${PROJECT_SOURCE_DIR}/contrib/gmock/gtest/include
    ${PROJECT_SOURCE_DIR}/contrib/gmock/include
    ${PROJECT_SOURCE_DIR}/src/include
    ${PROJECT_SOURCE_DIR})


add_executable(test_main test_main.cc ../src/bit.cpp ../src/number.cpp)
target_link_libraries(test_main gtest)


enable_testing()

add_test(test_main test_main)
