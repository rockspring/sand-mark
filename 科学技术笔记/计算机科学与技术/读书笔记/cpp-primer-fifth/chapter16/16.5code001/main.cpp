#include <iostream>

using namespace std;

template <typename T> int compare(const T &v1, const T &v2) {
    if (v1 < v2) return -1;
    if (v2 < v1) return 1;
    return 0;
}

template <size_t N, size_t M>
int compare(const char (&v1)[N], const char (&v2)[M]) {

};

template <>
int compare(const char * const &p1, const char * const &p2) {
    cout << "template <> int compare(const char * const &p1, const char * const &p2)" << endl;
    return strcmp(p1, p2);
}

int compare(const char * const &p1, const char * const &p2) {
    cout << "int compare(const char * const &p1, const char * const &p2)" << endl;
    return strcmp(p1, p2);
}

void test1() {
    const char *p1 = "hi";
    const char *p2 = "mom";
    compare(p1, p2);
}

int main() {
    test1();
    return 0;
}