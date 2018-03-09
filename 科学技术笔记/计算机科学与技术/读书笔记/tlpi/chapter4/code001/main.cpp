#include <fcntl.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <signal.h>

#define CMD_SIZE 200


int main(int argc, char *argv[]) {
    int open_flags = O_CREAT | O_WRONLY | O_TRUNC;
    mode_t file_perms = S_IRUSR | S_IWUSR | S_IRGRP | S_IWGRP | S_IROTH | S_IWOTH;
    int output_fd = open(argv[1], open_flags, file_perms);

    close(output_fd);

    int ret = chown(argv[1], 1001, 1001);
    printf("chown result = %d", ret);


    char shell_cmd[CMD_SIZE];

    snprintf(shell_cmd, CMD_SIZE, "df -k `dirname %s`", "/vagrant/projects");
    int result = system(shell_cmd);
    printf("system shell_cmd result = %d", result);

    int kill_result = kill(getpid(), SIGKILL);

    printf("kill_result=%d", kill_result);


    return 0;
}