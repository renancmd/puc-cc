my_array = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
target = 8
left, right = 0, len(my_array) - 1
counter = 0

while left <= right:
    mid = (left + right) // 2 # Using // return a integer number. / return a float number
    diff = target - my_array[mid]
    counter += 1

    if diff == 0:
        print(f"Target value found! target value: {my_array[mid]} rep: {counter}")
        left = len(my_array)
    elif diff > 0:
        left = mid + 1
    else:
        right = mid - 1
