//
// Created by zlq on 7/10/15.
//

#include <string>
#include <future>

struct X {
    void foo(int ,std::string const&);
    std::string bar(std::string const&);
};

X x;

auto f1 = std::async(&X::foo, &x, 42, "hello");
auto f2 = std::async(&X::bar, &x, 42, "goodbye");

struct Y {
    double operator()(double);
};

Y y;

auto f3 = std::async(Y(), 3,14);
auto f4 = std::async(std::ref(y), 2,718);

X baz(X&);

auto f5 = std::async(baz, std::ref(x));

class move_only {
public:
    move_only();
    move_only(move_only&&);
    move_only(move_only const&) = delete;
    move_only& operator=(move_only&&);
    move_only& operator=(move_only const&) = delete;
    void operator()();
};

auto f6 = std::async(move_only());

auto f7 = std::async(std::launch::async, Y(), 1.2);


