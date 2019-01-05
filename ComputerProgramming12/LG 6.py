import random

#Enters user name
#If the name is Shayla print "That's not your name"
#If the name is "John Cleese or "Michael Palin" print abou thier name
#Otherwise say they have a nice name
def Exercise_1():
    name = input("Please enter your name here: ")

    if name == "Shayla Gryaloski":
        print ("That's not your name")

    elif name == "John Cleese" or "Michael Palin":
        print ("You have a nice name")
    else:
        print ("You have a nice name")


#Plays the guessing game highter or lower with a random number
#if there is less than three guesses the computer will print "Good Job!"
def Exercise_2():
    number = random.randint(0,20)
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

            
#Asks for two numbers
#adds them up and if the sum is greater than 100 print "They add up to a big number"
def Exercise_3():
    firstNumber = int(input("enter a number"))
    secondNumber = int(input("enter a second number"))
    if firstNumber + secondNumber > 100:
        print ("They add up to a big number")



Exercise_1()
Exercise_2()
Exercise_3()
