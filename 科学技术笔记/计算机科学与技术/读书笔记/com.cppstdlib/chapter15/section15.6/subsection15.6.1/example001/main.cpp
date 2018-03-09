#include <iostream>
#include <iomanip>
#include <locale>

using namespace std;

int main() {
    cout << setw(6) << setfill('_') << 1 << endl;
    
    cout << setw(6) << setfill(' ') << internal << -1 << endl;//正负号靠左，数值靠右

    cout.imbue(locale("zh_CN.UTF-8"));
    cout << boolalpha << true << endl;//强制使用文本表示
    cout << noboolalpha << true << endl;//强制使用数值表示

    cout << +1 << endl; //默认不写出正号
    cout << showpos << 1 << endl; //对正值强制写出正号
    cout << noshowpos << +1 << endl; //对正值强制写出正号
    
    cout << uppercase << 1234567890 << endl; //对于数值强制使用大写字母
    cout << nouppercase << 1234567890 << endl; //对于数值强制使用小写字母

    cout << oct << 10 << endl;//八进制读和写整数
    cout << dec << 10 << endl;//十进制读和写整数
    cout << hex << 10 << endl;//十六进制读和写整数
    
    cout << oct << showbase << 10 << endl;//显示数值的基数
    cout << dec << showbase << 10 << endl;//显示数值的基数
    cout << hex << showbase << 10 << endl;//显示数值的基数
    
    
    cout << oct << noshowbase << 10 << endl;//不显示数值的基数
    cout << dec << noshowbase << 10 << endl;//不显示数值的基数
    cout << hex << noshowbase << 10 << endl;//不显示数值的基数
    
    cout << 1.0f << endl;
    cout << showpoint << 1.0f << endl; //总是为浮点数显示小数点
    cout << showpoint << 1.5 << endl;
    
    cout << noshowpoint << 1.0f << endl; //不要求为浮点数显示小数点
    cout << noshowpoint << 1.5 << endl;

    cout << setprecision(2) << 1.567 << endl; //设置浮点数精度
    
    cout << fixed << 1.567 << endl;//对浮点数使用十进制表示法
    cout << scientific << 1.567 << endl;//对浮点数使用科学表示法
    cout << hexfloat << 1.567 << endl;//对浮点数使用十六进制科学表示法
    cout << defaultfloat << 1.567 << endl;//使用常规浮点数表示法
    
    cout << put_money(1000) << endl;


    
    return 0;
}
