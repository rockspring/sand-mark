#include <iostream>
#include <iomanip>
using namespace std;

int main() {
    auto now = chrono::system_clock::now();
    
    time_t t = chrono::system_clock::to_time_t(now);
    
    tm *now_tm = localtime(&t);
    cout << put_time(now_tm, "date: %x\ntime: %X\n") << endl;
    
    cin.exceptions(ios::badbit);
    cout << cout.exceptions() << endl;

    try {
        cin.setstate(ios::badbit);
    } catch (const ios::failure& myfailure) {
        cout << myfailure.code() <<"->" << myfailure.what()<< endl;
        
        return EXIT_FAILURE;
    }

    
    //read time
    
    tm *date = new tm;
    cout << "new date: ";
    cin >> get_time(date, "%x");
    
    if (!cin) {
        cerr << "invalid format read" << endl;
    }
    
    return 0;
}
