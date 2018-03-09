#include <iostream>

#include "header1.h"
#include "header2.h"
#include "lib1.h"

using namespace std;

static int a = 1;

static void say_hello() {
    printf("say hello from lib1\n");
}

int main() {
    cout << "a=" << a << endl;
    //cout << "b=" << b << endl;

    cout << i << endl;
    //print();
    i = 1000;
    cout << i << endl;
    //print();
    
    say_hello();
    return 0;
}
