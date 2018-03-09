#include <iostream>
#include<string.h>

using namespace std;

void bubbles_sort(int a[], int len) {
    for (int i=0; i < len; ++i) {
        for (int j= i+1; j < len; ++j) {
            //循环结束之后第i个位置的值确定
            //每次看为处理的值是否比第i个位置的值小，如果小，则交换到第i个位置，保持第i个位置的值为从第i个位置开始后面的
            //所有值中最小的
            if (a[i] > a[j]) {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }
    }
}

void bubbles_sort2(int a[], int len) {
    for (int i=len - 1; i>0; --i) {
        for (int j = 0; j<i; ++j) {
            if (a[j] > a[j+1]) {
                int tmp = a[j];
                a[j] = a[j+1];
                a[j+1] = tmp;
            }
        }
        for (int k=0; k< len; ++k) {
            cout << a[k];
        }
        cout << endl;
    }
}

void reverse_digital(int a[], int len) {
    for (int i=0; i<len/2; ++i) {
        int tmp = a[i];
        a[i] = a[len-1-i];
        a[len-1-i] = tmp;
    }
}

int main() {
    cout << "sizeof(int)=" << sizeof(int) << endl;
    int a[5] = {5, 4, 3, 2, 1};
    bubbles_sort(a, 5);
    for (int i=0; i< 5; ++i) {
        cout << a[i] << endl;
    }
    int b[5] = {5, 4, 3, 2, 1};
    bubbles_sort2(b,5);
    for (int i=0; i< 5; ++i) {
        cout << b[i] << endl;
    }
    reverse_digital(a, 5);
    for (int i=0; i< 5; ++i) {
        cout << a[i] ;
    }
    cout << endl;
    return 0;
}
