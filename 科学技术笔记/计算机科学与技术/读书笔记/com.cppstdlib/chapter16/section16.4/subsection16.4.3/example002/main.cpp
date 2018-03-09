#include <locale>
#include <chrono>
#include <ctime>
#include <iostream>
#include <exception>
#include <cstdlib>
#include <string>
#include <iterator>

using namespace std;

int main() {
    try {
        //locale loc_g("de_DE.UTF-8");
        locale loc_g("zh_CN.UTF-8");
        const time_get<char>& tg_g = use_facet<time_get<char>>(loc_g);
        
        typedef time_base TB;
        time_get<char>::dateorder d = tg_g.date_order();
        cout << "dateorder: " << (d==TB::no_order || d==TB::mdy ? "mdy" :
                                  d==TB::dmy ? "dmy" :
                                  d==TB::ymd ? "ymd" :
                                  d==TB::ydm ? "ydm" : "unknown") << endl;
        
        cout << "<wochentag> <hh>:<mm>: ";
        string format = "%A %H:%M";
        struct tm val;
        ios_base::iostate err = ios_base::goodbit;
        tg_g.get(istreambuf_iterator<char>(cin), istreambuf_iterator<char>(), cin, err, &val, format.c_str(), format.c_str()+format.size());
        
        if (err != ios_base::goodbit) {
            cerr << "invalid format" << endl;
        }
        
        locale loc_z("zh_CN");
        const time_put<char>& tp_z = use_facet<time_put<char>>(loc_z);
        tp_z.put(cout, cout, ' ', &val, 'c');
        cout << endl;
    } catch (const std::exception& e) {
        cerr << "Exception: " << e.what() << endl;
        return EXIT_FAILURE;
    }
    return 0;
}
