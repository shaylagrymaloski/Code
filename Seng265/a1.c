/*
Shayla Grymaloski 
V00884262
SENG 265
University of Victoria

Program to read a txt file and compress it into an mtf encoded file

*/

#include <string.h>
#include <stdlib.h>
#include <stdio.h>
#include <ctype.h>
#define MAX_UNIQUE 120
#define MAX_WORDS 20
#define MAX_LINE_LEN 80
#define MAX_LINES 100

//keeps track of the current index
int currIndex = 0;
//keeps track of the number of words
int numWords =0;
int numLines =0;
//keeps track of the length of token pointer array
int arrLength = 0;
//array of token pointers
char *tokenArray[MAX_UNIQUE];


int removeFromArray(int index, int lastIndexInputted, int wordSize){

		int count = 0;
		int i = 0;
		int j= 1;
		int lenFromIndex = index;
		//holds the value of the index that we want to remove
		char *temp = tokenArray[index];

		//goes through the array and removes the index of the word that we want to remove
		while(lastIndexInputted > index+1){
			//shifting array to the left
			tokenArray[index+i] = tokenArray[index+j];
			//subtracts one to remove the last element from the array
			lastIndexInputted --;
			i++;
			j++;
			count++;

		}
		
		count = count + lenFromIndex;
		//sets the last value of the array to what index was removed
		tokenArray[count] = temp;

		//sets the value of the number to be printed when removing an index
		currIndex = arrLength-index;
			
		
		return count;
	}


//compares two words in the array of characters to find if a word is not unique
int compareWords( char *token,int lastIndexInputed, int wordSize){

		int indexOfArr = 0;
		int value = 1;
		//index where the compare is happenning
		int j = lastIndexInputed;
		//searches through the array to see if the current word is unique or not
		while(j > 0){
			
			if(strcmp(tokenArray[indexOfArr], token)==0){
			//runs if found a match
				
				removeFromArray(indexOfArr,lastIndexInputed,wordSize);
				indexOfArr--;
				value = 0;
			}

			j--;
			indexOfArr++;
		}
		return value;


	}

int main(int arc, char *argv[]){
	
	FILE *inputText;
	FILE *outputText;

	//code to take the name of the input file and change to mtf file
	int len = strlen(argv[1]);
	char newFile[80];
	strncpy(newFile, argv[1],len-4);
	strncat(newFile, ".mtf",5); 
	
	//openning the files
	inputText = fopen(argv[1], "r");

	//runs if no file inputted
	if(argv[1] == NULL){
		printf("invalide entry please enter a file name to compare\n");
		return 1;
	}

	//creates the new mtf file
	outputText = fopen(newFile, "w");

	
	
	//magic numbers
	fputc(186, outputText);
	fputc(94, outputText);
	fputc(186, outputText);
	fputc(17, outputText);


	
	const char s[4] = " \n";
   	char *token;
   	char arr[MAX_LINE_LEN][MAX_LINES];
    	
	

	//close the input file
	//goes through the file line by line
	int i = 1;
    	int index = 0;
	int count = 0;
	int wordListSize = 0;

	//runs through the file line by line
	while(fgets(arr[count],MAX_LINE_LEN,inputText)){
		
		//creates a temparay char array
		char temp[MAX_LINE_LEN][MAX_LINES];
		
		//creates a token
		strncpy(temp[count], arr[count], MAX_LINE_LEN);
    		token = strtok(temp[count], s);
    		
		//walks through tokens in file
		while(token != NULL){
			
			//run if it is the first word in the file
			if(index ==0){
				
				arrLength++;
				tokenArray[index] = token;
				
				//adds number and token to the file
				fputc(arrLength+128, outputText);
				fputs(token, outputText);
			
			}else{
				
			//runs for everyword that isn't the first word
				
				int compare = compareWords(token, index, wordListSize);
		
				//runs if the compared words are different
				if(compare == 1){
					arrLength++;
					wordListSize ++;
					
					tokenArray[index] = token; 

					//adds number and token to the file
					fputc(arrLength+128, outputText);
					fputs(token, outputText);
					

				}else{
				//runs if it has found a matching word pair 
				
					index = index - 1;
					//puts index where the duplicate number was stored and puts in array
					fputc(currIndex+128, outputText);
				
				}
				
			}
			
			
			//stores the next token from file
	    		token = strtok(NULL, s);
	    		//adds to increament through the array
	    		i++;
			index ++;
			
		}
		//adds a new line to the file
		fputc('\n',outputText);
		//adds to count to increament through the lines
		count++;
	}

	
	//closes both of the files
	fclose(inputText);
	fclose(outputText);

	return 0;

}
