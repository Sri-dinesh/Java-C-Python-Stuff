#include<stdio.h>
#include<stdlib.h>
#include<string.h>


void computeLPSArray(char[], int, int[]);
void KMPSearch(char*, char*);

void main() {
  char *t = "Welcome to ADS Lab";
  char *p = "ADS";
  KMPSearch(t, p);
}

void computeLPSArray(char *pat, int m, int lps[]) {
  int len = 0;
  int i = 1;
  lps[0] = 0;

  while(i < m) {
    if(pat[i] == pat[len]) {
      len++;
      lps[i] = len;
      i++;
    } else {
      if(len != 0) {
        len = lps[len-1];
      } else {
        lps[i] = len;
        i++;
      }
    }
  }
}

void KMPSearch(char *txt, char *pat) {
  int m = strlen(pat);
  int n = strlen(txt);
  int lps[m];

  computeLPSArray(pat, m, lps);

  int i = 0;
  int j = 0;


  while(i < n) {
        if(pat[j] == txt[i]) {
            i++;
            j++;
        }
        if(j == m) {
            printf("Pattern found at index %d\n", i - j);
            j = lps[j - 1];
        }
        else if(i < n && pat[j] != txt[i]) {
            if(j != 0)
                j = lps[j - 1];
            else
                i++;
        }
    }
}
