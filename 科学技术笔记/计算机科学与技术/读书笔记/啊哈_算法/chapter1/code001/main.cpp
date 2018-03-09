#include <iostream>

using namespace std;

int main() {
    int count = 0;
    cin >> count;
    int *score = new int[count];
    for (int i = 0; i < count; ++i) {
        cin >> score[i];
    }


    int *bucket = new int[11];
    for (int i=0; i < 11; i++) {
        bucket[i] = 0;
    }

    for (int i=0; i < count; ++i) {
        bucket[score[i]] = bucket[score[i]] + 1;
    }

    for (int j = 0; j < 11; ++j) {
        for (int i = 0; i < bucket[j]; ++i) {
            cout << j << endl;
        }
    }

    delete []score;
    delete []bucket;

    return 0;
}