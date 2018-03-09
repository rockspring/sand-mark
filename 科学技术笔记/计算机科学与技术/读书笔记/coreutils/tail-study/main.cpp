#include <iostream>
#include <signal.h>
#include <sys/inotify.h>

using namespace std;

enum header_mode
{
  multiple_files, always, never
};

static char const *const follow_mode_string[] =
{
        "descriptor", "name", NULL
};

int main() {
    cout << always << endl;

    int wd = inotify_init ();
    return 0;
}