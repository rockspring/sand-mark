#include <iostream>
#include <string>
#include <memory>
#include <dirent.h>
#include <cstring>
#include <cerrno>

using namespace std;

class DirCloser {
public:
    void operator()(DIR *dp) {
        if (closedir(dp) != 0) {
            cerr << "OOPS: closedir() failed" << endl;
        } else {
            cout << "closedir() success" << endl;
        }
    }
};

int main() {
    unique_ptr<DIR, DirCloser> pDir(opendir("."));
    
    struct dirent *dp;
    while ((dp = readdir(pDir.get())) != nullptr) {
        string filename(dp->d_name);
        cout << "process " << filename << endl;
    }
    return 0;
}
