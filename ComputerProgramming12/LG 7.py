import datetime,time


#Counts up to 100 by how much the user inputs
def Exercise_1(count):
    print ("I'm going to count up to 100")
    number = int(input("How much do you want me to count up? "))
    while count <= 100:
        count += number
        if count<100:
            print (count)

#prints time now, time after count and elasped time
def Exercise_2():
    timeNow = datetime.datetime.now()
    Count()
    print()
    
   
    
    timeAfter = datetime.datetime.now()
    elapsedTime = timeAfter - timeNow
    print("Time started:   ",timeNow)
   
    print("Time completed: ",timeAfter)
    print("Elasped time:   ", elapsedTime)
    

#used in Exercise_2() to count up the first 200 fibonacci numbers


def Count():
     fibNumber,pastFibNumber = 1,1
     number = 0
     while number <= 200:
          fibNumber,pastFibNumber = pastFibNumber,fibNumber+pastFibNumber
          number = number+1
          print(fibNumber)
      

#aseked the user to give a number with decimal places
#then asked how many decimal places there should be
#prints the result
def Exercise_3():
    number = float(input("Give a number with a lot of decimal places: "))
    digit = int(input("How many decimal places do you want: "))
    roundedNumber = round(number, digit)
    print(roundedNumber)    


#Main program!!!
Exercise_1(0)
print()
#time between exercise
time.sleep(2)
Exercise_2()
#time between exercise
time.sleep(2)
print()
Exercise_3()

