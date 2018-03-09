#include <iostream>
#include <string>
#include <list>
#include <vector>
#include <exception>

using namespace std;

void test1() {
    shared_ptr<string> p1;
    shared_ptr<list<int>> p2;
    //cout << "p1:" << p1 << endl;
    //cout << "p2:" << p2 << endl;

    if (p1 && p1->empty()) {
        *p1 = "hi";
    } else {
        p1 = make_shared<string>("hi");
    }

    list<int> a = {1, 2};
    if (p2 && p2->empty()) {
        *p2 = {1, 2};
    } else {
        p2 = make_shared<list<int>>(a);
    }
    shared_ptr<list<int>> p3;
    p3 = p2;
    shared_ptr<list<int>> p4(p2);
    cout << "p2 use count:" << p2.use_count() << endl;
    cout << "p3 use count:" << p3.use_count() << endl;
    cout << "p4 use count:" << p4.use_count() << endl;
}

class StrBlob {
public:
    typedef std::vector<std::string>::size_type size_type;
    StrBlob();
    StrBlob(std::initializer_list<std::string> il);
    size_type size() const { return data->size();}
    bool empty() const { return data->empty();}
    void push_back(const std::string &t) { data->push_back(t);}
    void pop_back();
    std::string& front();
    std::string& back();

private:
    std::shared_ptr<std::vector<std::string>> data;
    void check(size_type i, const std::string &msg) const;
};

StrBlob::StrBlob():data(make_shared<vector<string>>()) {}
StrBlob::StrBlob(std::initializer_list<std::string> il):
        data(make_shared<vector<string>>(il)) { }

void StrBlob::check(size_type i, const std::string &msg) const {
    if (i >= data->size())
        throw out_of_range(msg);
}

string& StrBlob::front() {
    check(0, "front on empty StrBlob");
    return data->front();
}

string& StrBlob::back() {
    check(0, "back on empty StrBlob");
    return data->back();
}

void StrBlob::pop_back() {
    check(0, "pop_back on empty StrBlob");
    data->pop_back();
}

void exercise12_1() {
    StrBlob b1;
    {
        StrBlob b2 = {"a", "an", "the"};
        b1 = b2;
        b2.push_back("about");
    }
    cout << b1.size() << endl;
}

int main() {
    shared_ptr<string> p1;
    shared_ptr<list<int>> p2;
    //cout << "p1:" << p1 << endl;
    //cout << "p2:" << p2 << endl;

    if (p1 && p1->empty()) {
        *p1 = "hi";
    } else {
        p1 = make_shared<string>("hi");
    }

    list<int> a = {1, 2};
    if (p2 && p2->empty()) {
        *p2 = {1, 2};
    } else {
        p2 = make_shared<list<int>>(a);
    }

    *p2 = {1, 2, 3};

    cout << "p1:" << p1.get() << endl;
    cout << "p2:" << p2.get() << endl;




    // make_shared function
    shared_ptr<int> p3 = make_shared<int>(42);
    shared_ptr<string> p4 = make_shared<string>(10 ,'9');
    shared_ptr<int> p5 = make_shared<int>();

    cout << "p3:" << p3.get() << endl;
    cout << "*p3:" << *p3 << endl;
    cout << "p4:" << p4.get() << endl;
    cout << "*p4:" << *p4 << endl;
    cout << "p5:" << p5.get() << endl;
    cout << "*p5:" << *p5 << endl;

    auto p6 = make_shared<vector<string>>();

    // shared_ptr的拷贝和赋值
    auto p = make_shared<int>(42);
    auto q(p);

    auto r = make_shared<int>(41);
    r = q;

    cout << "&r:" << &r << endl;
    cout << "r:" << r << endl;
    cout << "*r:" << *r << endl;

    exercise12_1();

    return 0;
}