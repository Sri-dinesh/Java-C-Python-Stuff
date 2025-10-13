#include<stdio.h>
#include<sys/types.h>
#include<fcntl.h>
#include<unistd.h>
#include<sys/stat.h>
int main()
{
int fd,x;
char msg[100];
x=mkfifo("abc",0666);
if(x==-1)
{
printf("fifo not created\n");
return 0;
}
fd=open("abc",O_WRONLY);
if(fd==-1)
{
printf("fifo not opened\n");
return 0;
}
printf("Enter the Message to FIFO ");
scanf("%s",msg);
write(fd,msg,sizeof(msg));
close(fd);
sleep(4);
printf("Message written to FIFO \n");
unlink("abc");
return 0;
}
