cmake_minimum_required(VERSION 3.10.2)

# Now simply link against gtest or gtest_main as needed. Eg
add_executable(test_demo demo_unittest.cc)
target_link_libraries(test_demo -lpthread gtest_main gtest)
add_test(NAME TestDemo COMMAND test_demo)

