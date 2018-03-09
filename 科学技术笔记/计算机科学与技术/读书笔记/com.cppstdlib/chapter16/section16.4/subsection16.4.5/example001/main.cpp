#include <iostream>
#include <locale>
#include <codecvt>
#include <string>

using namespace std;

int main() {
    locale loc("zh_CN.UTF-8");
    const collate<char>& col = use_facet<collate<char>>(loc);
    
    string s1("啊");
    //string s2("吧");
    
    string s2("国");

    
    int result = col.compare(s1.data(), s1.data()+s1.size(), s2.data(), s2.data()+s2.size());
    
    cout << result << endl;
    
    
    //locale loc("zh_CN.UTF-8");
    const collate<wchar_t>& wcol = use_facet<collate<wchar_t>>(loc);
    
    //wstring ws1(L"阿");
    wstring ws1(L"a");

    //string s2("吧");
    
    wstring ws2(L"嗄");
    
    
    result = wcol.compare(ws1.data(), ws1.data()+s1.size(), ws2.data(), ws2.data()+ws2.size());
    
    cout << result << endl;
    
    result = loc(ws1, ws2);
    
    cout << result << endl;
    
    wcout.imbue(loc);
    wcout << ws1 << endl;
    wcout << wcol.transform(ws1.data(), ws1.data() + ws1.size()) << endl;
    wcout << wcol.transform(&ws1[0], &ws1[0] + ws1.size()) << endl;

    
    wcout << ws2 << endl;
    wcout << wcol.transform(ws2.data(), ws2.data() + ws2.size()) << endl;
    wcout << wcol.transform(&ws2[0], &ws2[0] + ws2.size()) << endl;



    return 0;
}
