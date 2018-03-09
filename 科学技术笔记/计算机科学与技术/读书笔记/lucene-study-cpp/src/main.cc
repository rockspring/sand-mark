/**
 * Author: leqinzhou
 * Date: 2015-05-24
 *
 * This is a simple study program.
 */

#include <codecvt>
#include <locale>
#include <iostream>
#include <iomanip>
#include "number.h"
#include <stdio.h>
#include <string.h>
#include <string>
#include <math.h>
#include <cmath>
#include <bitset>
#include "bit.h"

using std::cin;
using std::cout;
using std::endl;
using std::string;
using std::istream;
using std::ostream;
using std::max;
using std::bitset;
using std::ifstream;

char *s = "`1234567890-=QWERTYUIOP\\ASDFGHJK;'ZXCVBNM,./";

int func1() {
    int i, c;
    while ( (c=getchar()) != EOF) {
        for (i = 1; s[i] && s[i] != c; i++);
            if (s[i]) putchar(s[i-1]);
            else putchar(c);
    }

    return 0;
}

int func2() {
    int c, q = 1;
    while ( (c=getchar()) != EOF) {
        if (c == '"') {
            printf("%s", q? "``": "''");
            q = !q;
        } else {
            printf("%s", c);
        }
    }

    return 0;
}

int func3() {
    char word[1000];
    scanf("%s", word);

    int len = strlen(word);

    for (int i = 1; i <= len; ++i) {
        if (len % i == 0) {
            int ok = 1;
            for (int j = i; j < len; ++j) {
                if (word[j] != word[j % i]) {
                    ok = 0;
                    break;
                }
            }
            if (ok) {
                printf("%d\n", i);
                break;
            }
        }
    }
}

int func4(const char * format, ...) {
    int a, b, c;
    va_list args;
    va_start(args, format);
    int count = vprintf(format, args);
    printf("%d", count);
    va_end(args);
}

int func5() {
    int a, b;

    while (scanf("%d %d", &a, &b) ==2) {
        if (!a && !b) return 0;
        int c = 0, ans=0;
        for (int i = 9; i >=0; --i) {
            c = a%10 + b%10 +c >9 ? 1 : 0;
            ans += c;
            a = a/10;
            b = b/10;
        }
        printf("%d", ans);
    }
}

const int maxn = 1000;

struct bign {
    int len, s[maxn];
    bign() {
        memset(s, 0, sizeof(s));
        len = 1;
    }

    bign operator = (const char* num) {
        len = strlen(num);

        for (int i = 0; i < len; ++i) {
            s[i] = num[i] - '0';
        }

        return *this;
    }

    bign operator = (int num) {
        char s[maxn];
        sprintf(s, "%d", num);
        *this = s;

        return *this;
    }

    bign(int num) {
        *this = num;
    }

    bign(const char* num) {
        *this = num;
    }

    string str() const {
        string res = "";
        for (int i = len-1; i >= 0; --i) {
            res = (char)(s[i] + '0') + res;
        }
        if (res == "") res = "0";

        return res;
    }

    bign operator + (const bign& b) const {
        bign c;
        c.len = 0;

        // g 进位
        for (int i = 0, g=0; g || i < max(len, b.len); ++i) {
            int x = g;
            if (i < len) x += s[i];
            if (i < b.len) x += b.s[i];
            c.s[c.len++] = x % 10;
            g = x /10;
        }

        return c;
    }
};

istream& operator >> (istream &in, bign& x) {
    string s;
    in >> s;
    x = s.c_str();
    return in;
}

ostream& operator << (ostream &out, const bign& x) {
    out << x.str();
    return out;
}


void testBign() {
    bign bign1;
    bign1= "123";

    printf("len=%d\n", bign1.len);
    printf("big1=%s\n", bign1.str().c_str());

    cout << bign1;
}

void testBitSet() {
    bitset<1000> bitset1 = bitset<1000>();
    bitset<1000>::reference reference1 = bitset1[0];
    cout << reference1;
    reference1 = 1;
    cout << reference1;
    bitset1[999] = 1;
    cout << bitset1[999];

    typedef  Bits::MatchAllBits matchAllBits;
    matchAllBits matchAllBits1(1);
    cout << matchAllBits1.length();
}

void func6() {
    int ival;
    while(cin >> ival) {
        cout << ival << endl;
        cout << cin.rdstate() << endl;
        cout << cin.failbit << endl;
        cout << cin.badbit << endl;
        cout << cin.eofbit << endl;
        cout << cin.goodbit << endl;
    }
}

void test_wchar_t() {
    wchar_t c = L'中'; //U+4E2D 20013
    cout << c;
}

