#include <iostream>
#include <fstream>
#include <vector>
#include <string>
#include <set>
#include <map>
#include <cstddef>
#include <locale>
#include <codecvt>
#include <sys/mman.h>
#include <sys/types.h>
#include <unistd.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <assert.h>

using std::cout;
using std::cin;
using std::cerr;
using std::endl;
using std::istream_iterator;
using std::ifstream;
using std::ofstream;
using std::string;
using std::set;
using std::u16string;
using std::wcout;
using std::wifstream;

void cStyleStringFileRead() {
    ifstream ifs("in-belgiums-strawberry-fields-perfections-in-the-picking.txt", std::ifstream::in);
    char c = ifs.get();

    while (ifs.good()) {
        std::cout << c;
        c = ifs.get();
    }

    ifs.close();
}

void stringStyleStringFileRead() {
    string name("in-belgiums-strawberry-fields-perfections-in-the-picking.txt");
    ifstream ifs(name, std::ifstream::in);// name引用传值
    char c = ifs.get();

    while (ifs.good()) {
        std::cout << c;
        c = ifs.get();
    }

    ifs.close();
}

void stringStyleStringFileRead2() {
    string name("in-belgiums-strawberry-fields-perfections-in-the-picking.txt");
    ifstream ifs(name);// name引用传值
    char c = ifs.get();

    while (ifs.good()) {
        std::cout << c;
        c = ifs.get();
    }

    ifs.close();
}

void stringStyleStringFileRead3() {
    string name("in-belgiums-strawberry-fields-perfections-in-the-picking.txt");
    ifstream ifs(name, std::ifstream::in);// name引用传值
    char c;

    while (ifs >> c) {
        std::cout << c;
    }

    ifs.close();
}

void stringStyleStringFileRead4() {
    string name("in-belgiums-strawberry-fields-perfections-in-the-picking.txt");
    ifstream ifs(name, std::ifstream::in);// name引用传值

    std::map<string, size_t> word_count;
    set<string> exclude = {"The", "But", "And", "Or", "An", "A",
                           "the", "but", "and", "or", "an", "a"};
    string c;

    while (ifs >> c) {
        if (exclude.find(c) == exclude.end())
        {
            size_t index_of_comma = c.find(",");

            if (index_of_comma != string::npos)
            {
                /* code */
                cout << index_of_comma << "...............................\n";
                c = c.substr(0, index_of_comma);
            }

            size_t index_of_full_stop = c.find(".");
            if (index_of_full_stop != -1)
            {
                /* code */
                c = c.substr(0, index_of_full_stop);
            }

            size_t index_of_double_quote = c.find("“");
            //cout << index_of_double_quote << "...............................\n";
            if (index_of_double_quote != -1)
            {
                /* code */
                //c = c.replace(index_of_double_quote, 2, "");
                c = c.substr(0, index_of_double_quote) + c.substr(index_of_double_quote+2, c.size());
            }

            ++word_count[c];
        } else {
            std::cout << c << "\n";
        } 
    }
    for (const auto &w : word_count)
    {
        /* code */
        cout << w.first << " occurs " << w.second
            << ((w.second > 1) ? "times " : " time") << endl;
    }

    ifs.close();
}

void stringStyleStringFileRead5() {
    /*u16string name("in-belgiums-strawberry-fields-perfections-in-the-picking.txt");
    wifstream ifs(name, std::wifstream::in);// name引用传值

    std::map<u16string, size_t> word_count;
    set<u16string> exclude = {"The", "But", "And", "Or", "An", "A",
                           "the", "but", "and", "or", "an", "a"};
    u16string c;

    while (ifs >> c) {
        if (exclude.find(c) == exclude.end())
        {
            size_t index_of_comma = c.find(",");

            if (index_of_comma != u16string::npos)
            {
                wcout << index_of_comma << "...............................\n";
                c = c.substr(0, index_of_comma);
            }

            size_t index_of_full_stop = c.find(".");
            if (index_of_full_stop != -1)
            {
                c = c.substr(0, index_of_full_stop);
            }

            size_t index_of_double_quote = c.find("“");
            //cout << index_of_double_quote << "...............................\n";
            if (index_of_double_quote != -1)
            {
                //c = c.replace(index_of_double_quote, 2, "");
                c = c.substr(0, index_of_double_quote) + c.substr(index_of_double_quote+2, c.size());
            }

            ++word_count[c];
        } else {
            std::wcout << c << "\n";
        } 
    }
    for (const auto &w : word_count)
    {
        wcout << w.first << " occurs " << w.second
            << ((w.second > 1) ? "times " : " time") << endl;
    }

    ifs.close();*/
}

