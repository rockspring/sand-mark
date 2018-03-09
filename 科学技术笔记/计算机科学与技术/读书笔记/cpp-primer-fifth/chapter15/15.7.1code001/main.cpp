#include <iostream>

using namespace std;

class Quote {
public:
    //virtual ~Quote() = default;
    virtual ~Quote();
};

Quote::~Quote() {
    cout << "~Quote()" << endl;
}

class Bulk_quote : public Quote {
public:
    //virtual ~Bulk_quote() = default;
    virtual ~Bulk_quote();
};

Bulk_quote::~Bulk_quote() {
    cout << "~Bulk_quote()" << endl;
}

int main() {
    Quote *itemP = new Quote;
    delete itemP;

    itemP = new Bulk_quote;
    delete itemP;
    return 0;
}