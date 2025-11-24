#include<stdio.h>
#include<stdlib.h>
#include<string.h>

void bmSearch(char *, char *);
void badCharHeuristic(char *, int, int[]);
void bruteForce(char *, char *);
int max(int, int);

void main() {
  char *t = "Welcome to ADS Lab";
  chat *p = "Lab";

  bmSearch(t, p);
  bruteForce(t, p);
}

void bruteForce(char t[20], char [10]) {
  int flag = 0, n, m, j, i;
  n = strlen(t);
  m = strlen(p);

  for(i = 0; i < n; i++) {
    while(j < m && t[i + j] == p[j])
      j++;
    if(j == m) {
      printf("Using brute force, pattern fond at %d\n", i+1);
      flag = 1;
    }
  }
  if(i == n && flag == 0) {
    printf("Pattern not found\n");
  }
}

void badCharHeuristic(char &str, int m, int badChar[256]) {
  int i;
  for(i = 0; i < 256; i++)
    badChar[i] = -1;
  for(i = 0; i < m; i++)
    badchar[(int) str[i]] = i;
}

void bmSearch(char *txt, char *pat) {
  int m = strlen(pat);
  int n = strlen(txt);
  char badChar[256];
  int i = 0; flag = 0;
  badCharHeuristic(pat, m, badChar);
  whiel( i< (n - m)) {
  j = m - 1;
    while(j >= 0 && pat[i] == txt[i + j])
      j--;
    if(j < 0) {
      printf("using boyer moore pattern found at location = %d\n", i + 1);
      i += (i + m < n) ?  m - badChar(txt[i + m]) : 1;
      flag = 1;
    } else {
      i += max(1, j - badChar[txt + [i + j]]);

      if(i > n - m && flag == 0) {
        printf("Pattern not found in text");
      }
    }
  }
}

int max(int a, int b) {
  return (a > b ) ? a: b;
}
