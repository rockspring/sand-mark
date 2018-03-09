#include <iostream>
#include <bitset>

using namespace std;

void func1() {
    int a = 0b11111111;

    // 100 => 011
    // 1-0 =>0 0&1=0

    cout << "a=" << hex << a << dec << endl;
    cout << "a & (a-1)=" << (a & (a-1));
}


void func2() {
    // 01 => 10
    // 011 => 100
    int a= 0b11111001;
    int b = a + 1;
    int c = a | b;
    std::bitset<8> a_bitset(a);
    std::bitset<8> b_bitset(b);
    std::bitset<8> c_bitset(c);
    cout << "a=" << hex << a << endl;
    cout << "a=" << hex << a_bitset << endl;

    cout << "b=" << hex << b << endl;
    cout << "b=" << hex << b_bitset << endl;

    cout << "c=" << hex << c << endl;
    cout << "c=" << hex << c_bitset << endl;
}

void func3() {
    // 011 => 000

    int a = 0b11111011;
    int b = a + 1;
    int c = a & b;

    std::bitset<8> a_bitset(a);
    std::bitset<8> b_bitset(b);
    std::bitset<8> c_bitset(c);
    cout << "a=" << hex << a << endl;
    cout << "a=" << hex << a_bitset << endl;

    cout << "b=" << hex << b << endl;
    cout << "b=" << hex << b_bitset << endl;

    cout << "c=" << hex << c << endl;
    cout << "c=" << hex << c_bitset << endl;
}

void func4() {
    // 100 => 111

    int a = 0b11111100;
    int b = a - 1;
    int c = a | b;

    std::bitset<8> a_bitset(a);
    std::bitset<8> b_bitset(b);
    std::bitset<8> c_bitset(c);
    cout << "a=" << hex << a << endl;
    cout << "a=" << hex << a_bitset << endl;

    cout << "b=" << hex << b << endl;
    cout << "b=" << hex << b_bitset << endl;

    cout << "c=" << hex << c << endl;
    cout << "c=" << hex << c_bitset << endl;
}

void func5() {
    // 0101 => 0010

    int a = 0b1101;
    int b = a + 1;
    int c = ~a & b;

    std::bitset<4> a_bitset(a);
    std::bitset<4> b_bitset(b);
    std::bitset<4> c_bitset(c);
    cout << "a=" << hex << a << endl;
    cout << "a=" << hex << a_bitset << endl;

    cout << "b=" << hex << b << endl;
    cout << "b=" << hex << b_bitset << endl;

    cout << "c=" << hex << c << endl;
    cout << "c=" << hex << c_bitset << endl;
}

void func6() {
    // 0110 => 1101

    int a = 0b1101;
    int b = a - 1;
    int c = ~a | b; // 1001 | 0101

    std::bitset<8> a_bitset(a);
    std::bitset<8> b_bitset(b);
    std::bitset<8> c_bitset(c);
    cout << "a=0x" << hex << a << endl;
    cout << "a=" << hex << a_bitset << endl;

    cout << "b=0x" << hex << b << endl;
    cout << "b=" << hex << b_bitset << endl;

    cout << "c=0x" << hex << c << endl;
    cout << "c=" << hex << c_bitset << endl;
}

void func7() {
    // 1100 => 0011

    int a = 0b1100;
    int b = a - 1; //1011
    int c = ~a & b; // 0011 | 1011

    std::bitset<8> a_bitset(a);
    std::bitset<8> b_bitset(b);
    std::bitset<8> c_bitset(c);
    cout << "a=0x" << hex << a << endl;
    cout << "a=" << hex << a_bitset << endl;

    cout << "b=0x" << hex << b << endl;
    cout << "b=" << hex << b_bitset << endl;

    cout << "c=0x" << hex << c << endl;
    cout << "c=" << hex << c_bitset << endl;
}

void func8() {
    // 1100 => 0011
    // -x=0100

    int a = 0b1100;
    int b = a | -a; //1011
    int c = ~b; // 0011 | 1011

    std::bitset<8> a_bitset(a);
    std::bitset<8> b_bitset(b);
    std::bitset<8> c_bitset(c);
    cout << "a=0x" << hex << a << endl;
    cout << "a=" << hex << a_bitset << endl;

    cout << "b=0x" << hex << b << endl;
    cout << "b=" << hex << b_bitset << endl;

    cout << "c=0x" << hex << c << endl;
    cout << "c=" << hex << c_bitset << endl;
}