void test_w_string() {
    /*u16string a(u"a");
    //using namespace std;
    std::u32string str ( U"\U00004f60\U0000597d" );  // ni hao (你好)

    std::locale loc (std::locale(), new std::codecvt_utf8<char32_t>);
    std::basic_ofstream<char32_t> ofs ("test.txt");
    ofs.imbue(loc);

    std::cout << "Writing to file (UTF-8)... ";
    ofs << str;
    std::cout << "done!\n";*/
}

void test_map() {
    char *data = NULL;
    int fd=open("in-belgiums-strawberry-fields-perfections-in-the-picking.txt",O_RDONLY); 
    long size = lseek(fd, 0, SEEK_END);
    data = (char *) mmap( NULL,  size ,PROT_READ, MAP_PRIVATE, fd, 0 );
    for (int i = 0; i < size; ++i)
    {
        /* code */
        cout << *data++;
    }
}

void test_char() {
    //Narrow-character literals of type char
    char c = 'a';
    cout << c << endl;
    cout << (int)c << endl; // 10进制整数97

    c = '\141'; // 8进制
    c = '\x61'; // 16进制
    //c = '\U0061'
    cout << c << endl;
}

void test_wchar_t() {
    //Wide-character literals of type wchar_t
    wchar_t c = L'中'; //U+4E2D 20013
    cout << c << endl;
    c = L'\U00004E2D'; // supplementary planes 8位16进制整数 32-bit Unicode escape sequence UTF-32 encoded string literal
    cout << c << endl;
    c = L'\u4E2D'; // Basic Multilingual Plane UTF-16 encoded string literal
    cout << c << endl;

    c = L'\u0061'; // 16-bit Unicode escape sequence
    cout << c << endl;
}

void test_narrow_string() {
    const char *s = "abcd";
    cout << s;
}

void test_wide_string() {
    const wchar_t *s = L"abcd";
    cout << s;
}

void test_raw_narrow_string() {
    const char *s = R"(abcd)";
    cout << s << endl;

    // (...)为一对分隔符
    const char * title_en = R"(What is Unicode?)";
    // (...)为一对分隔符
    const char * description_en = R"(Unicode provides a unique number for every character,
            no matter what the platform,
            no matter what the program,
            no matter what the language.)";
    // (...)为一对分隔符
    const char *body_en = R"(Fundamentally, computers just deal with numbers. They store letters and other characters)"
                          R"(by assigning a number for each one. Before Unicode was invented, there were hundreds of )"
                          R"(different encoding systems for assigning these numbers. No single encoding could contain )"
                          R"(enough characters: for example, the European Union alone requires several different )"
                          R"(encodings to cover all its languages. Even for a single language like English no single )"
                          R"(encoding was adequate for all the letters, punctuation, and technical symbols in common )"
                          R"(use.)";

    const char *title_ch = R"***(什么是Unicode(统一码)?)***"; // ***(...)***为一对分隔符
    const char *description_ch = R"(Unicode给每个字符提供了一个唯一的数字，
            不论是什么平台、
            不论是什么程序、
            不论是什么语言。)"; // (...)为一对分隔符

    // (...)为一对分隔符
    const char *body_ch = R"(基本上，计算机只是处理数字。它们指定一个数字，来储存字母或其他字符。在创造Unicode之前，有数百种指定这些)"
                          R"(数字的编码系统。没有一个编码可以包含足够的字符，例如：单单欧洲共同体就需要好几种不同的编码来包括所有的语)"
                          R"(言。即使是单一种语言，例如英语，也没有哪一个编码可以适用于所有的字母、标点符号，和常用的技术符号。)";


    cout << title_en << endl;
    cout << description_en << endl;
    cout << body_en << endl;
    cout << title_ch << endl;
    cout << description_ch << endl;
    cout << body_ch << endl;

    ofstream txt_file("a.txt");
    txt_file << title_ch << "\n" << description_ch << "\n" << body_ch;
}

