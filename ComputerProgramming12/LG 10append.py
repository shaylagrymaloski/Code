import os 
max_points = [25,25,50,25,100]
assignments = ["hw ch1", "hw ch2", "quiz", "hw ch3", "test"]
students = {"#Max": max_points}

if os.path.isfile('grades.txt') is True:
        print()

else:
        with open("grades.txt", "wt") as out_file:
                out_file.write
 

def export(x):
        with open("grades.txt", "a") as myfile:
            myfile.write(x)
        

def remove(x):
        with open ("grades.txt", "rt") as f:
                text = f.read()

                print (text)
        if x in text:
                start_index = text.index(x)
                end_index = start_index + len(x)

                new = text[:start_index] + text[end_index:]
                text = new
                
        else:
                print("name not in the file")
        print (text)
def print_menu():
        print("1. Add student\n2. Remove stuedent\n3. Print grades\n4. Records grades\n5. Print Menu")

def print_all_grades():
    print("\t", end ="")
    for i in range(len(assignments)):
        print(assignments[i],"\t", end = "")
    print()
    keys = list(students.keys())
    keys.sort()
    for x in keys:
        print(x,"\t",end="")
        grades = students[x]
        print_grades(grades)

def print_grades(grades):
    for i in range(len(grades)):
        print(grades[i],"\t", end= "")
    print()



print_menu()
x= 0
while x == 0:
    menu_choice = input("Select number on menu to resieve data:  ")
    print("")
    menu_choice.strip()

        ##adds student to the program
    if menu_choice == "1":
        name = input("Student to add: ")
        students[name] = [0]*len(max_points)
        export(name)
        print (name, " has been added")
        ## removes student from the program
    elif menu_choice=="2":
        name = input("Student to remove: ")
        remove(name)
        
    elif menu_choice == "3":
        print_all_grades()
    elif menu_choice == "4":
        print("Record Grade")
        name = input("Student:")

        with open ("grades.txt", "rt") as f:
                text = f.read()
                

        
        if name in text:
            grades = {name: max_points}

            print("Type in the number of the grade to record")
            print("Type a 0 (zero) to exit")
            for i in range (len(assignments)):
                print(i + 1, assignments[i], "\t", end = "")
                with open ("grades.txt","a") as f:
                    y = str(x)
                    f.write(y)
            print()
      
            which = 1234
            while which != -1:
                which = int(input("Change which Grade (in order from 1 - 5: "))
                which-= 1   #same as which = which - 1
                if 0 <= which < len(grades):
                    grade = int(input("Grade: "))
                    grades[which] = grade
                elif which != -1:
                    print("invalid Grade Number")
        else:
            print("Student not found")
    elif menu_choice == "5":
            print_menu()
    elif menu_choice != "1" or "2" or "3" or "4" or "5":
            print("Not a valid menu option")
                


