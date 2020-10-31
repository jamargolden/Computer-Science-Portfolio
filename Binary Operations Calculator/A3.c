/*Filename: A3.c *
 *Part of: Assignment 3 *
 *Created by: Jamar Golden *
 *Created on: 10/2/2018 *
 *Last Modified by: Jamar Golden *
 *Last Modified on: 10/4/2018 *
 */

#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

//Sets the prototype functions that will be needed for the program
int leftBitShift();
int rightBitShift();
int And();
int Or();
int XOr();
int Comp();
int showBits();
//The main function that runs the showBits function also known as the menu function 
int main(void)
{
  showBits();
  return (0);
}
//The menu function that gives the user accwss to the different calculations that runs until the user quits
int showBits()
{
  //Declares and initializes the variables
  int bool, input;
  bool=1;
  //While loop that prints out the menu and takes user input until the user quits or bool no longer equals 1
  while(bool == 1)
    {
      printf("1. Perform Left Bit Shift Operation (one value)\n");
      printf("2. Perform Right Bit Shift Operation (one value)\n");
      printf("3. Perform Binary AND Operation (two values)\n");
      printf("4. Perform Binary OR Operation (two values)\n");
      printf("5. Perform Binary One's Complement (~) Operation (one value)\n");
      printf("6. Perform Binary XOR Operation (two values)\n");
      printf("7. Quit\n");
      scanf("%d",&input);
      //Checks the input and runs a specific function based on the input
      if(input == 1)
	leftBitShift();
      else if(input == 2)
	rightBitShift();
      else if(input == 3)
	And();
      else if(input == 4)
	Or();
      else if(input == 5)
	Comp();
      else if(input == 6)
	XOr();
      //Quits the program
      else if(input == 7)
	{;
	  bool = 0;
	}
    }
}
//Function that finds the compliment of the inputted number
int Comp()
{
  //Declares the variables
  int input;
  int binary[32];
  int temp, counter, i;
  unsigned int ans;
  //Runs a for loop that inputs zero into every spot within the binary array list
  for(i=0; i<32; i++)
    {
      binary[i]=0;
    }
  //Asks the user for a base 10 integer and asigns it to the input variable
  printf("Enter a base 10 Integer: ");
  scanf("%d",&input);
  //Initializes the variables
  temp = input;
  counter = 31;
  //find the binary output for the given input and inserts them into the binary array
  while (temp) {
    if (temp & 1)
      binary[counter] = 1;
    else
      binary[counter] = 0;
    counter--;
    temp >>= 1;
  }
  //Prints the entered number as a binary and in base 10
  printf("\n    Entered Integer: ");
  for(i=0; i<32; i++)
    {
      printf("%d",binary[i]);
    }
  printf(" (base 10 %d)",input);
  //Changes all values in the array, if 0 then it becomes a 1 and vise versa
  for (i=0; i<32; i++)
    {
      if (binary[i] == 1)
	binary[i]=0;
      else
	binary[i]=1;
    }
  //Prints the binary output and its base 10
  printf("\n    ~'ed           : ");
  for(i=0; i<32; i++)
    {
      printf("%d",binary[i]);
      }
  printf(" (base 10 %d)\n",~input);
  
}
//Finds the exclusive Or
int XOr()
{
  //Declares variables
  int input, input2;
  int binary[32];
  int temp, counter, i;
  unsigned int ans;
  //Inputs zero into every spot in the binary array
  for(i=0; i<32; i++)
    {
      binary[i]=0;
    }
  //Ask for the user to input two base 10 integers
  printf("Enter a base 10 Integer: ");
  scanf("%d",&input);
  printf("\nEnter a second base 10 Integer: ");
  scanf("%d",&input2);
  //Initializes variables
  temp = input;
  counter = 31;
  //Finds the binary number fot the input
  while (temp) {
    if (temp & 1)
      binary[counter] = 1;
    else
      binary[counter] = 0;
    counter--;
    temp >>= 1;
  }
  //Prints the first number as binary and base 10
  printf("\n    Entered Integer 1: ");
  for(i=0; i<32; i++)
    {
      printf("%d",binary[i]);
    }
  printf(" (base 10 %d)",input);
  //Initializes variables
  temp = input2;
  counter = 31;
  //resets the array to all zeros
  for(i=0; i<32; i++)
    {
      binary[i]=0;
    }
  //finds the second numbers binary
  while (temp) {
    if (temp & 1)
      binary[counter] = 1;
    else
      binary[counter] = 0;
    counter--;
    temp >>= 1;
  }
  //brints the second number as binary and base 10
  printf("\n    Entered Integer 2: ");
  for(i=0; i<32; i++)
    {
      printf("%d",binary[i]);
    }
  printf(" (base 10 %d)",input2);
  //Initializes variables again
  ans = input^input2;
  temp = ans;
  counter = 31;
  //resets the binary arrya again
  for(i=0; i<32; i++)
    {
      binary[i]=0;
    }
  //finds the binary of the ans variable
  while (temp) {
    if (temp & 1)
      binary[counter] = 1;
    else
      binary[counter] = 0;
    counter--;
    temp >>= 1;
  }
  //Prints the answer in binary and base 10
  printf("\n    XOR'ed           : ");
  for(i=0; i<32; i++)
    {
      printf("%d",binary[i]);
    }
  printf(" (base 10 %d)\n",ans);
}
//This function is the same as the XOr function the only differene is the bitwise operator
int Or()
{
  int input, input2;
  int binary[32];
  int temp, counter, i;
  unsigned int ans;

  for(i=0; i<32; i++)
    {
      binary[i]=0;
    }
  printf("Enter a base 10 Integer: ");
  scanf("%d",&input);
  printf("\nEnter a second base 10 Integer: ");
  scanf("%d",&input2);

  temp = input;
  counter = 31;

  while (temp) {
    if (temp & 1)
      binary[counter] = 1;
    else
      binary[counter] = 0;
    counter--;
    temp >>= 1;
  }
  printf("\n    Entered Integer 1: ");
  for(i=0; i<32; i++)
    {
      printf("%d",binary[i]);
    }
  printf(" (base 10 %d)",input);
  temp = input2;
  counter = 31;
  for(i=0; i<32; i++)
    {
      binary[i]=0;
    }
  while (temp) {
    if (temp & 1)
      binary[counter] = 1;
    else
      binary[counter] = 0;
    counter--;
    temp >>= 1;
  }
  printf("\n    Entered Integer 2: ");
  for(i=0; i<32; i++)
    {
      printf("%d",binary[i]);
    }
  printf(" (base 10 %d)",input2);
  ans = input|input2;
  temp = ans;
  counter = 31;

  for(i=0; i<32; i++)
    {
      binary[i]=0;
    }
  while (temp) {
    if (temp & 1)
      binary[counter] = 1;
    else
      binary[counter] = 0;
    counter--;
    temp >>= 1;
  }
  printf("\n    OR'ed            : ");
  for(i=0; i<32; i++)
    {
      printf("%d",binary[i]);
    }
  printf(" (base 10 %d)\n",ans);
}
//this is the same as the previous with a bitwise operation change
int And()
{
  int input, input2;
  int binary[32];
  int temp, counter, i;
  unsigned int ans;

  for(i=0; i<32; i++)
    {
      binary[i]=0;
    }
  printf("Enter a base 10 Integer: ");
  scanf("%d",&input);
  printf("\nEnter a second base 10 Integer: ");
  scanf("%d",&input2);

  temp = input;
  counter = 31;

  while (temp) {
    if (temp & 1)
      binary[counter] = 1;
    else
      binary[counter] = 0;
    counter--;
    temp >>= 1;
  }
  printf("\n    Entered Integer 1: ");
  for(i=0; i<32; i++)
    {
      printf("%d",binary[i]);
    }
  printf(" (base 10 %d)",input);
  
  temp = input2;
  counter = 31;
  for(i=0; i<32; i++)
    {
      binary[i]=0;
    }
  while (temp) {
    if (temp & 1)
      binary[counter] = 1;
    else
      binary[counter] = 0;
    counter--;
    temp >>= 1;
  }
  printf("\n    Entered Integer 2: ");
  for(i=0; i<32; i++)
    {
      printf("%d",binary[i]);
    }
  printf(" (base 10 %d)",input2);
  ans = input&input2;
  temp = ans;
  counter = 31;

  for(i=0; i<32; i++)
    {
      binary[i]=0;
    }
  while (temp) {
    if (temp & 1)
      binary[counter] = 1;
    else
      binary[counter] = 0;
    counter--;
    temp >>= 1;
  }
  printf("\n    AND'ed           : ");
  for(i=0; i<32; i++)
    {
      printf("%d",binary[i]);
    }
  printf(" (base 10 %d)\n",ans);

}
int rightBitShift()
{
  int input;
  int shift, binary[32];
  int temp, counter, i;
  unsigned int ans;

  for(i=0; i<32; i++)
    {
      binary[i]=0;
    }
  printf("Enter a base 10 Integer: ");
  scanf("%d",&input);
  printf("\nEnter number of places to shift bit: ");
  scanf("%d",&shift);

  ans = input << shift;
  temp = input;
  counter = 31;

  while (temp) {
    if (temp & 1)
      binary[counter] = 1;
    else
      binary[counter] = 0;
    counter--;
    temp >>= 1;
  }
  printf("\n    Entered Integer: ");
  for(i=0; i<32; i++)
    {
      printf("%d",binary[i]);
    }
  printf(" (base 10 %d)",input);
  //Shifts the binary number by the number inputed by the user to the right
  for(i=31; i>=0; i--)
    {
      if ((i+shift) <= 31)
        {
          binary[i+shift] = binary[i];
          binary[i] = 0;
        }
    }

  printf("\n    Right Shifted  : ");
  for(i=0; i<32; i++)
    {
      printf("%d",binary[i]);
    }
  printf(" (base 10 %d)\n",ans);
  return (0);

}
//This is the same as the right shift just shifted left
int leftBitShift()
{
  int input;
  int shift, binary[32];
  int temp, counter, i;
  unsigned int ans;

  for(i=0; i<32; i++)
    {
      binary[i]=0;
    }
  printf("Enter a base 10 Integer: ");
  scanf("%d",&input);
  printf("\nEnter number of places to shift bit: ");
  scanf("%d",&shift);

  ans = input << shift;
  temp = input;
  counter = 31;
  
  while (temp) {
    if (temp & 1)
      binary[counter] = 1;
    else
      binary[counter] = 0;
    counter--;
    temp >>= 1;
  }
  printf("\n    Entered Integer: ");
  for(i=0; i<32; i++)
    {
      printf("%d",binary[i]);
    }
  printf(" (base 10 %d)",input);

  for(i=0; i<31; i++)
    {
      if ((i-shift) >= 0)
	{
	  binary[i-shift] = binary[i];
	  binary[i] = 0;
	}
    }

  printf("\n    Left Shifted   : ");
  for(i=0; i<32; i++)
    {
      printf("%d",binary[i]);
    }
  printf(" (base 10 %d)\n",ans);
  return (0);
}
