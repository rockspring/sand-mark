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
    Stock(int a, int b) {
        cout << "a=" << a << endl;
        cout << "b=" << b << endl;
    }
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

void makelogEntry(Investment * pInvestment) {
    cout << "log before destruct Investment" << endl;
}

auto delInvmt = [](Investment* pInvestment) {
    makelogEntry(pInvestment);
    delete pInvestment;
};

void delInvmtFunc(Investment* pInvestment) {
    makelogEntry(pInvestment);
    delete pInvestment;
}

template <typename... Ts>
std::unique_ptr<Investment, decltype(delInvmt)> makeInvestment(Ts&&... params) {
    std::unique_ptr<Investment, decltype(delInvmt)> pInv(nullptr, delInvmt);
    
    int toCreate = 0;
    
    if (toCreate == 0) {
        pInv.reset(new Stock(std::forward<Ts>(params)...));
    } else if(toCreate == 1) {
        pInv.reset(new Bond());
    } else if (toCreate == 2) {
        pInv.reset(new RealState());
    }
    
    return pInv;
}

template <typename... Ts>
auto makeInvestmentCpp14(Ts&&... params) {
    std::unique_ptr<Investment, decltype(delInvmt)> pInv(nullptr, delInvmt);
    
    int toCreate = 0;
    
    if (toCreate == 0) {
        pInv.reset(new Stock(std::forward<Ts>(params)...));
    } else if(toCreate == 1) {
        pInv.reset(new Bond());
    } else if (toCreate == 2) {
        pInv.reset(new RealState());
    }
    
    return pInv;
}

template <typename... Ts>
std::unique_ptr<Investment, void(*)(Investment*)> makeInvestmentV2(Ts&&... params) {
    std::unique_ptr<Investment, void(*)(Investment*)> pInv(nullptr, delInvmtFunc);
    
    int toCreate = 0;
    
    if (toCreate == 0) {
        pInv.reset(new Stock(std::forward<Ts>(params)...));
    } else if(toCreate == 1) {
        pInv.reset(new Bond());
    } else if (toCreate == 2) {
        pInv.reset(new RealState());
    }
    
    return pInv;
}

template <typename... Ts>
auto makeInvestmentCpp14V2(Ts&&... params) {
    std::unique_ptr<Investment, void(*)(Investment*)> pInv(nullptr, delInvmtFunc);
    
    int toCreate = 0;
    
    if (toCreate == 0) {
        pInv.reset(new Stock(std::forward<Ts>(params)...));
    } else if(toCreate == 1) {
        pInv.reset(new Bond());
    } else if (toCreate == 2) {
        pInv.reset(new RealState());
    }
    
    return pInv;
}

void testFactory() {
    auto pInvestment = makeInvestment(1, 2);
    cout << "size of pInvestment is " << sizeof(pInvestment) << endl;
    auto pInvestmentCpp14 = makeInvestmentCpp14(1, 2);
    cout << "size of pInvestmentCpp14 is " << sizeof(pInvestment) << endl;
    
    auto pInvestmentV2 = makeInvestmentV2(1, 2);
    cout << "size of pInvestmentV2 is " << sizeof(pInvestmentV2) << endl;
    auto pInvestmentCpp14V2 = makeInvestmentCpp14V2(1, 2);
    cout << "size of pInvestmentCpp14V2 is " << sizeof(pInvestmentCpp14V2) << endl;
}

int main() {
    testFactory();
}
