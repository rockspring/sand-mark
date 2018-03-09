#include <iostream>

template <int N>
class Factorial
{
public:
    enum { result = N * Factorial<N-1>::result };
};

template<>
class Factorial<1>
{
public:
    enum { result = 1 };
};

template <bool C, typename Ta, typename Tb>
class IfThenElse;

template <typename Ta, typename Tb>
class IfThenElse<true, Ta, Tb>{
public:
    typedef Ta ResultT;
};

template <typename Ta, typename Tb>
class IfThenElse<false, Ta, Tb>{
public:
    typedef Tb ResultT;
};

int main()
{
    std::cout << Factorial<3>::result << std::endl;
    return 0;
}
