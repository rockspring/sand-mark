#include<stdio.h>
#include<stdlib.h> 
/* Function to swap values at two pointers */
void swap (char *x, char *y)
{
    char temp;
    temp = x[0];
    x[0] = y[0];
    y[0] = temp;
}

void permute(char *a, int i, int n)
{
   int j;
   if (i == n-1)
     printf("%s\n", a);
   else
   {
        for (j = i; j < n; j++)
       {
          swap((a+i), (a+j));
          //printf("%s\n", a);
          permute(a, i+1, n);
          swap((a+i), (a+j)); //backtrack
       }
   }
}

int main() {
	//char * arr = "abc\0";
	char * arr =(char *)malloc(4);
	
	arr[0] = 'a';
	arr[1] = 'b';
	arr[2] = 'c';
	arr[3] = '\0';
	//printf("%s\n", arr);
	permute(arr, 0, 3);
	return 0;
}