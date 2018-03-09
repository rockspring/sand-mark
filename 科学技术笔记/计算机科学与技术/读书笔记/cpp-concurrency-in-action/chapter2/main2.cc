#include <iostream>
#include <thread>

struct func
{
	/* data */
	int& i;
	func(int& i_):i(i_){}

	void operator()() {
		for (unsigned j = 0; j < 1000000; ++j)
		{
			/* code */
			do_something(i);
		}
	}
};

void oops() {
	int some_local_state = 0;
	func my_func(some_local_state);
	std::thread my_thread(my_func);
	my_thread.detach();
}

void hello()
{
	while (true) {
		std::cout<<"Hello Concurrent World\n";
	}
}

int main()
{
 std::thread t(hello);
 //t.join();
 while (true) {
 	
 }
}