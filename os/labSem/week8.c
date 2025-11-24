// Semaphores --> Producer-Consumer Problem

#include<stdio.h>
#include<stdlib.h>

int mutex  = 1;
int full = 0;
int empty = 1; 
int x = 0;

void producer() {
    --mutex;
    ++full;
    --empty;

    printf("\nEnter an item to produce --> ");
    scanf("%d", &x);

    printf("\nProducer produced item -> %d", x);
    ++mutex;
}

void consumer() {
    --mutex;
    --full;
    ++empty;

    printf("\nConsumer consumed item -> %d", x);
    x = 0;
    ++mutex;
}

int main() {
    int n, i;

    printf("\n1. Press 1 for Producer\n2. Press 2 for Consumer\n3. Press 3 for exit.");

    for(int i = 1; i > 0; i++) {
        printf("\nEnter your choice:");
        scanf("%d", &n);

        switch(n) {
            case 1: 
            if((mutex == 1) && (empty != 0)) {
                producer();
            } else {
                printf("\nBuffer is Full");
            }
            break;
            
            case 2:
                if((mutex == 1) && (full != 0)) {
                    consumer();
                } else {
                    printf("\nBuffer is Empty");
                }
            break;
            
            case 3:
                exit(0);
            break;
            
            default:
                printf("\nEntered Invalid Choice");
            break;
        }
    }
}

/*

1.  Understand the Goal: We are simulating the Producer-Consumer problem where a producer adds items to a buffer and a consumer removes them. We use "semaphores" (variables) to manage access.

2.  Variables Setup:
    -->   `mutex = 1`: Acts as a lock (1 = unlocked, 0 = locked).
    -->   `full = 0`: Counts how many slots are full (starts with 0 items).
    -->   `empty = 1`: Counts how many slots are empty (starts with 1 empty slot).
    -->   `x = 0`: The item being produced/consumed.

3.  Producer Function:
    -->   Lock & Update Counts: Decrease `mutex` (lock), Increase `full` (item added), Decrease `empty` (space used).
    -->   Action: Ask user for input (`x`) and print "Producer produced...".
    -->   Unlock: Increase `mutex` (release lock).

4.  Consumer Function:
    -->   Lock & Update Counts: Decrease `mutex` (lock), Decrease `full` (item removed), Increase `empty` (space freed).
    -->   Action: Print "Consumer consumed..." and reset `x`.
    -->   Unlock: Increase `mutex` (release lock).

5.  Main Loop Logic:
    -->   Create an infinite loop (`for(int i=1; i>0; i++)`) to keep asking for choices.
    -->   Choice 1 (Produce):
        -->   Check: Is it unlocked (`mutex==1`) AND is there space (`empty!=0`)?
        -->   If YES: Call `producer()`.
        -->   If NO: Print "Buffer is Full".
    -->   Choice 2 (Consume):
        -->   Check: Is it unlocked (`mutex==1`) AND are there items (`full!=0`)?
        -->   If YES: Call `consumer()`.
        -->   If NO: Print "Buffer is Empty".
    -->   Choice 3: Exit.

Easy Memory Trick:
-->   Producer: `mutex--`, `full++`, `empty--` (Make space full).
-->   Consumer: `mutex--`, `full--`, `empty++` (Make space empty).
-->   Conditions: Producer needs `empty != 0`. Consumer needs `full != 0`. Both need `mutex == 1`
*/
