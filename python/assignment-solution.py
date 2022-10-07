from customer_module import list_customers, delete_customer, search_customer_by_city


def menu():
    print("""*** Main Menu ***
    1. Add new customer
    2. View all customers
    3. Search customers by city
    4. Delete a customer (by id)
    5. Search customer by id and edit/update details
    6. Exit

    """)
    try:
        choice = int(input('Enter your choice: '))
        return choice
    except ValueError:
        print('Invalid value for the choice. Please try again')
        return -1


def main():
    while True:
        choice = menu()

        if choice == 1:
            print('Add new customer')
        elif choice == 2:
            list_customers()
        elif choice == 3:
            search_customer_by_city()
        elif choice == 4:
            delete_customer()
        elif choice == 5:
            print('Search customer by id and edit/update details')
        elif choice == 6:
            print('Thank you and have a nice day!')
            break
        else:
            print('Please enter a number between 1 and 6.')


if __name__ == '__main__':
    main()
