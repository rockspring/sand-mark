#include <iostream>
#include <array>
#include <stdio.h>
#include <string.h>

using namespace std;

int main() {
    array<char, 41> a;
    strcpy(&a[0], "hello, world");
    printf("%s\n", &a[0]);
    
    strcpy(a.data(), "hello, world!");
    printf("%s\n", a.data());
    return 0;
}
