
#Encoding Funtions:
#   -reads a text file
#   -stores unique words in an array
#   -if a word is found that is in the unique words, remove and add a numerical value
#   -places the words and numbers into and mtf file
#   -this function only is able to encode more than 120 unique words

#Decoding Functions:
#   -reads a mtf file and stores the Ascii characters into a list
#   -go though each value and find if the values are numbers or characters
#   -if it is a character, check to see if it is followed by other characters to then make into a string
#   -if it is a number, check to see if it is beside a character or beside a number (holding the place of an word)
#   -can decode up to 60000 unique words

#Innovative features
#   -try except statements for files that won't open
#   -for decoding, stores characters in array until a word is completely made, then adds to a message array
#   -encoding has a class to encode one line at a time
#   - decoding has a class to deal with decoding an array of values
import os
import sys


class Line:
    """This class will encode one line of a txt function """
    uniqueWords = []
    number = 1
    def __init__(self, line, fp):
        self.fp = fp
        self.line = line

#runs until all of the words in the line are checked

    def doEncoding(self):
        """This function will incode the txt file to an mtf file"""
        index = 0

        words = self.line.split()
        lenWords = len(words)

        for lenWords in range(0,lenWords):

            #if the word is in the unique words array
            if words[index] in self.__class__.uniqueWords:
                indexOfDuplicate = self.__class__.uniqueWords.index(words[index])
                removeNumber = self.removeElement(indexOfDuplicate)
        #        self.fp.write(chr(removeNumber+128))
                self.printSpecialIndex(removeNumber)

            else:
        #palces the number into the file
                self.printSpecialIndex(self.__class__.number)
                #self.fp.write(chr(self.__class__.number+128))
        #add the word to the list of words
                word = words[index]
        #take the string and place it into the file char by char
                for letter in word:
            # print(letter)
                    self.fp.write(letter)


                self.__class__.uniqueWords.append(words[index])
                self.__class__.number = self.__class__.number+1
            index = index + 1

    def printSpecialIndex(self, number):
        """this function prints the index is the number before a word or a place
         holder for a word """
        #case 1
        if(number < 121):
            self.fp.write(chr(number+128))
        #case 2
        if(number < 376 and number > 120):
            self.fp.write(chr(121+128))
            self.fp.write(chr(number-121))
        #case 3
        if(number > 375 and number < 65913):
            self.fp.write(chr(122+128))
            self.fp.write(chr((number-376)//256))
            self.fp.write(chr((number-376)%256))



    def removeElement(self,index):
        """This function is used for the encoding_main function. It removes the
        non unique word from the list and adds it to the end of the list. removeElement._doc_"""
        self.__class__.uniqueWords.append(self.__class__.uniqueWords[index])
        self.__class__.uniqueWords.remove(self.__class__.uniqueWords[index])

        length = len(self.__class__.uniqueWords)

        return length-index


class Cases:
    """This class is used to decode a word based on the number inputted in the file before the word"""
    def __init__(self, vals, output):
        """This function goes through the elements of the array vals with hold all the values of
        the mtf file and will decode these values based on the case"""

        self.vals = vals
        self.output = output
        message = []
        uniqueWords = []
        charList = []
        word = ""

        #flags used while going through the for loop
        flagCharacter = 0
        numberFlag = 0
        checkToSkip = 0

        #increaments through the vals array starting from the end of the magic numbers
        for i in range(4, len(self.vals)):

            #checks to see if the current value needs to be skipped
            #Only used for case 2 and 3
            if checkToSkip != 0:
                checkToSkip = checkToSkip - 1
                continue

            #new line character
            if self.vals[i] == 10:
                self.output.write('\n')
                continue

            #checks to see if the current value is going to switch the case being used
            if self.vals[i] == 121+128:
                caseNum = 2
                checkToSkip = 1
                numberFlag = 1
            elif self.vals[i] == 122+128:
                caseNum = 3
                numberFlag = 1
                checkToSkip = 2
            elif self.vals[i] > 128:
                caseNum = 1
                numberFlag = 1


            #if the code is a character
            if flagCharacter == 1:
                #if the next value is a number or next line character
                #meaning that the word is done
                if self.vals[i+1] > 128 or self.vals[i+1] == 10:
                    word = self.addToString(chr(vals[i]), charList, word, message)
                    if self.vals[i+1] == 10:
                        self.output.write(word)
                    else:
                        self.output.write(word + " ")
                    flagCharacter = 0
                    charList = []
                #if the next number is a letter
                else:
                    #add to the list of characters
                    self.addToList(chr(vals[i]),charList)
                continue

            #if the current element in vals is the "case number" value
            if numberFlag != 1:
                continue

            #if the element in vals is next to a number
            if self.vals[i+caseNum] > 128 or self.vals[i+caseNum] == 10:

                if caseNum == 1:
                    element = self.getElement(self.vals[i] - 128, message)

                if caseNum == 2:
                    element = self.getElement(self.vals[i+1] + 121, message)

                if caseNum == 3:
                    value = self.vals[i+1]*256 + 376
                    value = value + self.vals[i+2]
                    element = self.getElement(value, message)

                #if the next value is a new line character
                if self.vals[i+caseNum] == 10:
                    self.output.write(element)
                else:
                    self.output.write(element + " ")

            #if the number is next to a character
            else:
                #if the next value is a number or new line character
                flagCharacter = 1
            numberFlag = 0



    def addToList(self, char, charList):
        """This function takes a character and adds it to a char list. Later,
        this list will be converted into a string later in the program to create
        a full word """

        charList.append(char)


    def addToString(self, char, charList, word, message):
        """This function takes an array of characters and makes it a string.
         Then, it adds it to the message array """
        charList.append(char)
        word = ''.join(charList)
        message.append(word)
        return word
    def getElement(self, number, message):
        """This function is used in the decode_main. It gets a string
        from to message array using the number in the mtf file and takes
        it from it's current postition in the message array and adds it to
        the end encode  """
        index = len(message) - number

        message.append(message[index])
        word=message.pop(index)
        return word


MAGIC_NUMBER_1 = chr(0xBA) + chr(0x5E) + chr(0xBA) + chr(0x11)
MAGIC_NUMBER_2 = chr(0xBA) + chr(0x5E) + chr(0xBA) + chr(0x12)

def encode(input_name):
    (base_name, _, _) = input_name.rpartition(".")
    output_name = base_name + "." + "mtf"

    try:
        outfile = open(output_name, encoding="latin-1", mode="w")
    except:
        print("not a valid file or can't open")
        return 1


    #writes the magic numbers in the mtf file
    for code in MAGIC_NUMBER_2:
        outfile.write(code)

    #open up the file to read
    fp = open(input_name, "r")

    #go line by line in the file
    for line in fp:
        #takes the txt file and reads the first line
        lineClass = Line(line, outfile)
        lineClass.doEncoding()

        outfile.write('\n')

    outfile.close()
    fp.close()



def decode(input_name):

    (base_name, _, _) = input_name.rpartition(".")
    output_name = base_name + "." + "txt"

    #opens the mtf file to read
    try:
        encodedFile = open(input_name, encoding="latin-1", mode="r",newline="")
    except:
        print("no such file exists")

    inFile = encodedFile.read()
    output = open(output_name,"w+")
    #takes the mtf file and places all of the values into one array
    vals = []
    for element in inFile:
        vals.append(ord(element))

    #checks to see if it is a valid mtf file
    magic = [186, 94,186,17]
    magic2 = [186, 94,186,18]
    for i in range(0,4):
        if(vals[i] == magic[i] or vals[i] == magic2[i] ):
            continue
        else:
            print("not a valid mtf file")
            return 1
    #run the Cases class
    decodeWithCase = Cases(vals, output)
    output.close()
    encodedFile.close()
