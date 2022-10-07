class Employee:

    def __init__(self, **kwargs):
        self.__id = kwargs.get('id')
        self.__name = kwargs.get('name')
        self.__salary = kwargs.get('salary', 15000)

    def __str__(self):
        return f"Employee (Id={self.__id}, Name={self.__name}, Salary={self.__salary})"

    def display(self):
        print(f"""
        ID     : {self.__id}
        Name   : {self.__name}
        Salary : {self.__salary}""")


def main():
    e1 = Employee(id=1122, name='Kishore', salary=25000)
    e2 = Employee(id=1999, name='Kiran')
    e3 = Employee(name='Ramesh')
    e4 = Employee()

    print(e1)
    print(e2)
    print(e3)
    print(e4)

    e1.display()
    e2.display()
    e3.display()
    e4.display()


if __name__ == '__main__':
    main()
