from importlib import util 
if util.find_spec('fio') is not None:
    import fio

mod = 1000000007

def mod_expo_recursive(a, b):
    if b == 0:
        return 1
    if b % 2 == 0:
        return mod_expo_recursive((a * a) % mod, b//2)
    return (a * mod_expo_recursive(a, b-1)) % mod
    
            
a, b = map(int, input().split())
print(mod_expo_recursive(a, b))
