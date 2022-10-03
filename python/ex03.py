"""
Accept a number and print the square of the same

The "input" builtin method can be used for accepting a user input. This method takes a str as a parameter (used as a prompt), and will return the user input in the form of another str.
"""

num = input("Enter a number: ") # num is a str 
num = float(num) # num is a float
print(f'square of {num} is {num*num}')
