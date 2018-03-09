PROJECT (HELLO)
SET(SRC_LIST main.c hello/hello.c)
MESSAGE(STATUS "This is BINARY dir " ${HELLO_BINARY_DIR})
MESSAGE(STATUS "This is SOURCE dir " ${HELLO_SOURCE_DIR})
ADD_EXECUTABLE(main ${SRC_LIST})

#target_link_libraries(main hello)
