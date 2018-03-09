#include <iostream>

using namespace std;

bool isValid(char str[], int len) {
    // a
    if (str[0] != '-' && (str[0] < '0' || str[0] > '9')) {
        return false;
    }
    
    // -
    // -0
    if (str[0] == '-' && (len == 1 || str[1] == '0')) {
        return false;
    }
    
    // 01
    if (str[0] == '0' && len > 1) {
        return false;
    }
    
    // 首字符已经验证过了
    for (int i = 1; i < len; i++) {
        if (str[i] < '0' || str[i] > '9') {
            return false;
        }
    }
    
    return true;
}

int main() {
    cout << "sizeof(int)=" << sizeof(int) << endl;

    bool isValidNumberStr = isValid((char*)"123", 3);
    
    cout << isValidNumberStr << endl;
    return 0;
}
