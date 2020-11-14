from importlib import util 
if util.find_spec('fio') is not None:
    import fio
    
mod = 1000000007

def sieve_of_eratosthenes(n):
    sieve = [1]*(n+1)
    sieve[0] = sieve[1] = 0
    for i in range(2, int(n**0.5)+1):
        if sieve[i]:
            for j in range(i**2, n+1, i):
                sieve[j] = 0
    return sieve

def primes(n):
    sieve = sieve_of_eratosthenes(n)
    result = list()
    result.append(2)
    for i in range (3, n+1, 2):
        if sieve[i]:
            result.append(i)
    return result

def fators_of_factorial(n):
    prime_list = primes(n)
    final = 1
    for prime in prime_list:
        temp = n
        factors = 0
        while temp >= prime:
            temp = int(temp/prime)
            factors = (factors + temp%mod)%mod
        final = (final * (factors + 1)%mod)%mod
    return final
            
n = int(input())
print(fators_of_factorial(n))
