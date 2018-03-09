#include <iostream>
#include <curl/curl.h>

using namespace std;

int main() {
    CURL *curl = curl_easy_init();
    if(curl) {
        char *output = curl_easy_escape(curl, "{}a", 15);
        if(output) {
            printf("Encoded: %s\n", output);
            curl_free(output);
        }
    }
    return 0;
}
