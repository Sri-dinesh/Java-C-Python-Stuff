// Process Management System Calls - fork(), exec() & wait().

#include<stdio.h>
#include<sys/types.h>
#include<unistd.h>

int main() {
    int pid;

    pid = fork();

    if(pid < 0) {
        printf("\n Fork failed to create a child !!!\n");

    } else if(pid > 0)  {
        printf("\nThe Parent process id is %d", getpid());
        printf("\nParent process running !!\n");

        wait(NULL);
        printf("\nChild Process Completed...");
        
    } else {
        printf("\nChild Process Running..\n");
        printf("\nThe Child process id is %d", getpid());
        printf("\nThe Parent of Child is %d", getpid());
        execlp("/bin/ls", "ls", "-l", NULL);
    }

    return 0;    
}