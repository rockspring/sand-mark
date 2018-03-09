#include <iostream>

using namespace std;

class Screen {
public:
    Screen(const string& c):contents(c){}
    typedef std::string::size_type pos;
    char get_cursor() const { return contents[cursor];}
    char get() const;
    char get(pos ht, pos wd) const;
    static const std::string Screen::*data() {
        return &Screen::contents;
    }
//private:
    std::string contents;
    pos cursor;
    pos height, width;
};

int main() {
    const string Screen::*pdata;
    pdata = &Screen::contents;
    
    cout << pdata << endl;
    
    Screen::pos Screen::*pcursor = &Screen::cursor;
    cout << pcursor << endl;
    
    Screen screen("zhouleqin");
    cout << "screen.*pdata=" << screen.*pdata << endl;
    
    cout << "" << screen.*(screen.data()) << endl;
    return 0;
}
