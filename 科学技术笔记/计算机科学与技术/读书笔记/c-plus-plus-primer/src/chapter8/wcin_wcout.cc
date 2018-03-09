#include <iostream>
#include <locale>
#include <string>
#include <iostream>
#include <fstream>
#include <vector>
#include <string>
#include <set>
#include <map>
#include <cstddef>
#include <locale>
#include <codecvt>
#include <sys/mman.h>
#include <sys/types.h>
#include <unistd.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <assert.h>

using std::cout;
using std::cin;
using std::cerr;
using std::endl;
using std::istream_iterator;
using std::ifstream;
using std::ofstream;
using std::string;
using std::set;
using std::u16string;
using std::wcout;
using std::wifstream;

using std::cout;
using std::wcout;
using std::cin;
using std::wcin;
using std::string;
using std::wstring;

void test_chinese_in_out() {
    wstring b;
    //wcin.imbue(std::locale("C"));//为什么能输入中文
    //wcout.imbue(std::locale("C"));//设置了wcout的locale与wcin的一样就能输出中文
    wcin.imbue(std::locale(std::locale("en_US.UTF-8"), new std::codecvt_utf8<wchar_t, 0x10ffff, std::little_endian>));
    wcout.imbue(std::locale(std::locale("en_US.UTF-8"), new std::codecvt_utf8<wchar_t, 0x10ffff, std::little_endian>));

    if (wcin >> b) //utf8字符串
    {
        cout << "(wcin >> b) is true";
    } else {
        cout << "(wcin >> b) is false";
    }
    wcout << b << "\n";

    wstring a = L"中";
    for (int i = 0; i < b.size(); ++i)
    {
        /* code */
        cout << b[i] << "\n";
    }

    for (int i = 0; i < a.size(); ++i)
    {
        /* code */
        cout << a[i] << "\n";
    }
    string::size_type pos = b.find(a);

    cout << "pos=" << pos << "\n";

    wcout << "b[0,1]=" << b.substr(0,1) << "\n";

    //reserve
    b.reserve();
    cout << "b=" << b.size() << "\n";
    wcout << "b=" << b << "\n";

    //Modifiers

    //append
    b.append(L"周");
    cout << "b=" << b.size() << "\n";
    wcout << "b=" << b << "\n";

    //push_back
    b.push_back(L'周');
    cout << "b=" << b.size() << "\n";
    wcout << "b=" << b << "\n";

    //assign
    b.assign(L"全新的字符串");
    cout << "b=" << b.size() << "\n";
    wcout << "b=" << b << "\n";

    //insert
    b.insert(1, L"全新的字符串");
    cout << "b=" << b.size() << "\n";
    wcout << "b=" << b << "\n";

    //erase
    b.erase(0, 1);
    cout << "b=" << b.size() << "\n";
    wcout << "b=" << b << "\n";

    //replace
    b.replace(0, 1, L"替");
    cout << "b=" << b.size() << "\n";
    wcout << "b=" << b << "\n";

    wstring swap = L"我是用于交换的字符串";

    //swap
    b.swap(swap);
    cout << "b=" << b.size() << "\n";
    wcout << "b=" << b << "\n";

    //pop_back
    b.pop_back();
    cout << "b=" << b.size() << "\n";
    wcout << "b=" << b << "\n";

    //clear
    b.clear();
    cout << "b=" << b.size() << "\n";
    wcout << "b=" << b << "\n";

    



}

void test_chinese_in_out_v2() {
    string a;
    cin >>a;
    cout << a;
    cout << "中文";
    wstring b;
    wcin.imbue(std::locale(std::locale("en_US.UTF-8"), new std::codecvt_utf8<wchar_t, 0x10ffff, std::little_endian>));
    wcout.imbue(std::locale(std::locale("en_US.UTF-8"), new std::codecvt_utf8<wchar_t, 0x10ffff, std::little_endian>));
    if (wcin >> b)
    {
        cout << "(wcin >> b) is true";
    } else {
        cout << "(wcin >> b) is false";
    }
    wcout << b;

    wcin.imbue(std::locale(std::locale("C"), new std::codecvt_utf8<wchar_t, 0x10ffff, std::little_endian>));

    
    wcin.imbue(std::locale("C"));//为什么能输入中文
    wcout.imbue(std::locale("C"));//设置了wcout的locale与wcin的一样就能输出中文

    //wcin.imbue(std::locale("en_US.UTF-8"));//为什么还是不能输入中文
    //wcout.imbue(std::locale("en_US.UTF-8"));//为什么还是不能输入中文

    wcin.imbue(std::locale(""));//为什么还是不能输入中文
    wcout.imbue(std::locale(""));//为什么还是不能输入中文

    if (wcin >> b)
    {
        cout << "(wcin >> b) is true";
    } else {
        cout << "(wcin >> b) is false";
    }
    wcout << b;
}

int main() {
    //std::locale::global(std::locale(""));
    test_chinese_in_out();
    return 0;  

}