void test_raw_narrow_string() {
    const char *s = R"(abcd)";
    cout << s << endl;

    s = R"***(    In the Unicode standard, a plane is a continuous group of )***"
            R"***(65,536 (= 2^16) code points. There are 17 planes, identified by )***"
            R"***(the numbers 0 to 16[decimal], which corresponds with the possible values )***"
            R"***(00–10[hexadecimal] of the first two positions in six position format )***"
            R"***((hhhhhh). The planes above plane 0 (the Basic Multilingual Plane), )***"
            R"***(that is, planes 1–16, are called “supplementary planes”,[1] or )***"
            R"***(humorously known as “astral planes”. As of Unicode version 7.0, six )***"
            R"***(of the planes have assigned code points (characters), and four are )***"
            R"***(named.
        The 17 planes can accommodate 1,114,112 code points, a limit which is unlikely to be reached in the foreseeable future even if previously unknown scripts with tens of thousands of characters are discovered. The odd-looking code points limit (which is not a power of 2) is due to the design of UTF-16. In UTF-16 a "surrogate pair" of two 16-bit words is used to encode 220 code points in the planes 1 to 16, in addition to the use of single code units to encode the 216 points of plane 0.[2] This limit is not shared by UTF-8, which was designed with a limit of 231 code points (32768 planes), and can encode 221 code points (32 planes) even if limited to 4 bytes.[3] However, the Unicode Consortium has stated that the current limit will never be changed.)***";

    const char * title_en = R"(What is Unicode?)";
    const char * description_en = R"(Unicode provides a unique number for every character,
            no matter what the platform,
            no matter what the program,
            no matter what the language.)";

    const char *title_ch = R"***(什么是Unicode(统一码)?)***"; // ***(...)***为一对分隔符
    const char *description_ch = R"(Unicode给每个字符提供了一个唯一的数字，
            不论是什么平台、
            不论是什么程序、
            不论是什么语言。)"; // (...)为一对分隔符

    const char *body_en = R"(Fundamentally, computers just deal with numbers. They store letters and other characters)"
                          R"(by assigning a number for each one. Before Unicode was invented, there were hundreds of )"
                          R"(different encoding systems for assigning these numbers. No single encoding could contain )"
                          R"(enough characters: for example, the European Union alone requires several different )"
                          R"(encodings to cover all its languages. Even for a single language like English no single )"
                          R"(encoding was adequate for all the letters, punctuation, and technical symbols in common )"
                          R"(use.)";

    const char *body_ch = R"(基本上，计算机只是处理数字。它们指定一个数字，来储存字母或其他字符。在创造Unicode之前，有数百种指定这些)"
                          R"(数字的编码系统。没有一个编码可以包含足够的字符，例如：单单欧洲共同体就需要好几种不同的编码来包括所有的语)"
                          R"(言。即使是单一种语言，例如英语，也没有哪一个编码可以适用于所有的字母、标点符号，和常用的技术符号。)";

    cout << title_en << endl;
    cout << description_en << endl;
    cout << title_ch << endl;
    cout << description_ch << endl;
}

void test_convert() {
    typedef std::codecvt<wchar_t,char,std::mbstate_t> facet_type;

    std::locale mylocale;

    const facet_type& myfacet = std::use_facet<facet_type>(mylocale);

    const char mystr[] = "Test string中";

    // prepare objects to be filled by codecvt::in :
    wchar_t pwstr[sizeof(mystr)];              // the destination buffer (might be too short)
    std::mbstate_t mystate = std::mbstate_t(); // the shift state object
    const char* pc;                            // from_next
    wchar_t* pwc;                              // to_next

    // translate characters:
    facet_type::result myresult = myfacet.in (mystate,
                                              mystr, mystr+sizeof(mystr), pc,
                                              pwstr, pwstr+sizeof(mystr), pwc);

    if ( myresult == facet_type::ok )
    {
        std::wcout << L"Translation successful: ";
        std::wcout << pwstr << std::endl;
    }
}

void test_convert_out_utf8() {
    typedef std::codecvt_byname<wchar_t,char,std::mbstate_t> facet_type;

    //facet_type * a = new facet_type ("UTF-8");

    std::locale mylocale(std::locale ("C"), new facet_type("en_US.UTF-8"));
    //std::locale mylocale("en_US.UTF-8");

    const facet_type& myfacet = std::use_facet<facet_type>(mylocale);

    std::wstring mywstring;
    std::cout << "Enter sentence: ";
    std::getline (std::wcin,mywstring);

    std::wstring::size_type length = mywstring.length();

    // prepare objects to be filled by codecvt::out :
    char* pstr= new char [length+1];           // the destination buffer (might be too short)
    std::mbstate_t mystate = std::mbstate_t(); // the shift state object
    const wchar_t* pwc;                        // from_next
    char* pc;                                  // to_next

    // call codecvt::out (translate characters):
    facet_type::result myresult = myfacet.out (mystate,
                                               mywstring.c_str(), mywstring.c_str()+length+1, pwc,
                                               pstr, pstr+length+1, pc);

    if (myresult==facet_type::ok)
        std::cout << "Translation successful: " << pstr << '\n';

    int i = 1;
    const char *chinese_u8_byte = pstr;
    while(*chinese_u8_byte != 0) {
        cout <<"第" << i << "个字节:" << std::dec << "10进制（" << (*chinese_u8_byte & 0xff) << ")，16进制（" << std::hex << (*chinese_u8_byte & 0xff) << ")\n";
        i++;
        chinese_u8_byte++;
    }

    delete[] pstr;
}


void test_ifstream4() {
    using namespace std;

    locale wcin_loc{wcin.getloc(), new codecvt_utf8<wchar_t>{}};
    wcin.imbue(wcin_loc);

    locale wcout_loc{wcout.getloc(), new codecvt_utf8<wchar_t>{}};
    wcout.imbue(wcout_loc);

    wcout << "Len Word" << endl;
    wcout << "=== ====" << endl;

    for (wstring str; wcin >> str; )
    {
        wcout << setw(3) << str.length() << " " << str << endl;
    }

}

int main(int argc, char **argv) {
    int c = s[1];
    //printf("%d", s[1]);
    //func4("%s", "zlq");
    //func5();
    //testBign();
    testBitSet();
    exit(0);
    cout << "Hello World!" << endl;
    cout << lowestOneBit(3) << endl;
    return 0;
}
