import sys
import json


def main():
    if len(sys.argv) == 1:
        filename = input('Enter CSV filename: ')
    else:
        filename = sys.argv[1]

    with open(filename, encoding='utf-8') as file:
        header_line = file.readline()
        headers = header_line.strip().split(',')
        data = []
        for value_line in file:
            values = value_line.strip().split(',')
            data.append(dict(zip(headers, values)))

    with open(filename[:-3] + "json", mode="w") as file:
        json.dump(data, file)

    print("CSV to JSON conversion successful!")


if __name__ == '__main__':
    main()
