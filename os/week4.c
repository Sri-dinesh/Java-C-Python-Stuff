#include<stdio.h>
#include<sys/types.h>
#include<unistd.h>
#include<sys/wait.h>
int main()
{
int pid;
pid= fork(); //fork a child process (create)
if(pid < 0)
{
printf("\n Fork failed to create a child \n");
return 1;
}
else if(pid > 0) // Parent process
{
printf("\n The parent process id is %d \n" , getpid());
printf("\n Parent Process Running \n");
wait(NULL); //Parent waits for child to complete
printf("\n Child Completed \n");
}
else
{
printf(" \n Child Process running \n");
printf("\n The child process id is %d",getpid());
printf("\n The parent of child is %d" , getppid());
// execlp("/bin/ls" ,"ls", “-l” ,NULL);
}
return 0;
}
