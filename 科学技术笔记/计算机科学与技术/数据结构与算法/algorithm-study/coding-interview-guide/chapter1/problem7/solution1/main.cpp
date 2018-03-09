#include <iostream>
#include <deque>

using namespace std;

void getWindowMax(int arr[], int len, int w, int result[], int resultLen) {
    if (len<0 || w < 1 || len < w) {
        return;
    }
    
    deque<int> qmax;
    int index = 0;//存result用的下标索引
    for (int i=0; i < len; i++) {
        while (!qmax.empty() && arr[qmax.back()] <= arr[i]) {
            qmax.pop_back();
        }
        qmax.push_back(i);
        if (i-w == qmax.front()) {
            qmax.pop_front();
        }
        
        if (i >= (w-1)) {
            result[index++] = arr[qmax.front()];
        }
    }
}

int main() {
    cout << "sizeof(int)=" << sizeof(int) << endl;
    int arr[] = {4, 3, 5, 4, 3, 3, 6, 7};
    int len = sizeof(arr)/sizeof(int);
    int w = 3;
    int resultLen = len - w + 1;
    int result[resultLen];
    getWindowMax(arr, len, w, result, resultLen);
    
    for (int i=0; i< resultLen; i++) {
        cout << result[i] << endl;
    }

    return 0;
}
