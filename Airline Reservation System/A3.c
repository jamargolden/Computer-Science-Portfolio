/* 
 * Basic C program to print out hello world! 
 * Author: Jamar Golden
*/

#include <stdio.h>
#include <stdlib.h>
#include<string.h>

int seats[4][10] = {0};
char * names[4][10];

int firstClass();
int businessClass();
int economyClass();
int pList();
int pass();

int main(void) {
  int bool, input, i, j;
  bool  = 1;
  
  while(bool == 1){
    printf("-Welcome to Spirit Airlines-\n");
    printf("Please select a seat class\n");
    printf("For First Class Select '1'\n");
    printf("For Business Class Select '2'\n");
    printf("For Economy Class Select '3'\n");
    

    scanf("%d", &input);
    
    if(input == 1){
      firstClass();
      
    }
    else if(input == 2){
      businessClass();
    }
    else if(input == 3){
      economyClass();
    }
  }   
  return(0); 
}

int firstClass(){
  int i, j, boolean, letter, numInput;
  char letInput;
  char *name[12];
  char *name2[12];
  letter = 65;
  boolean = 1;

  for(i = 0; i < 2; i++){
    for(j = 0; j < 4; j++){
      if(seats[j][i] == 0){
        i == 2;
        boolean = 0;
        break;
      }
    }
  }  
  if(boolean == 1){
    printf("First Class is full... Would you like Business Classs?");
    printf("'y' for Yes 'n' for No");
    scanf("%c", &letInput);
    if(letInput == 'y'){
      businessClass();
    }
  }
  else{
    printf("Select a Seat between rows 1 - 2\n");
    printf("  0 1 2 3 4 5 6 7 8 9\n");
    for(i = 0; i < 4; i++){
      printf("%c ", letter);
      for(j = 0; j < 10; j++){
        printf("%d ", seats[i][j]);
      }
      printf("\n");
      letter++;
    }
    scanf("\n%c%d", &letInput, &numInput);
    
    if(letInput == 'A' && numInput >= 0 && numInput < 2){
      if(seats[0][numInput] == 0){
        printf("Great your confirmed seat is %c%d\n", letInput, numInput);
        seats[0][numInput] = 1;
        printf("Please enter the name of the passenger\n");
        scanf("%s", &name);
        names[0][numInput] = *name;;
        printf("Thank you for your business!\n");
        pList();
      }
      else{
        printf("That seat is not available choose another\n");
      }
    }
    else if(letInput == 'B' && numInput >= 0 && numInput < 2){
      if(seats[1][numInput] == 0){
        printf("Great your confirmed seat is %c%d\n", letInput, numInput);
        seats[1][numInput] = 1;
        printf("Please enter the name of the passenger\n");
        scanf("%s", &name);
        names[1][numInput] = *name;;
        printf("Thank you for your business!\n");
        pList();
      }
      else{
        printf("That seat is not available choose another\n");
      }
    }
    else if(letInput == 'C' && numInput >= 0 && numInput < 2){
      if(seats[2][numInput] == 0){
        printf("Great your confirmed seat is %c%d\n", letInput, numInput);
        seats[2][numInput] = 1;
        printf("Please enter the name of the passenger\n");
        scanf("%s", &name);
        names[2][numInput] = *name;;
        printf("Thank you for your business!\n");
        pList();

      }
      else{
        printf("That seat is not available choose another\n");
      }
    }
    else if(letInput == 'D' && numInput >= 0 && numInput < 2){
      if(seats[3][numInput] == 0){
        printf("Great your confirmed seat is %c%d\n", letInput, numInput);
        seats[3][numInput] = 1;
        printf("Please enter the name of the passenger\n");
        scanf("%s", &name);
        names[3][numInput] = *name;;
        printf("Thank you for your business!\n");
        pList();
      }
      else{
        printf("That seat is not available choose another\n");
      }
    }
    else{
      printf("This seat is not within the First Class range");
    }
  }

  return(0);
}

int businessClass(){
  int i, j, boolean, letter, numInput;
  char letInput;
  char *name[12];
  char *name2[12];
  letter = 65;
  boolean = 1;

  for(i = 2; i < 4; i++){
    for(j = 0; j < 4; j++){
      if(seats[j][i] == 0){
        i == 4;
        boolean = 0;
        break;
      }
    }
  }
  if(boolean == 1){
    printf("Business Class is full... Would you like Economy Classs?");
    printf("'y' for Yes 'n' for No");
    scanf("%c", &letInput);
    if(letInput == 'y'){

    }
  }
  else{
    printf("Select a Seat between rows 2 - 3\n");
    printf("  0 1 2 3 4 5 6 7 8 9\n");
    for(i = 0; i < 4; i++){
      printf("%c ", letter);
      for(j = 0; j < 10; j++){
        printf("%d ", seats[i][j]);
      }
      printf("\n");
      letter++;
    }
    scanf("\n%c%d", &letInput, &numInput);

    if(letInput == 'A' && numInput >= 2 && numInput < 4){
      if(seats[0][numInput] == 0){
        printf("Great your confirmed seat is %c%d\n", letInput, numInput);
        seats[0][numInput] = 1;
        printf("Please enter the name of the passenger\n");
        scanf("%s", &name);
        names[0][numInput] = *name;;
        printf("Thank you for your business!\n");
        pList();
      }
      else{
        printf("That seat is not available choose another\n");
      }
    }
    else if(letInput == 'B' && numInput >= 2 && numInput < 4){
      if(seats[1][numInput] == 0){
        printf("Great your confirmed seat is %c%d\n", letInput, numInput);
        seats[1][numInput] = 1;
        printf("Please enter the name of the passenger\n");
        scanf("%s", &name);
        names[1][numInput] = *name;;
        printf("Thank you for your business!\n");
        pList();
      }
      else{
        printf("That seat is not available choose another\n");
      }
    }
    else if(letInput == 'C' && numInput >= 2 && numInput < 4){
      if(seats[2][numInput] == 0){
        printf("Great your confirmed seat is %c%d\n", letInput, numInput);
        seats[2][numInput] = 1;
        printf("Please enter the name of the passenger\n");
        scanf("%s", &name);
        names[2][numInput] = *name;;
        printf("Thank you for your business!\n");
        pList();

      }
      else{
        printf("That seat is not available choose another\n");
      }
    }
    else if(letInput == 'D' && numInput >= 2 && numInput < 4){
      if(seats[3][numInput] == 0){
        printf("Great your confirmed seat is %c%d\n", letInput, numInput);
        seats[3][numInput] = 1;
        printf("Please enter the name of the passenger\n");
        scanf("%s", &name);
        names[3][numInput] = *name;;
        printf("Thank you for your business!\n");
        pList();
      }
      else{
        printf("That seat is not available choose another\n");
      }
    }
    else{
      printf("This seat is not within the First Class range");
    }
  }

  return(0);
}

