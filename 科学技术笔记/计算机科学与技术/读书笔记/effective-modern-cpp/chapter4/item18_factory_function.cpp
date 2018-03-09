#include <typeinfo>
#include <iostream>
#include <vector>
#include <utility>

using namespace std;

class Investment {
public:
    virtual ~Investment() {
        cout << "virtual ~Investment()" << endl;
    }
};

class Stock : public Investment {
public:
    virtual ~Stock() {
        cout << "virtual ~Stock()" << endl;
    }
};

class Bond : public Investment {
public:
    virtual ~Bond() {
        cout << "virtual ~Bond()" << endl;
    }
};

class RealState : public Investment {
public:
    virtual ~RealState() {
        cout << "virtual ~RealState()" << endl;
    }
};

template <typename... Ts>
std::unique_ptr<Investment> makeInvestment(Ts&&... params) {
    return make_unique<Stock>();
}

void testFactory() {
    auto pInvestment = makeInvestment(1, 2);
}

int main() {
    testFactory();
}
