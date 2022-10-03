"""
Python "for" loop demo

In this script program, we want to accept a number from the user, and print the multiplication table for the same.
A 'for' loop is preferred when the number of iterations is known in advance.
"""


def print_table(num, limit=10):
    if type(num) != int:
        raise TypeError('Only int is allowed for num')
    if type(limit) != int:
        raise TypeError('Only int is allowed for limit')

    if limit < 1:
        raise ValueError('Limit must be >=1')

    for i in range(1, limit+1):
        print(f'{num} x {i} = {num*i}')


if __name__ == '__main__':
    a = int(input('Enter a value for num: '))
    b = int(input('Enter a value for limit: '))
    print_table(a, b)
