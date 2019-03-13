
#!/usr/bin/env python3 # For use on ELW B238 machines # -*- coding: utf-8 -*-
# See https://www.python.org/dev/peps/pep-0263/ about encoding

#Encoding Funtions:
#   -reads a text file
#   -stores unique words in an array
#   -if a word is found that is in the unique words, remove and add a numerical value
#   -places the words and numbers into and mtf file

#Decoding Functions:
#   -reads a mtf file and stores the Ascii characters into a list
#   -go though each value and find if the values are numbers or characters
#   -if it is a character, check to see if it is followed by other characters to then make into a string
#   -if it is a number, check to see if it is beside a character or beside a number (holding the place of an word)


#Innovative features
#   -try except statements for files that won't open
#   -for decoding, stores characters in array until a word is completely made, then adds to a message array



import os
import sys
import fileinput

def removeElement(index, uniqueWords):
    """This function is used for the encoding_main function. It removes the
    non unique word from the list and adds it to the end of the list. removeElement._doc_"""

    uniqueWords.append(uniqueWords[index])
    uniqueWords.remove(uniqueWords[index])
    length = len(uniqueWords)
    return length-index

def encode_main():
    """This funtion is used to take a txt file and encode it to an mtf file.
    encode_main._doc_"""
    #create the mtf file from the text file
    mtfFile = sys.argv[1]
    mtfFile=mtfFile.split('.')
    mtfFile=str(mtfFile[0])+'.mtf'

    #set the magic numbers
    MAGIC_NUMBER = chr(0xba) + chr(0x5e) + chr(0xba) + chr(0x11)
    #try to open up the file
    try:
        outfile = open(mtfFile, encoding="latin-1", mode="w")
    except:
        print("not a valid file or can't open")
        return 1

    #writes the magic numbers in the mtf file
    for code in MAGIC_NUMBER:
        outfile.write(code)

    #open up the file to read
    fp = open(sys.argv[1], "r")
    number = 1
    uniqueWords = []
    #go line by line in the file
    for line in fp:
        #takes the txt file and reads the first line
        words = line.split()
        length = len(words)
        index = 0
        #runs until all of the words in the line are checked
        while length > 0:

            if words[index] in uniqueWords:
                indexOfDuplicate = uniqueWords.index(words[index])
                removeNumber = removeElement(indexOfDuplicate, uniqueWords)
                outfile.write(chr(removeNumber+128))

            else:
                #palces the number into the file
                outfile.write(chr(number+128))

                #add the word to the list of words
                word = words[index]
                #take the string and place it into the file char by char
                for letter in word:
                    # print(letter)

                    outfile.write(letter)
                #
                uniqueWords.append(words[index])
                number = number+1

            index = index+1
            length = length-1
        outfile.write('\n')


    outfile.close()
    fp.close()

#all functions below are used for the decode main

def getElement(number, message):
    """This function is used in the decode_main. It gets a string
    from to message array using the number in the mtf file and takes
    it from it's current postition in the message array and adds it to
    the end encode   getElement._doc_"""
    index = len(message) - number

    message.append(message[index])
    word=message.pop(index)
    return word

def addToString(char, charList, word, message):
    """This function takes an array of characters and makes it a string.
     Then, it adds it to the message array addToString._doc_"""
    charList.append(char)
    word = ''.join(charList)
    message.append(word)
    return word


def addToList(char, charList):
    """This function takes a character and adds it to a char list. Later,
    this list will be converted into a string later in the program to create
    a full word addToList._doc_"""
    charList.append(char)


def decode_main():
    """This function takes in an mtf file and decodes it to a text file
    decode_main._doc_"""
    #sets the text file to be a text file with the same name as the input file
    decodeFile = sys.argv[1]
    decodeFile=decodeFile.split('.')
    decodeFile=str(decodeFile[0])+'.txt'

    encodedFile = open(sys.argv[1], encoding="latin-1", mode="r")

    #go line by line in the mtf file
    firstLine = 1
    Arr= []
    inFile = encodedFile.read()

    count = 0


    vals = []
    for element in inFile:
        vals.append(ord(element))

    magic = [186,94,186,17]
    try:
        for index in range(0,3):
            if vals[index] != magic[index]:
                print("invalid file")
                return 1

    except:
        print("invalid file or can't open file")
        return 1


    output = open(decodeFile,"w+")
    message = []
    uniqueWords = []
    charList = []
    word = ""
    for i in range(4, len(vals)):

        if vals[i] == 10:
            output.write('\n')

#if statement for number
        elif vals[i] > 128:
        #if the number is next to another number
           if vals[i+1] > 128 or vals[i+1] == 10:
               element = getElement(vals[i] - 128, message)
               #if the next value is a new line character
               if vals[i+1] == 10:

                   output.write(element)

               else:
                   output.write(element + " ")

       #if the number is next to a character
        else:
            #if the next value is a number or new line character
            if vals[i+1] > 128 or vals[i+1] ==10:
                word = addToString(chr(vals[i]), charList, word, message)
                charList = []
                if vals[i+1] == 10:
                    output.write(word)
                else:
                    output.write(word + " ")
            #if the next number is a letter
            else:
                #add to the list of characters
                addToList(chr(vals[i]),charList)
    encodedFile.close()

#program begins here
command = os.path.basename(__file__)


if __name__ == "__main__" and command == "text2mtf.py":
    encode_main()
elif __name__ == "__main__" and command == "mtf2text.py":
    decode_main()
