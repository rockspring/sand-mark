#include <iostream>
#include <locale>

int main() {
std::locale::global(std::locale("en_US.UTF-8"));
	std::wcout << L"中文";
return 0;

}
