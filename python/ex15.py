import sys


def main():
    try:
        arg1 = sys.argv[1]
        arg2 = sys.argv[2]
        n = int(arg1)
        d = int(arg2)
        q = n//d
        r = n % d
        print(f'{n}/{d} results in quotient of {q} and reminder of {r}')
    except IndexError:
        print('Not enough values; expected 2 inputs')
    except ValueError:
        print('Expected 2 numbers; at least one of them is not.')
    except ZeroDivisionError:
        print('Cannot divide by zero')
    except Exception as e:
        print(f'There was an exception - {e}')


if __name__ == '__main__':
    main()
