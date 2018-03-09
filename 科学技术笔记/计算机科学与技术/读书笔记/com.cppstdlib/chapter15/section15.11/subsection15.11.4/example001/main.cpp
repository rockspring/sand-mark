#include <iostream>

using namespace std;

static const int iword_index = std::ios_base::xalloc();


class Fraction {
public:
    Fraction(int n, int d):n_(n), d_(d){}
    int numerator() const{
        return n_;
    }
    int denominator() const{
        return d_;
    }
private:
    int n_;
    int d_;
};

std::ostream& fraction_spaces(std::ostream& strm) {
    strm.iword(iword_index) = true;
    return strm;
}

std::ostream& operator<<(std::ostream& strm, const Fraction& f) {
    if (strm.iword(iword_index)) {
        strm << f.numerator() << " / " << f.denominator();
    } else {
        strm << f.numerator() << "/" << f.denominator();
    }
    return strm;
}

int main() {
    Fraction f(1,2);
    
    cout << f << endl;
    cout << fraction_spaces << f << endl;
    return 0;
}