void func9() {
    // 1100 => 0011
    // -x=0100

    int a = 0b1100;
    int b = a & -a;
    int c = b - 1;

    std::bitset<8> a_bitset(a);
    std::bitset<8> b_bitset(b);
    std::bitset<8> c_bitset(c);
    cout << "a=0x" << hex << a << endl;
    cout << "a=" << hex << a_bitset << endl;

    cout << "b=0x" << hex << b << endl;
    cout << "b=" << hex << b_bitset << endl;

    cout << "c=0x" << hex << c << endl;
    cout << "c=" << hex << c_bitset << endl;
}

void func10() {
    // 1010 0111 =>
    // -x=0100

    int a = 0b10100111;
    int b = a + 1;
    int c = ~ a | b;

    std::bitset<8> a_bitset(a);
    std::bitset<8> b_bitset(b);
    std::bitset<8> c_bitset(c);
    cout << "a=0x" << hex << a << endl;
    cout << "a=" << hex << a_bitset << endl;

    cout << "b=0x" << hex << b << endl;
    cout << "b=" << hex << b_bitset << endl;

    cout << "c=0x" << hex << c << endl;
    cout << "c=" << hex << c_bitset << endl;
}

void func11() {
    // 0101 1000 => 0000 1000

    int a = 0b01011000;
    int b = -a;
    int c = a & b;

    std::bitset<8> a_bitset(a);
    std::bitset<8> b_bitset(b);
    std::bitset<8> c_bitset(c);
    cout << "a=0x" << hex << a << endl;
    cout << "a=" << hex << a_bitset << endl;

    cout << "b=0x" << hex << b << endl;
    cout << "b=" << hex << b_bitset << endl;

    cout << "c=0x" << hex << c << endl;
    cout << "c=" << hex << c_bitset << endl;
}

void func12() {
    // 0101 1000 => 0000 1111

    int a = 0b01011000;
    int b = a - 1; //  0101 0111
    int c = a ^ b;

    std::bitset<8> a_bitset(a);
    std::bitset<8> b_bitset(b);
    std::bitset<8> c_bitset(c);
    cout << "a=0x" << hex << a << endl;
    cout << "a=" << hex << a_bitset << endl;

    cout << "b=0x" << hex << b << endl;
    cout << "b=" << hex << b_bitset << endl;

    cout << "c=0x" << hex << c << endl;
    cout << "c=" << hex << c_bitset << endl;
}

void func13() {
    // 0101 0111 => 0000 1111

    int a = 0b01010111;
    int b = a + 1; //  0101 1000
    int c = a ^ b;

    std::bitset<8> a_bitset(a);
    std::bitset<8> b_bitset(b);
    std::bitset<8> c_bitset(c);
    cout << "a=0x" << hex << a << endl;
    cout << "a=" << hex << a_bitset << endl;

    cout << "b=0x" << hex << b << endl;
    cout << "b=" << hex << b_bitset << endl;

    cout << "c=0x" << hex << c << endl;
    cout << "c=" << hex << c_bitset << endl;
}

void func14() {
    // 0101 1100 => 0100 0000

    int a = 0b01011100;
    int b = a + 1; //  0101 1000
    int c = ((a | (a-1)) + 1) & a;

    std::bitset<8> a_bitset(a);
    std::bitset<8> b_bitset(b);
    std::bitset<8> c_bitset(c);
    cout << "a=0x" << hex << a << endl;
    cout << "a=" << hex << a_bitset << endl;

    cout << "b=0x" << hex << b << endl;
    cout << "b=" << hex << b_bitset << endl;

    cout << "c=0x" << hex << c << endl;
    cout << "c=" << hex << c_bitset << endl;
}

void func15() {
    // 0101 1100 => 0100 0000

    int a = 0b01011100;
    int b = a + 1; //  0101 1000
    int c = (( a & -a ) + a) & a;

    std::bitset<8> a_bitset(a);
    std::bitset<8> b_bitset(b);
    std::bitset<8> c_bitset(c);
    cout << "a=0x" << hex << a << endl;
    cout << "a=" << hex << a_bitset << endl;

    cout << "b=0x" << hex << b << endl;
    cout << "b=" << hex << b_bitset << endl;

    cout << "c=0x" << hex << c << endl;
    cout << "c=" << hex << c_bitset << endl;
}

int main() {
    //func1();
    //func2();
    //func3();
    //func4();
    //func5();
    //func6();
    //func7();
    //func8();
    //func9();
    //func10();
    //func11();
    //func12();
    //func13();
    //func14();
    func15();
    return 0;
}