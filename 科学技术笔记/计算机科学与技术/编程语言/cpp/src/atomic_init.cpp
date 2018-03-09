#include <atomic>
#include <iostream>

int main()
{
	std::atomic<int> a;
        std::atomic_init(&a,12);
        std::cout << a << std::endl;
       
        int desired[3]  = { -1, -1, -1 };
std::atomic<int> arr[3];
std::atomic_init(arr, *desired);

        std::cout << arr[0] << std::endl;
}

