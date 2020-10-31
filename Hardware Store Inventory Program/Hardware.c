/* 
 * Basic C program to print out hello world! 
 * Author: Jamar Golden
*/

#include <stdio.h>
#include <stdlib.h>
#include<string.h>

struct record
{
	int id;
	char name[20];
	int quanity;
	float cost;
};

struct record inventory[100];

int add();
int edit();
int delete();

int main(void) {
	FILE *f;
	int i, input;
	int bool = 1;
	char filename[15];
	printf("Please enter the File name you wish to edit: ");
	scanf("%s", filename);

	f = fopen( filename, "a+");

	fseek(f, 0, SEEK_END);

	if (ftell(f) != 0){
		fseek(f, 0, SEEK_SET);
		for(i = 0; i < 100; i++){
			fscanf(f, "%d %[^.]s %d %f", &(inventory[i].id), &(inventory[i].name), &(inventory[i].quanity), &(inventory[i].cost));
		}
	}
	fclose(f);
	while (bool == 1){
		printf("Add to inventory Press '1'\n");
		printf("Edit inventory Press '2'\n");
		printf("Delete a Record Press '3'\n");
		printf("Quit Press '4': ");
		scanf("%d", &input);

		if (input == 1){
			printf("Enter the Number of Records you would like to add: ");
                	scanf("%d", &input);
			for (i = 0; i < input; i++){
				add();
			}
		}
		else if(input == 2){
			edit();
		}
		else if(input == 3){
			delete();
		}
		else if(input == 4){
			f = fopen( filename, "w");
			for(i = 0; i < 100; i++){
                        	fprintf(f, "%d %s. %d %f\n", (inventory[i].id), (inventory[i].name), (inventory[i].quanity), (inventory[i].cost));
                	}
			fclose(f);
			bool = 0;
		}
	}	
	return(0); 
}

int add(){
	int i;
	for (i = 0; i < 100; i++){
		if (inventory[i].id == '\0'){
			break;
		}
	}
	if (i < 100){
		printf("Enter item ID: ");
		scanf("%d", &(inventory[i].id));
		printf("Enter item Name: ");
                scanf(" %[^\n]s", &(inventory[i].name));
		printf("Enter item Quanity: ");
                scanf("%d", &(inventory[i].quanity));
		printf("Enter item Cost: ");
                scanf("%f", &(inventory[i].cost));

		printf("Record Stored\n");
	}
	else{
		printf("No Open Spots");
	}
	return(0);
}

int edit(){
	int i, getid;
	printf("Enter the ID of the Item you would like to edit: ");
	scanf("%d", &getid);
        for (i = 0; i < 100; i++){
                if (inventory[i].id == getid){
                        break;
                }
        }
	if (i < 100){
                printf("Enter item ID: ");
                scanf("%d", &(inventory[i].id));
                printf("Enter item Name: ");
                scanf("%s", &(inventory[i].name));
                printf("Enter item Quanity: ");
                scanf("%d", &(inventory[i].quanity));
                printf("Enter item Cost: ");
                scanf("%f", &(inventory[i].cost));

                printf("Record Updated\n");
        }
        else{
                printf("ID Not Found");
        }

	return(0);
}

int delete(){
	int i, getid;
	printf("Enter the ID of the Item you would like to delete: ");
        scanf("%d", &getid);
	for (i = 0; i < 100; i++){
                if (inventory[i].id == getid){
                        break;
                }
        }
	if (i < 100){
                inventory[i].id = 0;

                inventory[i].name[0] = '\0';

                inventory[i].quanity = 0;

                inventory[i].cost = 0.0;

                printf("Record Deleted\n");
        }
        else{
                printf("ID Not Found");
        }
	return(0);
}