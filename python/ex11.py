"""
generator functions
"""


def test():
    # print('yielding 123 to the caller')
    yield 123
    # print('yielding 222 to the caller')
    yield 222
    # print('yielding 400 to the caller')
    yield 400
    # print('yielding 500 to the caller')
    yield 500


def fibo(limit=10):
    a, b = -1, 1
    while limit > 0:
        limit -= 1
        c = a+b
        yield c
        a, b = b, c


if __name__ == '__main__':
    for f in fibo(15):
        print(f, end=', ')

    print()



    g = test()
    # print(g.__next__())
    # print(g.__next__())
    # for i in g:
    #     print(i)
