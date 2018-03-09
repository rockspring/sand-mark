#include <iostream>
#include <thread>
void hello()
{
	while (true) {
		std::cout<<"Hello Concurrent World\n";
	}
}

int main()
{
 std::thread t(hello);
 t.detach();
 //t.join();
 /*while (true) {

 }*/
}