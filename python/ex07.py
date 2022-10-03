def test():
    return 10, 20


a, b = test()  # unzips the tuple and assigns to a and b respectively
n = test()  # tuple

print(f'a is {a} and b is {b}')
print(f'n is {n} and type(n) is {type(n)}')
