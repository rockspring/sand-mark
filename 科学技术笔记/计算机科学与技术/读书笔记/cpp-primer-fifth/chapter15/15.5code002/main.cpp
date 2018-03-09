#include <iostream>

using namespace std;

class Base {
public:
    void pub_mem();

protected:
    int prot_mem;
private:
    char priv_mem;
};

struct Pub_Derv : public Base {
    int f() {
        return prot_mem;
    }
    char g() {
        //return priv_mem; // 'priv_mem' is a private member of 'Base'
        return '0';
    }
};

struct Priv_Deriv : private Base {
    int f1() const {
        return prot_mem;
    }
};
int main() {
    cout << "Hello, World!" << endl;
    return 0;
}