int economyClass(){
  int i, j, boolean, letter, numInput;
  char letInput;
  char *name[12];
  char *name2[12];
  letter = 65;
  boolean = 1;

  for(i = 4; i < 10; i++){
    for(j = 0; j < 4; j++){
      if(seats[j][i] == 0){
        i == 10;
        boolean = 0;
        break;
      }
    }
  }
  if(boolean == 1){
    /*printf("Business Class is full... Would you like Economy Classs?");
    printf("'y' for Yes 'n' for No");
    scanf("%c", &letInput);
    if(letInput == 'y'){
   
    }*/
  }
  else{
    printf("Select a Seat between rows 4 - 9\n");
    printf("  0 1 2 3 4 5 6 7 8 9\n");
    for(i = 0; i < 4; i++){
      printf("%c ", letter);
      for(j = 0; j < 10; j++){
        printf("%d ", seats[i][j]);
      }
      printf("\n");
      letter++;
    }
    scanf("\n%c%d", &letInput, &numInput);

    if(letInput == 'A' && numInput >= 4 && numInput < 10){
      if(seats[0][numInput] == 0){
        printf("Great your confirmed seat is %c%d\n", letInput, numInput);
        seats[0][numInput] = 1;
        printf("Please enter the name of the passenger\n");
        scanf("%s", &name);
        names[0][numInput] = *name;;
        printf("Thank you for your business!\n");
        pList();
      }
      else{
        printf("That seat is not available choose another\n");
      }
    }
    else if(letInput == 'B' && numInput >= 4 && numInput < 10){
      if(seats[1][numInput] == 0){
        printf("Great your confirmed seat is %c%d\n", letInput, numInput);
        seats[1][numInput] = 1;
        printf("Please enter the name of the passenger\n");
        scanf("%s", &name);
        names[1][numInput] = *name;;
        printf("Thank you for your business!\n");
        pList();
      }
      else{
        printf("That seat is not available choose another\n");
      }
    }
    else if(letInput == 'C' && numInput >= 4 && numInput < 10){
      if(seats[2][numInput] == 0){
        printf("Great your confirmed seat is %c%d\n", letInput, numInput);
        seats[2][numInput] = 1;
        printf("Please enter the name of the passenger\n");
        scanf("%s", &name);
        names[2][numInput] = *name;;
        printf("Thank you for your business!\n");
        pList();

      }
      else{
        printf("That seat is not available choose another\n");
      }
    }
    else if(letInput == 'D' && numInput >= 4 && numInput < 10){
      if(seats[3][numInput] == 0){
        printf("Great your confirmed seat is %c%d\n", letInput, numInput);
        seats[3][numInput] = 1;
        printf("Please enter the name of the passenger\n");
        scanf("%s", &name);
        names[3][numInput] = *name;;
        printf("Thank you for your business!\n");
        pList();
      }
      else{
        printf("That seat is not available choose another\n");
      }
    }
    else{
      printf("This seat is not within the Economy Class range");
    }
  }

  return(0);
}

int pList(){
  int i, j, k, letter; 
  int m = 0; 
  int strlength = 0;
  char *name[12];
  letter = 65;
  for(i = 0; i < 4; i++){
    printf(" %c          ", letter);
    letter++;
  }
  printf("\n");
  for(i = 0; i < 10; i++){
    printf("%d", i);
    for(j = 0; j < 4; j++){
      *name = names[j][i];
      if(name[0] == '\0'){
        printf("            ");
      }
      else{
        printf("%s", name);
        while(name[m] != '\0'){
          strlength++;
          m++;
        }
        for(k = 0; k < (12 - strlength)+1; k++){
          printf(" ");
        }
        m = 0;
        strlength = 0;
      }
    }
    printf("\n");
  }
  pass();
  return(0);
}

int pass(){
  int i, j, m, bool;
  bool = 1;
  m = 0;
  char *name[12];
  char *search[12];
  printf("Enter a name to print Boarding Pass\n");
  scanf("%s", &search);
 
  for(i = 0; i < 4; i++){
    for(j = 0; j < 10; j++){
      *name = names[i][j];
      while(name[m] != '\0' && search[m] != '\0'){
        if(name[m] != search[m]){
          bool = 0;
          break;
        }
        m++;
      }
      m = 0;
      bool = 1;
    }
    if(bool == 1){
       printf("%s %d%d", search, i, j);
       break;
    }
  }
  return(0);
}
