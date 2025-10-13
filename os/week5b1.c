#include<stdio.h>
#include<unistd.h>
#include<sys/types.h>
#include<fcntl.h>
#define size 1024
int main()
{
int fd;
char buf[size];
fd=open("abc",O_RDONLY);
if(fd==-1){
printf("fifo not opened\n");
return 0;
}
read(fd,buf,size);
printf("\nthe message received from FIFO is --->%s",buf);
close(fd);
return 0;
}
