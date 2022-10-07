"""
This script shows various methods to read a file
"""

import sys

filename = 'ex01.py'


def read_file_1():
    f = open(filename)
    # read the entire content at once
    content = f.read()
    f.close()
    print(content)


def read_file_2():
    with open(filename) as f:
        while True:
            # read one line at a time
            line = f.readline()
            if line == '':
                break
            print(line, end='')


# python3 ex10.py /Users/vinod/ASSIGNMENT_SOLUTION.sql
def read_file_3():
    file_to_open = filename if len(sys.argv) == 1 else sys.argv[1]
    with open(file_to_open) as f:
        # read all lines as a list of str
        lines = f.readlines()
        for line in lines:
            print(line, end='')


def read_file_4():
    file_to_open = filename if len(sys.argv) == 1 else sys.argv[1]
    with open(file_to_open) as f:
        for line in f:  # treating "f" itself as iterable
            print(line, end='')


if __name__ == '__main__':
    read_file_4()
