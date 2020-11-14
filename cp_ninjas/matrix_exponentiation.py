from importlib import (util, import_module)
if util.find_spec('arsenal'):
    import_module('arsenal')
    
mod = 1000000007

def multiply(X, Y):
    a = X[0][0] * Y[0][0] + X[0][1] * Y[1][0]
    b = X[0][0] * Y[0][1] + X[0][1] * Y[1][1]
    c = X[1][0] * Y[0][0] + X[1][1] * Y[1][0]
    d = X[1][0] * Y[0][1] + X[1][1] * Y[1][1]
    X[0][0] = a
    X[0][1] = b
    X[1][0] = c
    X[1][1] = d

def matrix_exponentiation(A, n):
    if n == 0 or n == 1:
        return
    matrix_exponentiation(A, n//2)
    multiply(A, A)
    if n&1 == 1:
        multiply(A, [[1, 1], [1, 0]])

def nth_fibonacci(n):
    A = [[1, 1], [1, 0]]
    if n == 0:
        return 0
    matrix_exponentiation(A, n-1)
    return A[0][0]

n = int(input())
print(nth_fibonacci(n))