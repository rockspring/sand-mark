cmake_minimum_required(VERSION 3.5)

project(swimmingsand CXX)

# Pick the C++ standard to compile with.
# Currently supports C++11, C++14, and C++17.
set(CMAKE_CXX_STANDARD 11)

set(CMAKE_RUNTIME_OUTPUT_DIRECTORY ${CMAKE_BINARY_DIR}/bin)

# find dependencies
## pthread
find_package(Threads REQUIRED)

## 跟测试相关的配置
option(SAND_USE_EXTERNAL_GOOGLETEST
  "If ON, Sand will assume that the targets for GoogleTest are already provided by the including project. This makes sense when Sand is used with add_subproject." OFF)


option(SAND_USE_GOOGLETEST_HEAD
  "If ON, sand will download HEAD from googletest at config time." OFF)

set(SAND_LOCAL_GOOGLETEST_DIR "/tmp/googletest" CACHE PATH
  "If SAND_USE_GOOGLETEST_HEAD is OFF, specifies the directory of a local googletest checkout."
  )

option(SAND_RUN_TESTS "If ON, Sand tests will be run." OFF)

if(${SAND_RUN_TESTS})
  # enable CTest.  This will set BUILD_TESTING to ON unless otherwise specified
  # on the command line
  include(CTest)
  enable_testing()
endif()

## check targets
if(BUILD_TESTING)
  if (NOT SAND_USE_EXTERNAL_GOOGLETEST)
    set(sand_gtest_build_dir ${CMAKE_BINARY_DIR}/googletest-build)
    if(${SAND_USE_GOOGLETEST_HEAD})
      set(sand_gtest_src_dir ${CMAKE_BINARY_DIR}/googletest-src)
    else()
      set(sand_gtest_src_dir ${SAND_LOCAL_GOOGLETEST_DIR})
    endif()
    message("abc")
    include(CMake/Googletest/DownloadGTest.cmake)
  endif()

  #check_target(gtest)
  #check_target(gtest_main)
  #check_target(gmock)

  list(APPEND SAND_TEST_COMMON_LIBRARIES
    gtest_main
    gtest
    gmock
    ${CMAKE_THREAD_LIBS_INIT}
  )
endif()

# 子目录
add_subdirectory(sand)
