"""
some basic useful maths utilities
"""
import math as m
PI = 3.14167


def square(num):
    """
    Returns the square of input number

    @param num - Input number
    @return - Square of input number
    """
    if type(num) not in (int, float):
        raise TypeError('Only int and float allowed')
    return num*num


def print_table(num, limit=10):
    if type(num) is not int:
        raise TypeError('parameter-1 must be an int')

    if type(limit) is not int:
        raise TypeError('parameter-2 must be an int')

    limit *= -1 if limit < 0 else 1

    i = 1
    while i <= limit:
        print(f'{num} x {i} = {num*i}')
        i += 1


if __name__ == '__main__':
    # n = 123
    # nn = square(n)
    # print(f'square of {n} is {nn}')
    # print_table(12)
    print_table(limit=15, num=22)
