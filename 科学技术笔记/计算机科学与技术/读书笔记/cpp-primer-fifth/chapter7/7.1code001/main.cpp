#include <iostream>

using namespace std;

struct Sales_data {
    //Sales_data() = default;
    Sales_data(double revenue=1);
    std::string bookNo;
    unsigned units_sold = 10;
    double revenue = 0.0;
    void printBookNo();
};

extern string bookNo;



void Sales_data::printBookNo() {
    string bookNo("456");
    {
        string bookNo("789");
        cout << ::bookNo << endl;
    }
}

string bookNo("123");

Sales_data::Sales_data(double revenue):revenue(10) { }


typedef double Money;
class Account {
public:
    Money blance() { return bal;}

private:
    typedef double Money;
    Money bal;
};

int main() {
    Sales_data sales;
    cout << sales.revenue << endl;
    sales.printBookNo();
    return 0;
}