void test_raw_wide_string() {
    const char *s = R"(abcd)";
    s = NULL;
    const char *chinese = u8R"(中文)";
    chinese = u8R"(中)";
    cout << sizeof(chinese) << endl;
    int c;
    cout << std::showbase << std::hex;
    for (int i = 0; i < sizeof(chinese); ++i)
    {
        /* code */
        c = 0xff & chinese[i];
        cout << c << endl;
    }

    ofstream txt_file("a.txt");
    txt_file << chinese;
}

void test_char_string() {
    const char * chinese = "中";

    cout << sizeof(chinese) << endl;
    int c;
    cout << std::showbase << std::hex;
    for (int i = 0; i < sizeof(chinese); ++i)
    {
        /* code */
        c = 0xff & chinese[i];
        cout << c << endl;
    }

    ofstream txt_file("a.txt");
    txt_file << chinese;

    const char * a = "中";
    cout << a << endl;
    printf("%s\n", a);
}

void test_char_utf8_literal() {
    // utf-8
    const char * chinese_u8 = u8"𝓐";

    cout << "\ncout << chinese_u8显示结果" << chinese_u8 << "\n";

    int i = 1;
    const char *chinese_u8_byte = chinese_u8;
    while(*chinese_u8_byte != 0) {
        cout <<"第" << i << "个字节:" << std::dec << "10进制（" << (*chinese_u8_byte & 0xff) << ")，16进制（" << std::hex << (*chinese_u8_byte & 0xff) << ")\n";
        i++;
        chinese_u8_byte++;
    }

    // utf-16
    const char16_t * chinese_u = u"𝓐";
    cout << "\ncout << chinese_u显示结果：" << chinese_u << "\n";

    const char16_t *chinese_u_c = chinese_u;
    i = 1;
    while(*chinese_u_c != 0) {
        cout <<"第" << i << "个char16_t:" << std::dec << "10进制（" << (*chinese_u_c & 0xffff) << ")，16进制（" << std::hex << (*chinese_u_c & 0xffff) << ")\n";
        i++;
        chinese_u_c++;
    }

    
    // utf-32
    const char32_t * chinese_u32 = U"𝓐";
    cout << "\ncout << chinese_u32显示结果：" << chinese_u32 << "\n";

    const char32_t *chinese_u32_c = chinese_u32;
    i = 1;
    while(*chinese_u32_c != 0) {
        cout <<"第" << i << "个char32_t:" << std::dec << "10进制（" << *chinese_u32_c << ")，16进制（" << std::hex << *chinese_u32_c << ")\n";
        i++;
        chinese_u32_c++;
    }

    // L"..."
    const wchar_t * chinese_L = L"𝓐";
    cout << "\nwcout << chinese_L显示结果：" << std::endl;
    wcout << chinese_L;
    wcout << "\n" << std::endl;

    const wchar_t *chinese_L_c = chinese_L;
    i = 1;
    while(*chinese_L_c != 0) {
        cout <<"第" << i << "个wchar_t:" << std::dec << "10进制（" << *chinese_L_c << ")，16进制（" << std::hex << *chinese_L_c << ")\n";
        i++;
        chinese_L_c++;
    }

    // "..."
    const char * chinese_char = "𝓐";
    cout << "\ncout << chinese_u32显示结果：" << chinese_char << "\n";

    const char *chinese_char_c = chinese_char;
    i = 1;
    while(*chinese_char_c != 0) {
        cout <<"第" << i << "个wchar_t:" << std::dec << "10进制（" << (*chinese_char_c & 0xff) << ")，16进制（" << std::hex << (*chinese_char_c & 0xff) << ")\n";
        i++;
        chinese_char_c++;
    }

    // write to file using utf-8
    std::locale loc;

  const std::codecvt<wchar_t,char,mbstate_t>& myfacet = 
    std::use_facet<std::codecvt<wchar_t,char,mbstate_t> >(loc);

  std::cout << "Characteristics of codecvt<wchar_t,char,mbstate_t>:\n";
  std::cout << "Encoding: " << myfacet.encoding() << '\n';
  std::cout << "Always noconv: " << myfacet.always_noconv() << '\n';
  std::cout << "Max length: " << myfacet.max_length() << '\n';
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

void test_convert_out() {
    typedef std::codecvt<wchar_t,char,std::mbstate_t> facet_type;

  std::locale mylocale;

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

void test_convert_out_utf8() {
    typedef std::codecvt_byname<wchar_t,char,std::mbstate_t> facet_type;

    //facet_type * a = new facet_type ("UTF-8");

  std::locale mylocale(std::locale("C"), new facet_type("en_US.UTF-8"));
  //std::locale mylocale("en_US.UTF-8");

  const facet_type& myfacet = std::use_facet<facet_type>(mylocale);

  std::wstring mywstring;
  std::cout << "Enter sentence: ";
  std::getline(std::wcin, mywstring);

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

void test_wchar_t_input() {
    std::wstring mywstring;
    std::cout << "Enter sentence: ";
    std::wcin >> mywstring;
    std::wcout << mywstring;
}

void test_wchar_t_input_point() {
    wchar_t mywstring;
    std::cout << "Enter sentence: ";
    std::wcin >> mywstring;
    std::wcout << mywstring;
}

void test_locale_input() {
    typedef std::codecvt_byname<wchar_t, char, std::mbstate_t> Cvt;

//std::wcin.imbue (std::locale (std::locale ("C"), new Cvt ("en_US.UTF-8")));
//std::wcout.imbue (std::locale (std::locale ("C"), new Cvt ("en_US.UTF-8")));

std::wstring mywstring;
std::wcin >> mywstring;
    std::wcout << mywstring;

//std::wcout << std::wcin.rdbuf ();
cout << (std::wcin.good() && std::wcout.good ());
}

void test_ifstream() {
    string input_file_name("in-belgiums-strawberry-fields-perfections-in-the-picking.txt");
    //ifstream input_file("in-belgiums-strawberry-fields-perfections-in-the-picking.txt");
    ifstream input_file(input_file_name);
    cout << input_file.tellg() << "\n";
    string line;
    getline(input_file, line);
    cout << line << "\n";
    cout << input_file.tellg() << "\n";
    input_file.seekg(0, std::fstream::end);
    cout << input_file.tellg() << "\n";
}

void test_ifstream2() {
    string input_file_name("in-belgiums-strawberry-fields-perfections-in-the-picking.txt");
    //ifstream input_file("in-belgiums-strawberry-fields-perfections-in-the-picking.txt");
    ifstream input_file(input_file_name);
    cout << input_file.tellg() << "\n";
    string line;
    getline(input_file, line);
    cout << line << "\n";
    cout << input_file.tellg() << "\n";
    input_file.seekg(0, std::fstream::end);
    cout << input_file.tellg() << "\n";
}

void test_ifstream3() {
    string input_file_name("emotion_quotient_and_intelligence_quotient.txt");
    //ifstream input_file("in-belgiums-strawberry-fields-perfections-in-the-picking.txt");
    ifstream input_file(input_file_name);
    input_file.seekg(0, std::fstream::end);
    cout << input_file.tellg() << "\n";

    input_file.seekg(0, std::fstream::beg);

    cout << input_file.tellg() << "\n";
    string line;
    getline(input_file, line);
    cout << line << "\n";

    for (int i = 0; i < line.size(); ++i)
    {
        /* code */
        printf("%d\n", line[i]);
    }
    cout << input_file.tellg() << "\n";
    input_file.seekg(0, std::fstream::end);
    cout << input_file.tellg() << "\n";
}

void test_ifstream4() {
    std::ifstream is ("emotion_quotient_and_intelligence_quotient.txt", std::ifstream::binary);
  if (is) {
    // get length of file:
    is.seekg (0, is.end);
    int length = is.tellg();
    is.seekg (0, is.beg);

    char * buffer = new char [length];

    std::cout << "Reading " << length << " characters... ";
    // read data as a block:
    is.read (buffer, length);

    if (is)
      std::cout << "all characters read successfully.";
    else
      std::cout << "error: only " << is.gcount() << " could be read";
    is.close();

    // ...buffer contains the entire file...

    delete[] buffer;
  }

}

void test_ifstream5() {
    std::ifstream ifs("emotion_quotient_and_intelligence_quotient.txt", std::ifstream::in);
    char c = ifs.get();

    int i = 0;
      while (ifs.good()) {
        std::cout << c;
        c = ifs.get();

        if (i >1) {
            break;
        }
        i++;
      }

      ifs.close();
}

void test_ifstream6() {
    std::wifstream ifs("emotion_quotient_and_intelligence_quotient.txt", std::ifstream::in);
    //std::wifstream ifs("in-belgiums-strawberry-fields-perfections-in-the-picking.txt");
    std::wofstream ofs("emotion_quotient_and_intelligence_quotient.txt.out", std::ifstream::out);
    /**char c = ifs.get();

    int i = 0;
      while (ifs.good()) {
        std::cout << (int)c << "\n";
        c = ifs.get();
        i++;
      }

      cout << i << "\n";**/

      wchar_t line[1024];
      //= new wchar_t[1024];
      //assert(ifs.eof());
      //ifs.clear();
      ifs.clear();
      assert(!ifs.eof());
      cout << "after reset file position:" << ifs.tellg() << "\n";

      cout << "std::ifstream::beg " << ifs.beg << "\n";
      ifs.seekg(0, std::ifstream::beg);
      cout << "before read line file position:" << ifs.tellg() << "\n";

      // 读取utf-8编码的文件，使用Unicode编码存储
      cout << "ifs status:" << ifs.rdstate() << "\n";
      ifs.imbue(std::locale(ifs.getloc(),
          new std::codecvt_utf8<wchar_t, 0x10ffff, std::little_endian>));
      //ifs.getline(line, 3);
      ifs.read(line, 3);

      //wcout输出内容
      cout << "start wcout" << "\n";
      wcout.imbue(std::locale(wcout.getloc(),
          new std::codecvt_utf8<wchar_t, 0x10ffff, std::little_endian>));
      for (int i = 0; i < 3; ++i)
      {
          /* code */
            wcout << "wcout " << line[i] << "\n";
      }

      cout << "finish wcout" << "\n";
      

      // 写入一个文件，使用utf-8编码
      ofs.imbue(std::locale(ifs.getloc(),
          new std::codecvt_utf16<wchar_t, 0x10ffff, std::little_endian>));

      ofs.write(line, 3);
      ofs.close();
      cout << "read line file cout:" << ifs.gcount() << "\n";
      for (int i = 0; i < ifs.gcount(); ++i)
      {
          /* code */
            cout << line[i] << "\n";
      }
      cout << "after read line file position:" << ifs.tellg() << "\n";

      //cout << line << "\n";

      ifs.clear();
      cout << "after reset file position:" << ifs.tellg() << "\n";
      ifs.seekg(0, ifs.beg);

      cout << "before read file position:" << ifs.tellg() << "\n";

      wchar_t word;

      while(ifs.good()) {
        ifs.get(word);
      //cout << "file position:" << ifs.tellg() << "\n";
      }
      


      ifs.close();
}

int main() {
    //stringStyleStringFileRead4();
    //test_w_string();
    //test_map();
    //test_char();
    //test_wchar_t();
    //test_narrow_string();
    //test_wide_string();
    //test_raw_narrow_string();
    //test_raw_wide_string();
    //test_char_string();
    //test_char_utf8_literal();
    //test_convert();
    //test_convert_out();
    //cout << sizeof(wchar_t);
    //test_convert_out_utf8();
    //test_wchar_t_input();
    //test_wchar_t_input_point();
    //test_locale_input();
    //test_ifstream();
    //test_ifstream4();
    //test_ifstream5();
    test_ifstream6();
    return 0;
}