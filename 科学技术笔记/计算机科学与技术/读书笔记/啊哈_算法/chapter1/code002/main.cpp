#include <iostream>

using namespace std;

int main() {
    int count = 0;
    cin >> count;

    int *scores = new int[count];
    for (int i = 0; i < count; ++i) {
        cin >> scores[i];
    }
    
    for (int i=0; i<count-1; ++i) {
        for (int j = 0; j < count-i-1; ++j) {
            if (scores[j] < scores[j+1]) {
                int tmp = scores[j];
                scores[j] = scores[j+1];
                scores[j+1] = tmp;
            }
        }
    }

    for (int k = 0; k < count; ++k) {
        cout << scores[k] << " ";
    }
    cout << endl;

    delete []scores;
    return 0;
}