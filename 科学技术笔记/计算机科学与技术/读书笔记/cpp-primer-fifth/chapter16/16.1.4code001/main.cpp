#include <iostream>
#include <vector>
#include <list>

using namespace std;

// 1 普通（非模板）类的成员模板
class DebugDelete {
public:
    DebugDelete(std::ostream &s = std::cerr): os(s) {}

    template <typename T> void operator()(T *p) const {
        os << "deleting unique_ptr" << std::endl;
        delete p;
    }

private:
    std::ostream &os;
};

void test1() {
    int *p = new int(1);
    DebugDelete debugDelete;
    debugDelete(p);

    int *ip = new int;
    DebugDelete()(ip);

    {
        unique_ptr<int, DebugDelete> p(new int, DebugDelete());

        unique_ptr<string, DebugDelete> sp(new string, DebugDelete());
    }

}

// 2 类模板的成员模板
template <typename T>
class Blob {
public:
    template <typename It> Blob(It b, It e);

private:
    shared_ptr<std::vector<T>> data;
};

template <typename T>
template <typename It>
Blob<T>::Blob(It b, It e):data(std::make_shared<std::vector<T>>(b ,e)) { }

void test2() {
    int ia[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    vector<long> vi = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    list<const char*> w = {"now", "is", "the", "time"};

    Blob<int> al(begin(ia), end(ia));

    Blob<int> a2(vi.begin(), vi.end());

    Blob<string> a3(w.begin(), w.end());
}

int main() {
    //test1();
    test2();
    return 0;
}