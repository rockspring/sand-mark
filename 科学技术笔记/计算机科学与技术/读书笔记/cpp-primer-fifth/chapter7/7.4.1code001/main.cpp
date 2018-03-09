#include <iostream>

using namespace std;

typedef double Money;
string bal;

Money bala;

class Account {
public:
    Money balance() {
        return bal; //使用类作用域的变量申明
    }

    Money balance2() {
        return bala; //使用外层作用域的变量申明
    }

private:
    Money bal;
    //typedef double Money; // 错误，不能重新定义Money，但编译器并不检查
    //typedef string Money;
};

int height;

//Screen::pos verify(Screen::pos);

class Screen {
public:
    typedef std::string::size_type pos;

    Screen::pos verify(Screen::pos);
    void setHeight(pos var) {
        height = verify(var);
    };
    pos height = 0;
};



//void Screen::setHeight(pos var) {
//    height = verify(var);
//}

Screen::pos verify(Screen::pos) {
    return 0;
};

int main() {
    Account a;
    Money m =a.balance();
    //string m =a.balance2();

    Screen s;
    s.setHeight(1);
    return 0;
}