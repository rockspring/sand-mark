INCLUDE_DIRECTORIES(/tmp/t2/include/hello)
ADD_EXECUTABLE(main main.c)

TARGET_LINK_LIBRARIES(main hello)
