//
//  lib1.cpp
//  main
//
//  Created by zlq on 2/1/16.
//
//

#include <stdio.h>

#include "header1.h"

void print() {
    printf("i=%d\n", i);
}

 static void say_hello() {
    printf("say hello from lib1\n");
}