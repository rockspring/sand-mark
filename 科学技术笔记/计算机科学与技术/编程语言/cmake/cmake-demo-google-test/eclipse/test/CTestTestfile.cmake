# CMake generated Testfile for 
# Source directory: /Users/zlq/360云盘/projects/c++/cmake-demo-google-test/test
# Build directory: /Users/zlq/360云盘/projects/c++/cmake-demo-google-test/eclipse/test
# 
# This file includes the relevant testing commands required for 
# testing this directory and lists subdirectories to be tested as well.
add_test(test_hello "/hello_test")
set_tests_properties(test_hello PROPERTIES  ENVIRONMENT "a=1")
add_test(simple "/usr/local/Cellar/cmake/3.1.1/bin/ctest" "--build-and-test" "" "" "--build-generator" "Unix Makefiles" "--build-makeprogram" "/usr/bin/make" "--build-project" "hello_test" "--test-command" "hello_test")
