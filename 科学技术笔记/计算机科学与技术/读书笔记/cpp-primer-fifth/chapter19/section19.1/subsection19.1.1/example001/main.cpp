#include <iostream>
#include <string>

using namespace std;

/*void *operator new(size_t size) {
    cout << "使用重载的operator new 函数" << endl;
    if (void *mem = malloc(size)) {
        return mem;
    } else {
        throw bad_alloc();
    }
}*/

void *operator new(size_t size, nothrow_t& nothrow) noexcept {
    cout << "使用重载的operator new(size_t size, nothrow_t& nothrow) 函数" << endl;
    if (void *mem = malloc(size)) {
        return mem;
    } else {
        throw bad_alloc();
    }
}

/*void operator delete(void *mem) noexcept {
    cout << "使用重载的operator delete 函数" << endl;
    free(mem);
}*/
    
    void operator delete(void *mem, nothrow_t& nothrow) noexcept {
        cout << "使用重载的operator delete(void *mem, nothrow_t& nothrow) 函数" << endl;
        free(mem);
    }

int main() {
    string *sp = new (nothrow) string("a value");
    string *arr = new string[10];
    
    cout << sp << endl;
    cout << *sp << endl;

    
    string *sp2 = new (sp) string("value");
    cout << sp2 << endl;
    cout << *sp2 << endl;
    sp2->~string();
    cout << sp2 << endl;
    cout << *sp2 << endl;

    
    delete sp;
    delete [] arr;
    return 0;
}
