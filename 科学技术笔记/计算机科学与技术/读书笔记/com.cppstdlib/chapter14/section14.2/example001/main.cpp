#include <iostream>
#include <regex>

using namespace std;

int main() {
    string data = "XML tag: <tag-name>the value</tag-name>.";
    cout << "data               " << data << endl;
    smatch m;
    bool found = regex_search(data, m, regex("<(.*)>(.*)</(\\1)>"));
    
    cout << "m.empty():" << boolalpha << m.empty() << endl;
    
    cout << "m.size():" << boolalpha << m.size() << endl;
    
    if (found) {
        cout << "" << m.str() << endl;
        cout << "" << m.length() << endl;
        cout << "" << m.position() << endl;
        cout << "" << m.prefix().str() << endl;
        cout << "" << m.suffix().str() << endl;
        
        for (int i=0; i<m.size(); ++i) {
            cout << "m[" << i << "].str():    " << m[i].str() << endl;
            cout << "m.str(" << i << "):    " << m.str(i) << endl;
            cout << "m.position(" << i << "):    " << m.position() << endl;
        }
        
        cout << m[1] << endl;
    }

    return 0;
}
