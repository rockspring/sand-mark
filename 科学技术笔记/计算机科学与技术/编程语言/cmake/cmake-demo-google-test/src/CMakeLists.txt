project(hello)
include_directories(
  ${PROJECT_SOURCE_DIR}/include
  ${PROJECT_SOURCE_DIR})

message("src log---------------------")
message("PROJECT_SOURCE_DIR=${PROJECT_SOURCE_DIR}")

get_property(executable_output_path DIRECTORY PROPERTY EXECUTABLE_OUTPUT_PATH)
message("EXECUTABLE_OUTPUT_PATH=${executable_output_path}")

get_property(include_path DIRECTORY PROPERTY INCLUDE_DIRECTORIES)
message("INCLUDE_DIRECTORIES=${include_path}")
message("src log---------------------")

#add_library(hello SHARED hello/hello.cc hello/sub/sub.cc) 

add_library(hello STATIC hello/hello.cc hello/sub/sub.cc) 

#target_include_directories(hello PUBLIC ${PROJECT_SOURCE_DIR}/build/bin)