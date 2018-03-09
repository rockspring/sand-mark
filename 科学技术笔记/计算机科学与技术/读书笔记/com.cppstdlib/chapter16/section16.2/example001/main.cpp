#include <iostream>

using namespace std;

int main() {
    try {
        cin.imbue(locale::classic());
        
        cout.imbue(locale("de_DE"));
        
        cout << "input floating-point values(calassic notation): " << endl;
        double value;
        
        while (cin >> value) {
            cout << value << endl;
        }
        
    } catch (const std::exception& e) {
        cerr << "Exception: " << e.what() << endl;
        return EXIT_FAILURE;
    }
    return 0;
}
