#include <future>
#include <iostream>

using namespace std;

int find_the_answer_to_ltuae();

void do_other_stuff();

int find_the_answer_to_ltuae() {
    return 100;
}

void do_other_stuff() {

}

int main() {
    std::future<int> the_answer = std::async(find_the_answer_to_ltuae);
    do_other_stuff();
    std::cout << "The answer is " << the_answer.get() << std::endl;
    return 0;
}