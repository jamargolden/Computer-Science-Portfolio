/* 
 * Basic C program to print out hello world! 
 * Author: Jamar Golden
*/

#include <stdio.h>
#include <stdlib.h>
#include<string.h>

char* topics[6] = {"G.Warming", "Equality", "Immegration", "Tax Reform", "Preservation", "Gun Control"};

int responses[5][6];
int place(int rating, int question);
int table();

int main(void) {
   int bool = 0;
   int Q1, Q2, Q3, Q4, Q5, Q6;

   while(bool == 0){
      printf("Welcome to my Survey on issues");
      printf("Q1: On a scale of 1-5 how inmportant is Global Warming?");
      scanf("\n%d", &Q1);
      place(Q1, 1);
      printf("Q2: On a scale of 1-5 how important is equality?");
      scanf("\n%d", &Q2);
      place(Q2, 2);
      printf("Q3: On a scale of 1-5 how important is immegration?");
      scanf("\n%d", &Q3);
      place(Q3, 3);
      printf("Q4: On a scale of 1-5 how important is Tax Reform?");
      scanf("\n%d", &Q4);
      place(Q4, 4);
      printf("Q5: On a scale of 1-5 how important is Wildlife Preservation?");
      scanf("\n%d", &Q5);
      place(Q5, 5);
      printf("Q6: On a scale of 1-5 how important is Gun Control?");
      scanf("\n%d", &Q6);
      place(Q6, 6);
      table();
   }
   return(0);
}
int place(int ranking, int question){
   
   responses[ranking-1][question-1] += 1;
   return(0);
}
int table(){
   int i, j, t, count;
   int total[6], avg[6];
   printf("  %s     %s      %s   %s    %s  %s", topics[0], topics[1], topics[2], topics[3], topics[4], topics[5]);
   for(i = 0; i < 5; i++){
      printf("%d. ", i+1);
      for(j = 0; j < 6; j++){
         printf("%d             ", responses[i][j]);
      }
      printf("\n");
   }

   for(i = 0; i < 6; i++){
      for(j = 0; j < 5; j++){
         t += ((j + 1) * responses[j][i]);
         count += responses[j][i];
      }
      total[i] = t;
      avg[i] = t/count;
      t = 0;
      count = 0;
   }
   printf("   ");
   for(i = 0; i < 6; i++){
      printf("%d             ",avg[i]);
   }
   printf("\n");

   int high = total[0];
   int low = total[0];
   int index = 0;
   for(i = 1; i < 6; i++){
      if(high < total[i]){
         high = total[i];
         index = i;
      }
   }
   printf("\nHighest topic is: %s with %d points", topics[index], high);
   index = 0;
   for(i = 1; i < 6; i++){
      if(low > total[i]){
         low = total[i];
         index = i;
      }
   }
   printf("\nLowest topic is: %s with %d points", topics[index], low);
   return(0);
}
