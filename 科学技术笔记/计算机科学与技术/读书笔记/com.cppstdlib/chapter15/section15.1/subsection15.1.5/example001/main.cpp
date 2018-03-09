#include <iostream>

using namespace std;

int main() {
    cout << ends;
    
    cout.imbue(locale("zh_CN.UTF-8"));
    
    cout << cout.getloc().name() << endl;

    return 0;
}
