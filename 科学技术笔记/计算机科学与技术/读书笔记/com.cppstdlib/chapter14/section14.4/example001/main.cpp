#include <iostream>
#include <regex>

using namespace std;

int main() {
    string data = "<person>\n"
    " <first>Nico</first>\n"
    " <last>Josuttis</last>\n"
    "</person>\n";
    
    regex reg("<(.*)>(.*)</(\\1)>");
    
    sregex_token_iterator pos(data.cbegin(), data.cend(), reg, {-1, 0});
    sregex_token_iterator end;
    
    for ( ; pos !=  end; ++pos) {
        cout << "match:  " << pos->str() << endl;
    }

    return 0;
}
