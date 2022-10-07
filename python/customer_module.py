__customers = dict()
header_format = '%3s %-15s %-15s %-30s %-11s %-7s %-15s'

with open('customers.csv', encoding='utf-8') as file:
    # skip the header
    file.readline()

    for line in file:
        ar = line.strip().split(',')
        __customers[ar[0]] = ar


def list_customers(customers=None):
    print(header_format %
          ("Id", "Firstname", "Lastname", "Email", "Phone", "Gender", "City"))
    print(102*'=')
    i = 0
    for c in (__customers.values() if customers is None else customers):
        print(header_format % tuple(c))
        i += 1

        if i == 10:
            i = 0
            ans = input('Do you want to view more customers? yes/no (yes) ')
            if ans.lower() == 'no':
                break
            print(header_format %
                  ("Id", "Firstname", "Lastname", "Email", "Phone", "Gender", "City"))
            print(102*'=')


def delete_customer():
    customer_id = input('Enter id of the customer to be deleted: ')
    if customer_id in __customers:
        c1 = __customers[customer_id]
        del __customers[customer_id]
        write_customers_to_file()
        print('This customer data is deleted from our database: ')
        print_customer(c1)

    else:
        print("Sorry, the id you entered did not match id of any of our customers.")


def print_customer(c):
    print(f"""
    ID           : {c[0]}
    Name         : {'Mr.' if c[5]=='Male' else 'Ms.'}{c[1]} {c[2]}
    Email id     : {c[3]}
    Phone number : {c[4]}
    City         : {c[6]}
    
    """)


def write_customers_to_file():
    with open('customers.csv', 'w') as file:
        file.write('id,firstname,lastname,email,phone,gender,city\n')
        for c in __customers.values():
            file.write(','.join(c))
            file.write('\n')


def search_customer_by_city():
    city = input('Enter city: ')
    result = [c for c in __customers.values() if c[6] == city]

    if len(result) == 0:
        print(f'Sorry. No customers found in city {city}')
    elif len(result) == 1:
        print_customer(result[0])
    else:
        list_customers(result)
