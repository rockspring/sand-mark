#include <iostream>
#include <utility>
#include <vector>

using namespace std;

template <typename T1, typename T2>
std::ostream& operator<<(std::ostream& strm, const std::pair<T1, T2>& p) {
    return strm << "[" << p.first << "," << p.second << "]";
}

int main() {
    std::pair<int, long> p(42, 77777);
    std::cout << p << std::endl;
    
    std::vector<std::pair<int, long>> v;
    
    //std::copy(v.begin(), v.end(), std::ostream_iterator<std::pair<int, long>>(std::cout, "\n"));
    return 0;
}
