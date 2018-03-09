#include <iostream>

using namespace std;

#if defined(__POPCNT__) && defined(__GNUC__) && (__GNUC__> 4 || (__GNUC__== 4 && __GNUC_MINOR__> 1))
#define HAVE_BUILTIN_POPCOUNTLL
#endif
static uint64_t bitcount64(uint64_t b) {
    b -= (b >> 1) & 0x5555555555555555;
    b = (b & 0x3333333333333333) + ((b >> 2) & 0x3333333333333333);
    b = (b + (b >> 4)) & 0x0f0f0f0f0f0f0f0f;
    return (b * 0x0101010101010101) >> 56;
}
/* For 32-bit, an 8-bit table may or may not be a little faster */
static uint32_t bitcount32(uint32_t b) {
    b -= (b >> 1) & 0x55555555;
    b = (b & 0x33333333) + ((b >> 2) & 0x33333333);
    b = (b + (b >> 4)) & 0x0f0f0f0f;
    return (b * 0x01010101) >> 24;
}

size_t popcount(unsigned long long n) {
    return std::bitset<CHAR_BIT * sizeof n>(n).count();
}

int main() {
    unsigned long long x = 0b11;

    cout << "popcount:" << popcount(x) << endl;

    // __builtin_popcount() for unsigned int
    // __builtin_popcountl() for unsigned long
    // __builtin_popcountll() for unsigned long long
    uint64_t p = __builtin_popcountll(0b1);

    cout << "p=" << p << endl;

    cout << "__builtin_popcount:" << __builtin_popcount(0b1u) << endl;
    cout << "__builtin_popcountl:" << __builtin_popcountl(0b11l) << endl;
    cout << "__builtin_popcountll:" << __builtin_popcountll(0b111ll) << endl;

    cout << "__builtin_ctz: " << __builtin_ctz(0b100) << endl;

    cout << "__builtin_clrsb: " << __builtin_clz(0b1) << endl;

    cout << (-3 ^ -1) - (-1) << endl;
    return 0;
}