# import maths
# from maths import square
# from maths import square as sq
import maths as m

if __name__ == '__main__':
    n = 22
    # nn = maths.square(n)
    # nn = square(n)
    # nn = sq(n)
    nn = m.square(n)
    print(f'Square of {n} is {nn}')
