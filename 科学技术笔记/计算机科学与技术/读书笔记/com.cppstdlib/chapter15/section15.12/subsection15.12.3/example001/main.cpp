#include <iostream>
#include <fstream>

using namespace std;

void redirect(ostream&);

int main() {
    cout << "first row" << endl;
    redirect(cout);
    cout << "second row" << endl;
    return 0;
}

void redirect(ostream& strm) {
    auto del = [&](streambuf* p) {
        strm.rdbuf(p);
    };
    
    unique_ptr<streambuf, decltype(del)> origin_buffer(strm.rdbuf(), del);
    
    ofstream file("redirect.txt");
    strm.rdbuf(file.rdbuf());
    
    file << "one row for the file" << endl;
    strm << "noe row for the stream" << endl;
    
}
