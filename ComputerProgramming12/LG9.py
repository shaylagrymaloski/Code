import random
##Lets the user guess a name
def exercise_1():
    x = 0
    while x<3:
        name = input("What is my name? ")
        name = name.upper()
        if name == "SHAYLA":
           print ("you guessed it right!")
           x = 3
        elif x ==2:
            print ("Sorry you had too many guesses. The correct answer was Shayla")
            x = x+1
        else:
            print ("Sorry try again. ")
            x = x +1
##guessing game with two users
def exercise_2():

    z = 0
    while z == 0:
        print("Please enter a number between 0 and 1001 for someone else to guess.")
        number = int (input("Make sure they aren't looking at the screen as you type your answer!" ))
        if number > 1001:
            print ("Sorry that number was too high, please try again")
            print("")
        elif number < 0:
            print ("Sorry that number was too low, please try again")
            print("")
        else:
            z = 1
    x = 0
## this will write a series of black spaces to make the number entered disappear from the screen
    for x in range(40):
        print ("")
    print ("User 1 entered a number between 0 and 1001.")
    y = 0
    while y ==0:
        
        guess = int(input("What number do you think was entered? "))
        if guess > number:
            print ("Sorry that was too high. Try again")
            print("")
        elif guess < number:
            print ("Sorry that was too low. Try again")
            print("")
        elif guess == number:
            print ("You guessed it right!")
            print("")
            y = 1
        else:
            print ("Sorry, that was not a valid answer")
            print("")
##lets the user guess a randon number between 0 and 1000
def exercise_3():
    number = random.randint(0,1000)
    guess = 0
#Keeps track of the number of times guessed
    guesses = 0
    print ("Guess the number!")
    while guess != number:
        guess = int(input("Is it... "))
        guesses = guesses + 1
        if guesses == 3:
            print("That must have been complicated.")
        if guess == number:
            if guesses < 3:
                print("Good Job!")
            print("Hooray! You guessed it right!")
        elif guess < number:
            print("It's bigger...")
        elif guess > number:
            print("It's not that big.")
            
        
##main program       
exercise_1()
exercise_2()
exercise_3()
