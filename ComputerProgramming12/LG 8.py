#runs a test of knowledge

#This will test a single quesiton
#it takes a single question in
#it returns True if the user typed the correct answer, otherwise it returns false

def check_question(question_and_answer):
    #extract the question and the answer from the list
    #this function takes a list with two elements, a question and an answer
    print("")
    question = question_and_answer[0]
    answer = question_and_answer[1]
    #give the question to the user
    given_answer = input(question)
    #compare the user's anser to the tester's answer
    if answer == given_answer:
        print("Correct")
        return True
    else:
        print("Incorrect, correct was:", answer)
        return False

def run_test(question):
    if len(question) == 0:
        print("No questions were given.")
        Return
    index = 0
    right = 0
    while index < len(question):
        #Check the question
        #Note that this is extraction a question and answer list from the list of lists
        if check_question(question[index]):
            right = right + 1
            #go to next question
            index = index +1
            print("You got ", right * 100/len(question),"% right out of ",len(question))

menu_item = 0

get_questions = [["What colour is the grinch? ", "green"],
           ["What is the name of the most famous reindeer of all? ", "Rodolph"],["What is the most famous Christmas Ballet? ",
            "The Nutcracker"],["What kind of Christmas is Bing Crosby dreaming of? ","White"],["All I want for Christmas is my...? ","two front teeth"]]

print("")
z = 0
while z == 0:
    x =0
## askes use if they would like to take the test by either answering yes or no
## the program will repeat if there is not a valid answer
    while x ==0:
        test = input("Would you like to take this test? ")
        if test == "yes":
            print("")
            x=1
            run_test(get_questions)
        elif test == "no":
            print ("okay")
            x=1
        else:
            print("not a valid answer")
## askes user if they would like to see the list of questions
## repeats if there is not a valid answer
    y = 0    
    while y == 0:
        test2 = input ("Would you like to see the list of questions with the answers? ")
        if test2 == "yes":
            print ("")
            if menu_item <= 1:
                y = 1
                current = 0
                if len(get_questions)>0:
            
                    while current <len(get_questions):
                        print(current+1, ".", get_questions[current])
                        current= current +1
                
                else:
                    print ("List is empty")
                    y = 1

        elif test2 =="no":
            print("okay")
            y = 1
        else:
            print ("not a valid answer")
## asks the user if they would like to quit
## if there isn't a valid answer, the question will repeat
    c = 0
    while c == 0:
        test3 = input ("Would you like to quit? (if no, the program will repeat) ")
        if test3 == "yes":
            c= 1
            z=1
        elif test3 == "no":
            print ("okay I'll run the program again")
            print ("")
            c = 1
        else:
            print ("not a valid answer")
           
    
  
        
                      




