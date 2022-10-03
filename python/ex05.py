"""
Introduction to functions

A function is a reusable piece of code block. The "def" keyword is used for creating a function. Once a function is created, we have to invoke or call the same.
"""


def main():
    """
    This function accepts a number and checks if it is even or odd!
    """
    num = int(input('Enter a number: '))
    if num % 2 == 0:
        print(f"{num} is an even number!")
    else:
        print(f"{num} is an odd number")


if __name__ == '__main__':
    main()
