def stockSpan(price_list):
    stack, result = [], []
    for current_index in range(len(price_list)):
        while stack and stack[-1][0] < price_list[current_index]:
            stack.pop()
        if stack:
            result.append(current_index - stack[-1][1])
        else:
            result.append(current_index+1)
        stack.append([price_list[current_index], current_index])
    return result

print(stockSpan([60, 70, 80, 100, 90, 75, 80, 120]))
print(stockSpan([10, 10, 10, 10]))