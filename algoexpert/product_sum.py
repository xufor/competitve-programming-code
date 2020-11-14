array = [5, 2, [7, -1], 3, [6, [-13, 8], 4]]


def calculate(arr, mul):
    t_sum = 0
    for x in arr:
        if isinstance(x, list):
            t_sum += calculate(x, mul + 1)
        else:
            t_sum += x
    return t_sum * mul


print(calculate(array, 1))
