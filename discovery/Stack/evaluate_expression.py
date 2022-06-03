from collections import deque

precedence = {
    '*': 2,
    '/': 2,
    '-': 1,
    '+': 1
}

operators = ['*', '/', '-', '+']

def infix_to_postfix(infix_expression):
    infix_expression = '(' + infix_expression + ')'
    stack = deque()
    result = ''
    for token in infix_expression:
        if token == '(':
            stack.append(token)
        elif token.isdigit():
            result += token
        elif token == ')':
            while True:
                if stack[-1] in operators:
                    result += stack.pop()
                elif stack[-1] == '(':
                    stack.pop()
                    break
        elif token in operators:
            while stack[-1] in operators and precedence[token] <= precedence[stack[-1]]:
                result += stack.pop()
            stack.append(token)
        else:
            pass
    return result

def evaluate_postfix(postfix_expression):
    stack = deque()
    for token in postfix_expression:
        if token.isdigit():
            stack.append(int(token))
        elif token in operators:
            second_operand = stack.pop()
            first_operand = stack.pop()
            if token == '-':
                stack.append(first_operand - second_operand)
            elif token == '+':
                stack.append(first_operand + second_operand)
            elif token == '/':
                stack.append(first_operand / second_operand)
            else:
                stack.append(first_operand * second_operand)
        else:
            pass
    return stack[-1]

print(infix_to_postfix('(1*2+3)/4*5-3'))
print(evaluate_postfix(infix_to_postfix('(1*2+3)/4*5-3')))
print(eval('(1*2+3)/4*5-3'))
