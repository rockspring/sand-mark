#include <iostream>
#include <codecvt>
#include <sys/types.h>
#include <sys/stat.h>
#include <unistd.h>
#include <error.h>

using namespace std;

int main() {
    char path[255] = "/data2/release/search-service-v2-9080/bin/request.2015_11_23.log";
    struct stat *stat_p = (struct stat *) malloc(sizeof(struct stat));
    int stat_result = stat(path, stat_p);
    if (stat_result != 0) {
        error(1, errno, "stat");
    }
    printf("stat_p->st_size=%lld", stat_p->st_size);
    return 0;
}
