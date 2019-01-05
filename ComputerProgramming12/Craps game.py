import random
##function to role the dice
def role():
    enter = input("Press enter to roll:")
    print("")
    die1 = random.randint(1,6)
    die2 = random.randint(1,6)
    dice = die1 + die2
    return dice
    y= y+1


##specificly for the come out rule at the beginning of the game
def comeOut():
    comeOutRole = role()
    print (comeOutRole)
    if comeOutRole == 2 or comeOutRole == 3 or comeOutRole == 12:
        print ("Sorry, you 'crapped out'")
        y = 0
        return y
        
    elif comeOutRole == 7 or comeOutRole == 11:
        print ("Congratulations, you win!")
        y = 0
        return y
                   
    elif comeOutRole == 4 or comeOutRole == 5 or comeOutRole == 6 or comeOutRole ==8 or comeOutRole == 9 or comeOutRole ==10:
        point = comeOutRole
        print ("You have a ", point, "point roll.")
        return point
    
##for comparing the point from the comeOut rule to see if the user won, lost or has to role again       
def point():
    x = 0
    while x == 0:
        newPoints =   role() 
        print(newPoints)
        if newPoints == play:
            print ("Congratulations you win!!!")
            x = 1
        elif newPoints == 7:
            print ("Sorry, you 'crap out'")
            x = 1
        else:
            print ("Please roll again")
        
    
## main program
            
y = 0   
while y == 0:           
    play = comeOut()
    if play == 0:
        y = y+1
    else:
        point()
        y = y+1
        

