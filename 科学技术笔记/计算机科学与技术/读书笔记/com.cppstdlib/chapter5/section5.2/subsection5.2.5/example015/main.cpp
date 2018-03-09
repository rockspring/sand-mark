#include <iostream>
#include <memory>

using namespace std;

int main() {
    //template<class T> using ptr = T*;
    
    template <class CharT> using mystring =
    std::basic_string<CharT,std::char_traits<CharT>>;
    
    template <int V> using fptr = void (*tfp<V>)();
    
    //template<class T> using ptr = void(*)(T*);
    
    template<class T> using uniquePtr = T*;
    template<class T> using ptr = T*;
    
    //uniquePtr<int> up(new int[10]);
    return 0;
}
