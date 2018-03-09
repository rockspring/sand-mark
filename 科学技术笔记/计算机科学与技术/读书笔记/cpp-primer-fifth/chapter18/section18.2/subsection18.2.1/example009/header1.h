//
//  header1.h
//  main
//
//  Created by zlq on 2/1/16.
//
//

#ifndef header1_h
#define header1_h

namespace {
    int i = 100;
}

static int b = 1;
static void say_hello();

inline static void say_hello2() {
    printf("say_hello2 from header1.h\n");
};

#endif /* header1_h */
