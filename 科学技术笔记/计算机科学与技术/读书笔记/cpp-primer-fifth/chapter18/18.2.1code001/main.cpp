#include <iostream>

using namespace std;

#include "Sales_data.h"

int main() {
    using cplusplus_primer::cplusplus_primer_sub::Sales_data;
    using cplusplus_primer::cplusplus_primer_sub::operator+;
    Sales_data sales_data1, sales_data2;

    sales_data1 + sales_data2;
    return 0;
}