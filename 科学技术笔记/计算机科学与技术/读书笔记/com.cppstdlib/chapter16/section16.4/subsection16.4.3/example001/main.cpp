#include <locale>
#include <chrono>
#include <ctime>
#include <iostream>
#include <exception>
#include <cstdlib>
#include <string>


using namespace std;

int main() {
    try {
        auto now = chrono::system_clock::now();
        std::time_t t = chrono::system_clock::to_time_t(now);
        tm* now_tm = std::localtime(&t);
        
        locale locC;
        const time_put<char>& tp_c = use_facet<time_put<char>>(locC);
        
        tp_c.put(cout, cout, ' ', now_tm, 'c');
        cout << endl;
        
        string format = "%A %x %I%p\n";
        
        tp_c.put(cout, cout, ' ', now_tm, format.c_str(), format.c_str()+format.size());
        
        locale loc_g("de_DE");
        const time_put<char>& tp_g = use_facet<time_put<char>>(loc_g);
        tp_g.put(cout, cout, ' ', now_tm, 'x');
        cout << endl;
        
        tp_g.put(cout, cout, ' ', now_tm, format.c_str(), format.c_str()+format.size());
        
        
        locale loc_z("zh_CN");
        const time_put<char>& tp_z = use_facet<time_put<char>>(loc_z);
        tp_z.put(cout, cout, ' ', now_tm, 'x');
        cout << endl;
        
        tp_z.put(cout, cout, ' ', now_tm, format.c_str(), format.c_str()+format.size());
    } catch (const std::exception& e) {
        cerr << "Exception: " << e.what() << endl;
        return EXIT_FAILURE;
    }
    return 0;
}
