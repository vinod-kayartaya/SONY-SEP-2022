"""
Python 'for' loop with lists

A list or any iterable can be iterated over using a 'for' loop.
"""

nums = list()  # or nums = []

# when the number of times the loop must go is not known (or fixed), use the while loop
while True:
    # this is an endless (or infinite) loop; must break the loop based on some condition
    num = int(input('Enter a number (0 to stop): '))
    if num == 0:
        break

    nums.append(num)

# with lists (and any other iterables), always use the for loop
for n in nums:
    print(f'{n} is {"even" if n%2 == 0 else "odd"}')
