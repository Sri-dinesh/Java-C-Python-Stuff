#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <stdio.h>
#include <stdlib.h>
#define SHMSZ 27
void main(){
int shmid;
key_t key;
char *shm, *s;
key = 5678;
if ((shmid = shmget(key, SHMSZ, 0666)) < 0) {
printf("shared memory cannot be opened");
exit(1);
}
if ((shm = shmat(shmid, NULL, 0)) == (char *) -1) {
perror("Can not be attached to shared memory");
exit(1);
}
//Read Alphabets from shared memory
for (s = shm; *s != NULL; s++)
putchar(*s);
putchar('\n');
}