struct A { int a[5]; };
struct B { double x, y, z; };
int main()
{
    std::atomic<A> a;
    std::atomic<B> b;
    std::atomic<double> c;
    std::cout << std::boolalpha
              << "std::atomic<A> is lock free? "
              << std::atomic_is_lock_free(&a) << '\n'
              << "std::atomic<B> is lock free? "
              << std::atomic_is_lock_free(&b) << '\n';
              
    std::cout << ATOMIC_BOOL_LOCK_FREE << std::endl;
    std::cout << ATOMIC_CHAR_LOCK_FREE << std::endl;
    std::cout << ATOMIC_CHAR16_T_LOCK_FREE << std::endl;
    std::cout << ATOMIC_CHAR32_T_LOCK_FREE << std::endl;
    std::cout << ATOMIC_WCHAR_T_LOCK_FREE << std::endl;
    std::cout << ATOMIC_SHORT_LOCK_FREE << std::endl;
    std::cout << ATOMIC_INT_LOCK_FREE << std::endl;
    std::cout << ATOMIC_LONG_LOCK_FREE << std::endl;
    std::cout << ATOMIC_LLONG_LOCK_FREE << std::endl;
    std::cout << ATOMIC_POINTER_LOCK_FREE << std::endl;
}