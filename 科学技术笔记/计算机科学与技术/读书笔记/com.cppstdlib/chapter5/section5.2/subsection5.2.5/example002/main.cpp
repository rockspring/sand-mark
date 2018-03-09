#include <iostream>
#include <memory>

using namespace std;

int main() {
    //unique_ptr<int> up = new int;//
    
    unique_ptr<int> up(new int);
    
    cout << *up << endl;

    return 0;
}
