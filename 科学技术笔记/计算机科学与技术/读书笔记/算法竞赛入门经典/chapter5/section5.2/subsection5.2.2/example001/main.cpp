#include <iostream>

using namespace std;

int main() {
    const int kMaxLen = 3000;
    int f[kMaxLen] = {1,0};
    int single_multiply[kMaxLen]={0};
    int sum_multiply[kMaxLen]={0};
    
    // n!=1*2...*n
    int n = 1000;
    for (int m = 1; m <= n; ++m) {
        
        int start_index = 0;
        int i = m;
        while (i > 0) {
            for (int k = 0; k < kMaxLen; ++k) {
                single_multiply[k] = 0;
            }
            int c = 0;
            for (int j = 0; j < kMaxLen; ++j) {
                single_multiply[j + start_index] = ((i % 10) * f[j] + c) % 10;
                c = ((i % 10) * f[j] + c) / 10;
            }
            if (c > 0) {
                cout << "溢出了" << endl;
            }
            //sum
            c = 0;
            for (int k = 0; k < kMaxLen; ++k) {
                int bit_sum = sum_multiply[k] + single_multiply[k] + c;
                sum_multiply[k] = bit_sum % 10;
                c = bit_sum / 10;
            }
            if (c > 0) {
                cout << "溢出了" << endl;
            }
            
            
            i = i / 10;
            ++start_index;
        }
        for (int k = 0; k < kMaxLen; ++k) {
            f[k] = sum_multiply[k];
            sum_multiply[k] = 0;
        }
    }
    bool output = false;
    for (int k = kMaxLen-1; k >= 0; --k) {
        if (output) {
            cout << f[k];
        } else {
            if (f[k] > 0) {
                output = true;
                cout << f[k];
            }
        }
    }
    cout << endl;
    return 0;
}
