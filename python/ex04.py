"""
Example to understand the name of the module

You can access the name of the module using the builtin variable called "__name__".

When this module is directly run (or executed), the name of the module is not "ex04" but "__main__". However, when imported, the name of the module is "ex04".
"""

print(f'The name of this module is {__name__}')

if __name__ == '__main__':
    print('this is printed only if this file is run directly using python3 CLI')
else:
    print('This is printed while this module is imported')
