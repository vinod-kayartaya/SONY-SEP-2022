import sys


def main():
    try:
        arg1 = sys.argv[1]
        arg2 = sys.argv[2]
    except IndexError:
        print('Not enough values; expected 2 inputs')
        return

    try:
        n = int(arg1)
        d = int(arg2)
    except ValueError:
        print('Expected 2 numbers; at least one of them is not.')
        return

    try:
        q = n//d
        r = n % d
    except ZeroDivisionError:
        print('Cannot divide by zero')
        return

    print(f'{n}/{d} results in quotient of {q} and reminder of {r}')


if __name__ == '__main__':
    main()
