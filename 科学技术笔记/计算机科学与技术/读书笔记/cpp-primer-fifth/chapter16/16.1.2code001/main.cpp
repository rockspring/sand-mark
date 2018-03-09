#include <iostream>
#include <vector>

using namespace std;

template <typename T>
class Blob {
public:
    typedef T value_type;
    typedef typename std::vector<T>::size_type size_type;

    // 构造函数
    Blob();
    Blob(std::initializer_list<T> il);

    // Blob中得元素数目
    size_type size() const { return data->size(); }
    bool empty() const { return data->empty(); }

    // 添加和删除元素
    void push_back(const T &t) { data->push_back(t); }
    void pop_back();

    //元素访问
    T &back();
    T &operator[](size_type i);

private:
    std::shared_ptr<std::vector<T>> data;
    // 若data[i]无效，则抛出msg
    void check(size_type i, const std::string &msg) const;
};

template <typename T>
void Blob<T>::check(size_type i, const std::string &msg) const {
    if (i >= data->size()) {
        throw std::out_of_range(msg);
    }
}

template <typename T>
T &Blob<T>::back() {
    check(0, "back on empty Blob");
    return data->back();
}

template <typename T>
T &Blob<T>::operator[](size_type i) {
    check(i, "subscript out of range");
    return (*data)[i];
}

template <typename T>
void Blob<T>::pop_back() {
    check(0, "pop_back on empty Blob");
    data->pop_back();
}

template <typename T>
Blob<T>::Blob(): data(std::make_shared<std::vector<T>>()){ }

template <typename T>
Blob<T>::Blob(std::initializer_list<T> il): data(std::make_shared<std::vector<T>>(il)) {}


template <typename T>
class BlobPtr {
public:
    BlobPtr(): curr(0) {}
    BlobPtr(Blob<T> &a, size_t sz = 0):wptr(a.data), curr(sz) {}

    T &operator*() const {
        auto p = check(curr, "dereference past end");
        return (*p)[curr];
    }

    BlobPtr& operator++();
    BlobPtr& operator--();

private:
    std::shared_ptr<std::vector<T>> check(std::size_t, const std::string &) const;
    std::weak_ptr<std::vector<T>> wptr;
    std::size_t curr;
};

template <typename T>
BlobPtr<T> &BlobPtr<T>::operator++() {
    BlobPtr ret = *this;
    ++*this;
    return ret;
}

int main() {
    Blob<int> ia;
    Blob<string> articles = {"a", "an", "the"};

    Blob<int> squares = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};


    for (size_t i = 0; i != squares.size() ; ++i) {
        squares[i] = i * i;
    }

    return 0;
}