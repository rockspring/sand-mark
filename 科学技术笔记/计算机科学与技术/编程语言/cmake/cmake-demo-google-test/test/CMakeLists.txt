project(hello_test)
cmake_minimum_required(VERSION 3.1)
include_directories(
  ${PROJECT_SOURCE_DIR}/include
  ${PROJECT_SOURCE_DIR})

include_directories(${PROJECT_SOURCE_DIR}/../contrib/googletest-read-only/include)

message("hello_test---------------------")
message("${PROJECT_SOURCE_DIR}")
message("hello_test---------------------")

add_executable(hello_test test.cc)
target_link_libraries(hello_test gtest)

#target_include_directories(hello PUBLIC ${PROJECT_SOURCE_DIR}/build/bin)

enable_testing()

add_test(test_hello hello_test)

add_test(test_hello ${EXECUTABLE_OUTPUT_PATH}/hello_test)

set_property(TEST test_hello PROPERTY ENVIRONMENT a=1)

add_test(simple ${CMAKE_CTEST_COMMAND} 
--build-and-test "${CMake_SOURCE_DIR}" 
				 "${CMake_BINARY_DIR}" 
--build-generator ${CMAKE_GENERATOR} 
--build-makeprogram ${CMAKE_MAKE_PROGRAM} 
--build-project hello_test 
--test-command hello_test 
)