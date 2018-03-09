#include <iostream>
#include <regex>

using namespace std;
using std::regex;

int main() {
    regex reg1("<.*>.*</.*>");
    cout << regex_match("<tag>value</tag>", reg1) << endl;
    cout << regex_match("<tag>value</tag", reg1) << endl;
    
    regex reg2(R"(<(.*).*</\1>)");
    
    cout << regex_match("<tag>value</tag>", reg2) << endl;

    
    regex reg3("<(.*).*</\\1>");

    cout << regex_match("<tag>value</tag>", reg3) << endl;
    
    regex reg4("<(.*).*</\\1>");
    
    cout << "regex_search=" << regex_search("a<tag>value</tag>b", reg4) << endl;
    


    return 0;
}
